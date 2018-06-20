package cn.gukeer.platform.controller;

import cn.gukeer.classcard.util.ffmpeg.ConverVideoUtils;
import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.tld.GukeerStringUtil;
import cn.gukeer.common.utils.*;
import cn.gukeer.common.utils.img.ImgTools;
import cn.gukeer.platform.persistence.entity.User;
import cn.gukeer.platform.service.UserService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.StringMap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by conn on 2016/9/14.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BasicController {

    @Autowired
    UserService userService;

    ThreadFactory threadFactory = new ThreadFactoryBuilder().build();

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 6000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);

    Properties properties = PropertiesUtil.getProperties("api.properties");

    /**
     * 文件上传
     *
     * @param file
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultEntity uploads(@Param("file") MultipartFile file, HttpServletRequest request) throws Exception {
        FileOutputStream fos = null;
        InputStream fis = null;
        FileOutputStream thumbnailfos = null;
        String imgRequestUrl = "";
        String thumbnailUrl = "";
        String transformFinalUrl= "";
        try {
            String imgName = getParamVal(request, "imgName");
            if ("".equals(imgName)) {
                imgName = file.getOriginalFilename();
            }

            // 固定值  APP_DETAIL_PATH、USER_HEADERS_PATH 其他类别额外添加就行
            String imgPath = getParamVal(request, "imgPath");
            imgPath = imgPath + DateUtils.formatDate(new Date(), "yyyyMM") + "/";

            String fullPath = FileUtils.VFS_ROOT_PATH + imgPath;
            File dir = new File(fullPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String suffix = imgName.substring(imgName.lastIndexOf("."));
            String time = System.currentTimeMillis() + "";
            String fileName = time + suffix;
            String absPath = fullPath + fileName;
            imgRequestUrl = imgPath + fileName;

            fis = file.getInputStream();
            File f = new File(absPath);
            fos = new FileOutputStream(f);
            byte[] b = new byte[1024];
            int nRead = 0;
            while ((nRead = fis.read(b)) != -1) {
                fos.write(b, 0, nRead);
            }
            fos.flush();

            Map<String, String> pathMap = new HashMap<>();
            //图片处理
            if (imgPath.contains("/pic/")) {
                pathMap.put("fileCategory", "pic");
                try {
                    CommonsMultipartFile cf = (CommonsMultipartFile) file;
                    DiskFileItem fi = (DiskFileItem) cf.getFileItem();
                    File thumbnailfile = fi.getStoreLocation();

                    BufferedImage bi = ImageIO.read(thumbnailfile);
                    int srcWidth = bi.getWidth(); // 源图宽度
                    long size = fi.getSize();
                    //压缩大于500k图片
                    if (size >= 512000) {
                        String thumbnailpath = fullPath + "thumbnail";
                        File thumbnaildir = new File(thumbnailpath);
                        if (!thumbnaildir.exists()) {
                            thumbnaildir.mkdirs();
                        }
                        String thumbnailabsPath = fullPath + "thumbnail/" + time + ".jpg";
                        File outFile = new File(thumbnailabsPath);
                        thumbnailfos = new FileOutputStream(outFile);
                        ImgTools.thumbnail_w_h(thumbnailfile, srcWidth, 0, thumbnailfos);
                        thumbnailUrl = imgPath + "thumbnail/" + fileName;
                        thumbnailfos.flush();
                    }
                } catch (Exception e) {
                    logger.error("上传文件失败", e);
                } finally {
                    if (null != thumbnailfos) {
                        thumbnailfos.close();
                    }
                }
            }

            //视频处理
            String transformFinalPath="";
            if (imgPath.contains("/video/")) {
                pathMap.put("fileCategory", "video");

                //视频转换后存储路径
                String transformPath=fullPath + "transformVideo/";
                //视频截图路径
                String screenshotPath=fullPath + "screenshot/";
                File transforVideoPath = new File(transformPath);
                if (!transforVideoPath.exists()) {
                    transforVideoPath.mkdirs();
                }
                File transforScreenPath = new File(screenshotPath);
                if (!transforScreenPath.exists()) {
                    transforScreenPath.mkdirs();
                }
                //转换成MP4格式
                String targetExtension = (String) properties.get("targetExtension");
                //转换后是否删除源文件
                boolean isDelSourseFile = Boolean.parseBoolean((String) properties.get("isDelSourseFile"));
                ConverVideoUtils cv = new ConverVideoUtils(absPath, transformPath, screenshotPath);
                ConverVideo(targetExtension, isDelSourseFile, cv);

                //转换后文件相对路径名
                File fi = new File(absPath);
                String filename = fi.getName();
                String filerealname = filename.substring(0, filename.lastIndexOf(".")).toLowerCase();
                transformFinalUrl=imgPath+"transformVideo/"+filerealname+targetExtension;
            }
            pathMap.put("imgRequestUrl", imgRequestUrl);
            pathMap.put("thumbnailUrl", thumbnailUrl);
            pathMap.put("transformFinalUrl",transformFinalUrl);
            pathMap.put("fileName", imgName);
            return ResultEntity.newResultEntity(pathMap);
        } catch (Exception e) {
            logger.error("上传文件失败", e);
        } finally {
            fos.close();
            fis.close();
        }
        return ResultEntity.newErrEntity();
    }

    @RequestMapping(value = "/pic/show", method = RequestMethod.GET)
    public void showPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String picPath = getParamVal(request, "picPath");

        Object attr = request.getAttribute("picPath");
        if (!GukeerStringUtil.isNullOrEmpty(attr))
            picPath = attr.toString();

        File file = null;
        if (picPath != "") {
            if (picPath.indexOf(FileUtils.VFS_ROOT_PATH) >= 0) {
                file = new File(picPath);
            } else {
                file = new File(FileUtils.VFS_ROOT_PATH + picPath);
            }
        } else {
            String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/images/uploading-icon.png");
            file = new File(filePath);
        }

        if (!file.exists()) {
            if (picPath.indexOf("default_tou") >= 0) {
                String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/" + picPath);
                file = new File(filePath);
            } else if (picPath.indexOf("header") >= 0) {
                String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/images/default_tou.png");
                file = new File(filePath);
            } else {
                logger.error("找不到文件[" + FileUtils.VFS_ROOT_PATH + picPath + "]");
                String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/images/broken.jpg");
                file = new File(filePath);
            }
        }
        if (!file.exists()) return;      //再次判断，避免异常
        response.setContentType("multipart/form-data");
        InputStream reader = null;
        try {
            reader = VFSUtil.getInputStream(file, true);
            byte[] buf = new byte[1024];
            int len = 0;

            OutputStream out = response.getOutputStream();

            while ((len = reader.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            out.flush();
        } catch (Exception ex) {
            logger.error("显示图片时发生错误:" + ex.getMessage(), ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ex) {
                    logger.error("关闭文件流出错", ex);
                }
            }
        }
    }

    @RequestMapping(value = "/video/show", method = RequestMethod.GET)
    public void showVideo(HttpServletRequest request, HttpServletResponse response) throws Exception {


    }

    @ResponseBody
    @RequestMapping("/file/upload")
    public ResultEntity fileUp(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws ServletException, IOException {
        String savePath = FileUtils.VFS_ROOT_PATH + FileUtils.NOTIFY_ATTACH_PATH;

        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileOutputStream os = null;
        InputStream in = null;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty()) {
                try {
                    String fileName = new Date().getTime() + files[i].getOriginalFilename().replaceAll(" ", "");//去除文件名中的空格
                    os = new FileOutputStream(savePath + fileName);
                    in = files[i].getInputStream();
                    byte[] readBytes = new byte[1024];
                    while (in.read(readBytes) != -1) {
                        os.write(readBytes);
                    }
                    os.flush();
                    return ResultEntity.newResultEntity(savePath + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    os.close();
                    in.close();
                }
            }
        }
        return ResultEntity.newErrEntity();
    }

    @RequestMapping("/downLoad")
    public void fileDownLoad(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        String fileUrl = getParamVal(request, "fileUrl");
        fileUrl = java.net.URLDecoder.decode(fileUrl, "UTF-8");//解决非post访问的中文乱码问题。
        File file = new File(fileUrl);
        if (!file.exists()) {
            logger.error("找不到文件[" + fileUrl + "]");
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileUrl);
        try {
            InputStream inputStream = new FileInputStream(new File(fileUrl));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/pic/download/{account}", method = RequestMethod.GET)
    public void downLoadPicture(HttpServletRequest request, HttpServletResponse response, @PathVariable String account) throws Exception {

        User user = userService.getUserByAccount(account);
        if (user != null)
            request.setAttribute("picPath", user.getPhotoUrl());
        else
            request.setAttribute("picPath", "images/default_tou.png");
        showPicture(request, response);

    }

    @RequestMapping("/play")
    public void playVideo(HttpServletRequest request, HttpServletResponse response, String contextPath) throws IOException {
        String picPath = request.getQueryString();
        try {
            System.out.println("请求下载的连接地址为：" + request.getQueryString());
        } catch (IllegalArgumentException e) {
            System.out.println("请求下载的文件名参数为空！");
            return;
        }
        File downloadFile = null;
        if (picPath != "") {
            if (picPath.indexOf(FileUtils.VFS_ROOT_PATH) >= 0) {
                downloadFile = new File(picPath);
            } else {
                downloadFile = new File(FileUtils.VFS_ROOT_PATH + picPath);
                System.out.println("文件拼装路径：" + FileUtils.VFS_ROOT_PATH + picPath);
            }
        } else {
            String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/images/uploading-icon.png");
            downloadFile = new File(filePath);
        }

        if (downloadFile.exists()) {
            if (downloadFile.isFile()) {
                if (downloadFile.length() > 0) {
                } else {
                    System.out.println("请求下载的文件是一个空文件");
                    return;
                }
                if (!downloadFile.canRead()) {
                    System.out.println("请求下载的文件不是一个可读的文件");
                    return;
                } else {
                }
            } else {
                System.out.println("请求下载的文件是一个文件夹");
                return;
            }
        } else {
            System.out.println("请求下载的文件不存在！");
            return;
        }

        long fileLength = downloadFile.length(); // 记录文件大小
        long pastLength = 0; // 记录已下载文件大小
        int rangeSwitch = 0; // 0：从头开始的全文下载；1：从某字节开始的下载（bytes=27000-）；2：从某字节开始到某字节结束的下载（bytes=27000-39000）
        long toLength = 0; // 记录客户端需要下载的字节段的最后一个字节偏移量（比如bytes=27000-39000，则这个值是为39000）
        long contentLength = 0; // 客户端请求的字节总量
        String rangeBytes = ""; // 记录客户端传来的形如“bytes=27000-”或者“bytes=27000-39000”的内容
        RandomAccessFile raf = null; // 负责读取数据
        OutputStream os = null;
        OutputStream out = null; // 缓冲
        byte b[] = new byte[1024]; // 暂存容器

        System.out.println(request.getHeader("Range") + "sssssssssssssss");
        if (request.getHeader("Range") != null) { // 客户端请求的下载的文件块的开始字节
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT);
            System.out.println("request.getHeader(\"Range\")=" + request.getHeader("Range"));
            rangeBytes = request.getHeader("Range").replaceAll("bytes=", "");
            if (rangeBytes.indexOf('-') == rangeBytes.length() - 1) {// bytes=969998336-
                rangeSwitch = 1;
                rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                pastLength = Long.parseLong(rangeBytes.trim());
                contentLength = fileLength - pastLength; // 客户端请求的是 969998336
                // 之后的字节
            } else { // bytes=1275856879-1275877358
                rangeSwitch = 2;
                String temp0 = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                String temp2 = rangeBytes.substring(rangeBytes.indexOf('-') + 1, rangeBytes.length());
                pastLength = Long.parseLong(temp0.trim()); // bytes=1275856879-1275877358，从第
                // 1275856879
                // 个字节开始下载
                toLength = Long.parseLong(temp2); // bytes=1275856879-1275877358，到第
                // 1275877358 个字节结束
                contentLength = toLength - pastLength; // 客户端请求的是
                // 1275856879-1275877358
                // 之间的字节
            }
        } else { // 从开始进行下载
            contentLength = fileLength; // 客户端要求全文下载
        }

        /**
         * 如果设设置了Content -Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。 响应的格式是:
         * Content - Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
         * ServletActionContext.getResponse().setHeader("Content- Length", new
         * Long(file.length() - p).toString());
         */
        response.reset(); // 告诉客户端允许断点续传多线程连接下载,响应的格式是:Accept-Ranges: bytes
        response.setHeader("Accept-Ranges", "bytes");// 如果是第一次下,还没有断点续传,状态是默认的
        // 200,无需显式设置;响应的格式是:HTTP/1.1
        // 200 OK
        if (pastLength != 0) {
            // 不是从最开始下载,
            // 响应的格式是:
            // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
            System.out.println("----------------------------不是从开始进行下载！服务器即将开始断点续传...");
            switch (rangeSwitch) {
                case 1: { // 针对 bytes=27000- 的请求
                    String contentRange = new StringBuffer("bytes ").append(new Long(pastLength).toString()).append("-")
                            .append(new Long(fileLength - 1).toString()).append("/").append(new Long(fileLength).toString())
                            .toString();
                    response.setHeader("Content-Range", contentRange);
                    break;
                }
                case 2: { // 针对 bytes=27000-39000 的请求
                    String contentRange = rangeBytes + "/" + new Long(fileLength).toString();
                    response.setHeader("Content-Range", contentRange);
                    break;
                }
                default: {
                    break;
                }
            }
        } else {
            // 是从开始下载
            System.out.println("----------------------------是从开始进行下载！");
        }

        try {
            //response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
            String contentTypeName = downloadFile.getName();
//            "application/x-mpegurl"
            response.setContentType("application/x-mpegurl");           //高速客户端数据返回的类型,该格式安卓/IOS均可以识别实现在线缓存播放

            response.addHeader("Content-Length", String.valueOf(contentLength));
            response.addHeader("Connection", "keep-alive");

            os = response.getOutputStream();
            out = new BufferedOutputStream(os);
            raf = new RandomAccessFile(downloadFile, "r");
            try {
                switch (rangeSwitch) {
                    case 0: { // 普通下载，或者从头开始的下载
                        // 同1
                    }
                    case 1: { // 针对 bytes=27000- 的请求
                        raf.seek(pastLength); // 形如 bytes=969998336- 的客户端请求，跳过
                        // 969998336 个字节
                        int n = 0;
                        while ((n = raf.read(b, 0, 1024)) != -1) {
                            out.write(b, 0, n);
                        }
                        break;
                    }
                    case 2: { // 针对 bytes=27000-39000 的请求
                        raf.seek(pastLength); // 形如 bytes=1275856879-1275877358
                        // 的客户端请求，找到第 1275856879 个字节
                        int n = 0;
                        long readLength = 0; // 记录已读字节数
                        while (readLength <= contentLength - 1024) {// 大部分字节在这里读取
                            n = raf.read(b, 0, 1024);
                            readLength += 1024;
                            out.write(b, 0, n);
                        }
                        if (readLength <= contentLength) { // 余下的不足 1024 个字节在这里读取
                            n = raf.read(b, 0, (int) (contentLength - readLength));
                            out.write(b, 0, n);
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
                out.flush();
                System.out.println("------------------------------下载结束");
            } catch (IOException ie) {
                /**
                 * 在写数据的时候， 对于 ClientAbortException 之类的异常，
                 * 是因为客户端取消了下载，而服务器端继续向浏览器写入数据时， 抛出这个异常，这个是正常的。
                 * 尤其是对于迅雷这种吸血的客户端软件， 明明已经有一个线程在读取 bytes=1275856879-1275877358，
                 * 如果短时间内没有读取完毕，迅雷会再启第二个、第三个。。。线程来读取相同的字节段， 直到有一个线程读取完毕，迅雷会 KILL
                 * 掉其他正在下载同一字节段的线程， 强行中止字节读出，造成服务器抛 ClientAbortException。
                 * 所以，我们忽略这种异常
                 */
                // ignore
                ie.printStackTrace();
                System.out.println("#提醒# 向客户端传输时出现IO异常，但此异常是允许的的，有可能客户端取消了下载，导致此异常，不用关心！");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void ConverVideo(final String targetExtension, final boolean isDelSourseFile, final ConverVideoUtils converVideoUtils) {
        Runnable convertTask = new Runnable() {
            @Override
            public void run() {
                try {
                    boolean beginConver = converVideoUtils.beginConver(targetExtension, isDelSourseFile);
                    System.out.println(beginConver);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        threadPoolExecutor.execute(convertTask);
    }

    /*
    *七牛
    */
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        String ACCESS_KEY = (String) properties.get("ACCESS_KEY");
        String SECRET_KEY = (String) properties.get("SECRET_KEY");
        //要上传的空间
        String bucketname = "classcard-app";
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        StringMap putPolicy = new StringMap();
        putPolicy.put("fsizeMin", 1024)                     //文件大小最小为 1KB
                .put("fsizeLimit", 1024 * 1024 * 10)       //文件大小最大为 10M
                .putNotEmpty("mimeType", "image/jpg");     //文件类型为jpg图片, 所有图片 设置为 image/*
        //获取upload token， 在token中设置上传策略中的 fsizeMin, fsizeLimit, mimeType
        return auth.uploadToken(bucketname/*"@@",3600,putPolicy*/);
    }

    @RequestMapping(value = "/getuptoken", method = RequestMethod.GET)
    @ResponseBody
    public void makeToken(HttpServletResponse response, HttpServletRequest request) {
        String uptoken = null;
        try {
            uptoken = getUpToken();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uptoken", uptoken);
            System.out.print(jsonObject);
            response.getWriter().print(jsonObject);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "kindeditor/upload")
    public Object kindeditorUpload(HttpServletRequest request,HttpServletResponse response){
        String savePath = FileUtils.VFS_ROOT_PATH + "kindeditor/";
        //定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

        //最大文件大小
        long maxSize = 1000000;

        //response.setContentType("text/html; charset=UTF-8");
        if (!ServletFileUpload.isMultipartContent(request)) {
            return ResultEntity.newErrEntity("请选择文件。");
        }
        //检查目录
        File uploadDir = new File(savePath);
        if (!uploadDir.isDirectory()) {
            uploadDir.mkdirs();
        }
        //检查目录写权限
        if (!uploadDir.canWrite()) {
            return ResultEntity.newErrEntity("上传目录没有写权限。");
        }

        String dirName = request.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if (!extMap.containsKey(dirName)) {
            return ResultEntity.newErrEntity("目录名不正确。");
        }
        //创建文件夹
        savePath += dirName + "/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path=savePath+System.currentTimeMillis()+"_"+file.getOriginalFilename();
                    File file1=new File(path);
                    if (!file1.exists()) {
                        file1.mkdirs();
                    }
                    //上传
                    try {
                        file.transferTo(file1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JsonObject obj = new JsonObject();
                    obj.addProperty("error", 0);
                    obj.addProperty("url", request.getContextPath()+"/file/pic/show?picPath="+path);
                    try (PrintWriter writer = response.getWriter()){
                        Gson gson = new Gson();
                        writer.write(gson.toJson(obj));
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "downloadzip")
    public ResultEntity downloadZip(HttpServletRequest request,HttpServletResponse response){
        String htmlPath= getParamVal(request,"htmlPath");


        /** 1.创建临时文件夹  */
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        File temDir = new File(rootPath + "/" + UUID.randomUUID().toString().replaceAll("-", ""));
        if(!temDir.exists()){
            temDir.mkdirs();
        }

        /** 2.生成需要下载的文件，存放在临时文件夹内 */
        // 这里我们直接来10个内容相同的文件为例，但这个10个文件名不可以相同
       /* for (int i = 0; i < 10; i++) {
            dataMap.put("userList", userList);
            Map<String, String> endMap = new HashMap<>();
            endMap.put("user", "老王");
            endMap.put("time", "2017-10-10 10:50:55");
            dataMap.put("endMap", endMap);
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            cfg.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/ftl");
            Template template = cfg.getTemplate("exportExcel.ftl");
            writer = new FileWriter(temDir.getPath()+"/excel"+ i +".xls");
            template.process(dataMap, writer);
            writer.flush();
            writer.close();
        }*/

        /** 3.设置response的header */
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=html.zip");

        /** 4.调用工具类，下载zip压缩包 */
        // 这里我们不需要保留目录结构
        try {
            ZipUtils.toZip(htmlPath, response.getOutputStream(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** 5.删除临时文件和文件夹 */
        // 这里我没写递归，直接就这样删除了
      /*  File[] listFiles = temDir.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            listFiles[i].delete();
        }
        temDir.delete();*/


        return null;
    }
}
// TODO: 18-4-9  编辑器错误的返回值 