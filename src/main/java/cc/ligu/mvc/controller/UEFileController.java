package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.utils.FileUtils;
import cc.ligu.common.utils.VFSUtil;
import cc.ligu.common.utils.ZipUtils;
import cc.ligu.common.utils.ffmpeg.ConvertVideoUtils;
import cc.ligu.mvc.common.QtFastStart;
import com.github.pagehelper.StringUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zjy on 2018/5/14.
 */
@Controller
@RequestMapping(value = "/ueFile")
public class UEFileController extends BasicController {


    @RequestMapping(value = "/ueUpload")
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {

        return "uejsp/controller";

    }

    /**
     * ueditor上传图片的方法
     *
     * @param upfile   上传图片的文件
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadNewsImg(@RequestParam(value = "upfile", required = false) MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
        Date date = new Date();
        String upLoadPath = FileUtils.VFS_ROOT_PATH + FileUtils.UE_ATTACH + new SimpleDateFormat("yyyy\\MM\\").format(date);
        String path = upLoadPath;
        //图片后缀
        String last = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."), upfile.getOriginalFilename().length());

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + last;

        File fileT = new File(path, fileName);
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            upfile.transferTo(fileT);
        } catch (IllegalStateException e) {
            logger.error("富文本编辑器图片上传失败，参数异常：" + e);
        } catch (IOException e1) {
            logger.error("富文本编辑器图片上传失败io异常：" + e1);
        }
        result.put("state", "SUCCESS");
        result.put("url", upLoadPath.replace("\\", "/") + fileName);
        result.put("original", "");
        result.put("type", last);
        result.put("size", upfile.getSize());
        result.put("title", fileName);
        return result;
    }


    /**
     * ueditor文件上传方法
     *
     * @param upfile
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam(value = "upfile", required = false) MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
        Date date = new Date();
        String upLoadPath = FileUtils.VFS_ROOT_PATH + FileUtils.UE_ATTACH + new SimpleDateFormat("yyyy\\MM\\").format(date);
        String path = upLoadPath;
        //附件后缀
        String last = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."), upfile.getOriginalFilename().length());

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + last;

        File fileT = new File(path, fileName);
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            upfile.transferTo(fileT);
        } catch (IllegalStateException e) {
            logger.error("富文本编辑器文件上传失败，参数异常：" + e);
        } catch (IOException e1) {
            logger.error("富文本编辑器文件上传失败io异常：" + e1);
        }
        result.put("state", "SUCCESS");
        result.put("url", upLoadPath.replace("\\", "/") + fileName);
        result.put("original", "");
        result.put("type", last);
        result.put("size", upfile.getSize());
        result.put("title", fileName);
        return result;
    }


    /**
     * ueditor上传图片的方法
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadRemoteImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadRemoteImg(HttpServletRequest request, HttpServletResponse response) {
        String[] sources = request.getParameterValues("source[]");

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list",uploadRemoteFileToLocal(sources));
        result.put("state","SUCCESS");
        return result;

    }

    public List<Map<String, Object>> uploadRemoteFileToLocal(String[] sources) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < sources.length; i++) {
            String source = sources[i];
            if (StringUtil.isNotEmpty(source)) {
                try {
                    URL url = new URL(source);
                    HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
                    httpUrl.setConnectTimeout(3000);
                    InputStream inputStream = null;

                    Date date = new Date();
                    String requestPath = FileUtils.UE_REMOTE_ATTACH +"/"+ new SimpleDateFormat("yyyy-MM").format(date)+"/";
                    String upLoadPath = FileUtils.VFS_ROOT_PATH + requestPath;
                    //附件后缀
                    String last = source.substring(source.lastIndexOf("."), source.length());
                   if (last.indexOf("?")>=0){
                       last = last.substring(0,last.indexOf("?"));//去掉文件结尾参数
                   }
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    String fileName = uuid + last;

                    // 正常响应时获取输入流, 在这里也就是图片对应sq的字节流
                    if (httpUrl.getResponseCode() == 200) {
                        inputStream = httpUrl.getInputStream();
                        System.out.println(inputStream.available());
                    }

                    byte[] buffer = new byte[1024];
                    int length = 0;

                    File dirFile = new File(upLoadPath);
                    if (!dirFile.exists()){
                        dirFile.mkdirs();
                    }
                    // 这里是输出到工程根目录下
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(upLoadPath+fileName));

                    // 将输入流循环写到关联文件的输出流
                    while ((length = inputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, length);
                    }
                    inputStream.close();
                    fileOutputStream.close();

                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("source", source);
                    map.put("url", requestPath + fileName);
                    map.put("state", "SUCCESS");
                    result.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }
        return result;
    }

}
// TODO: 18-4-9  编辑器错误的返回值