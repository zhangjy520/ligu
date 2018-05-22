package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.tld.GukeerStringUtil;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.common.utils.FileUtils;
import cc.ligu.common.utils.VFSUtil;
import cc.ligu.mvc.service.UserService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by conn on 2016/9/14.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BasicController {

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
        String thumbnailUrl="";
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
            String time=System.currentTimeMillis()+"";
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
            pathMap.put("imgRequestUrl", imgRequestUrl);
            pathMap.put("thumbnailUrl", thumbnailUrl);
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
                String filePath = request.getSession().getServletContext().getRealPath("/assetsNew/images/brokenimg.png");
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

    //wenj1
    @ResponseBody
    @RequestMapping("/file/upload")
    public ResultEntity fileUp(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws ServletException, IOException {
        String savePath = FileUtils.VFS_ROOT_PATH;

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


}
