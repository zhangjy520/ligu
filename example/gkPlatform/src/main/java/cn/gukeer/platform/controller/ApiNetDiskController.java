package cn.gukeer.platform.controller;

import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.security.MD5Utils;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.common.utils.RedisUtil;
import cn.gukeer.platform.common.NetDiskUtil;
import cn.gukeer.platform.common.RedisKeyUtil;
import cn.gukeer.platform.common.ShareType;
import cn.gukeer.platform.persistence.entity.*;
import cn.gukeer.platform.service.NetDiskService;
import cn.gukeer.platform.service.TeacherService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.*;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sun.nio.ch.Net;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.*;

/**
 * Created by LL on 2017/12/15.
 */

@Controller
@RequestMapping(value = "/api/netdisk")
public class ApiNetDiskController extends BasicController {
    @Resource
    JedisPool jedisPool;

    @Autowired
    NetDiskService netDiskService;

    @Autowired
    TeacherService teacherService;


    Properties properties = PropertiesUtil.getProperties("api.properties");
    String seaFileServer = (String) properties.get("seaFileServer");
    String seafileDownload = (String) properties.get("seafileDownload");
    //分享的接口
    /*
   *   路径：http://localhost:8081/gkPlatform/api/netdisk/share
   *   method:post
   *   参数：
   *       teacehrId ：当前登陆教师的id
   *       chooseId:被分享教师的id,多个的时候一逗号隔开
   *       schoolId：当前学校的id
   *       directoryPath：资料库路径即可，例如资料库a目录中下文件a.txt  则该参数传 /a.txt
                          例如资料库a目录中下文件夹B下的a.txt  则该参数传 /B/a.txt
   *       arr:选择的将要分享的文件，
   *           传输格式为数组格式（fileName：文件的名字；fileType：文件类型为dir文件夹  file为文件）
   *           [{"fileName": fileName, "fileType": fileType},{"fileName": fileName, "fileType": fileType}]
   *
   *    返回值 {code: 0, msg: "分享成功", data: Array(6)}
   *            返回值data的Array（数组）的格式以及内容：
   *            {id: "1105265b4f50e559dd4519f2b3a38129",
   *            schoolId: "b14e6ff4d716906e7db294699bc8ba54",
   *            teacherId: "8515cc7aa9eb485aac92a1f816b0f1b9",
   *            sharedTeacherId: null,
   *            shareType: 0,          //0表示分享  1表示被分享
   *            canDownlod:true,        //true可以下载
   *            canPreview:true,         //全部为false不可预览
   *            createTime:1513303474009,
   *            timeStrCreate:"2017-12-15",//与（createTime）字段对应 只不过格式不同 表示同一个时间
   *            email:"admin@team.com",
   *            expireDate:null,
   *            fileName:"2.jpg",
   *            isDir:false,                    //是否为文件夹
   *            isExpired:null,
   *            link:"http://120.27.46.200:60001/f/53767a1653114fc186cd/",  //下载路径
   *            path:"/2.jpg",        文件的路径
   *            repoName:"aaa",     //资料库的名称
   *            timeStrUpdate:null,
   *            token:"53767a1653114fc186cd"
   *            }
   *
   * */
    @ResponseBody
    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public ResultEntity share(HttpServletRequest request) {
        int succ = 0;
        Logger log = LoggerFactory.getLogger(ApiNetDiskController.class);

        try {
            log.info("分享的请求进来了========================");
            String choosesId = getParamVal(request, "chooseId");
            if (StringUtils.isEmpty(choosesId)) {
                return ResultEntity.newErrEntity("请填写所要被分享教师的id");
            }

            String schoolId = getParamVal(request, "schoolId");
            if (StringUtils.isEmpty(schoolId)) {
                return ResultEntity.newErrEntity("请传入学校的id");
            }

            String teacehrId = getParamVal(request, "teacehrId");
            if (StringUtils.isEmpty(teacehrId)) {
                return ResultEntity.newErrEntity("请填写当前教师的id");
            }
            Teacher teacher = teacherService.findTeacherById(teacehrId);
            String email = teacher.getAccount() + ".com";

            String[] chooseIdArr = null;
            if (StringUtils.isNotEmpty(choosesId)) {
                chooseIdArr = choosesId.split(",");
            }

            String arr = new String(request.getParameter("arr").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("arr=====" + arr);
            if (StringUtils.isEmpty(arr)) {
                return ResultEntity.newErrEntity("请选择您要分享的文件");
            }
            //资料库路径即可，例如资料库a目录中下文件a.txt  则该参数传 /a.txt
            //资料库路径即可，例如资料库a目录中下文件夹B下的a.txt  则该参数传 /B/a.txt
            String directoryPath = new String(request.getParameter("directoryPath").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("directoryPath收到啦" + directoryPath);
            if (StringUtils.isEmpty(directoryPath)) {
                return ResultEntity.newErrEntity("请选择您要分享文件的路径");
            }
            Jedis resource = jedisPool.getResource();
            String token = new NetDiskUtil().acuireToken(email, RedisKeyUtil.netDiskKeyTokenPrefix + email,resource);
            if (StringUtils.isEmpty(token)) {
                return ResultEntity.newErrEntity("网盘密钥异常，请联系管理员");
            }

            String repositoryId = new NetDiskUtil().acquireRepository("", token, RedisKeyUtil.netDiskKeyRepositoryPrefix + email,resource,email);
            if (StringUtils.isEmpty(repositoryId)) {
                return ResultEntity.newErrEntity("仓库地址为空，请联系管理员");
            }
            RedisUtil.returnResource(resource);

            Gson gson = new Gson();
            List<SelectedFile> selectedFiles = gson.fromJson(arr, new TypeToken<List<SelectedFile>>() {
            }.getType());
            Response response = null;
            String rst = "";
            List<NetDiskShareLink> netDiskShareLinkList = new ArrayList<>();
            Map<String, String> netDiskLinksDbmap = netDiskService.findAllSharedBySchoolId(schoolId);

            if (selectedFiles != null && selectedFiles.size() > 0) {
                netDiskShareLinkList = NetDiskUtil.bathNetDiskShareLink(teacehrId, selectedFiles, directoryPath, repositoryId, token, chooseIdArr, netDiskLinksDbmap, schoolId);
                System.out.println("封装完毕等待入库");
                if (null != netDiskShareLinkList && netDiskShareLinkList.size() > 0) {
                    System.out.println("入库前controller");
                    System.out.println("入库前netDiskShareLinkList" + netDiskShareLinkList.toString());
                    netDiskService.batchInsertNetDiskShareLinks(netDiskShareLinkList);
                    System.out.println("入库后");
                    succ = 1;
                } else {
                    return ResultEntity.newErrEntity("请确认要分享的信息是否存在或者已经分享过了");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("判断succ返回");
        if (succ > 0) {
            return ResultEntity.newResultEntity("分享成功");
        } else {
            return ResultEntity.newErrEntity("分享失败");
        }
    }

    //分享下载接口
    /*
    *   路径：/api/netdisk/share/download
    *   method:post
    *   参数：
    *       ids ：分享的所有文件的id
    *   返回值：
    * */
    @ResponseBody
    @RequestMapping(value = "/share/download", method = RequestMethod.POST)
    public ResultEntity shareDownLoad(HttpServletRequest request) {
        String ids = getParamVal(request, "ids");
        try {
            if (StringUtils.isEmpty(ids)) {
                return ResultEntity.newErrEntity("请选择要下載的文件");
            }
            String[] arrIds = ids.split(",");
            List<NetDiskShareLink> netDiskShareLinks = netDiskService.findNetDiskShareLinkByIds(arrIds);
            if (null != netDiskShareLinks && netDiskShareLinks.size() > 0) {
                for (NetDiskShareLink netDiskShareLink : netDiskShareLinks) {
                    String link = netDiskShareLink.getLink();
                    Boolean isDir = netDiskShareLink.getIsDir();
                    String token = netDiskShareLink.getToken();
                    link = NetDiskUtil.getLink(isDir, link, token);
                    netDiskShareLink.setLink(link);
                }
                return ResultEntity.newResultEntity(JSON.toJSON(netDiskShareLinks));
            } else {
                return ResultEntity.newErrEntity("您需要的数据不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newResultEntity("");
        }
    }


    @ResponseBody
    @RequestMapping(value = "/share/type", method = RequestMethod.POST)
    public ResultEntity getShareFiles(HttpServletRequest request) {
        List<NetDiskShareLink> netDiskShareLinks = new ArrayList<>();
        try {
            String teacehrId = request.getParameter("teacherId");
            if (StringUtils.isEmpty(teacehrId)) {
                return ResultEntity.newErrEntity("请填写当前教师的id");
            }

            String _type = getParamVal(request, "type");
            if (StringUtils.isEmpty(_type)) {
                return ResultEntity.newErrEntity("请传入分享文件的类型");
            }
            Integer type = Integer.parseInt(_type);

            netDiskShareLinks = netDiskService.findNetDiskShareLinkByShareTypeAndTeacherId(teacehrId, type);
            if (null != netDiskShareLinks && netDiskShareLinks.size() > 0) {
                for (NetDiskShareLink netDiskShareLink : netDiskShareLinks) {
                    netDiskShareLink.setTimeStrCreate(longToString(netDiskShareLink.getCreateTime(), "yyyy-MM-dd"));
                }
                return ResultEntity.newResultEntity(netDiskShareLinks);
            } else {
                return ResultEntity.newResultEntity("nodata");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newErrEntity();
    }


    /*
    * 放入回收站的接口，(同时也为回收站文件还原的接口，调用还原接口时候，directoryPath参数永远为 /）
    * 路径：/api/netdisk/recycle
    * method:post
    * 参数：
    *       teacherId ：当前登陆教师的id
    *       directoryPath: 当前要移动的文件或者文件夹的路径 例如资料库目录下的A文件夹下的a.txt文件，则该参数值:/A,后面的路径一次类推/A/B/cc.txt
    *       arr:当前要移动文件夹或者问价的数组{"fileName": fileName, "fileType": fileType} 前端格式
    * */
    @ResponseBody
    @RequestMapping(value = "/recycle", method = RequestMethod.POST)
    public ResultEntity move(HttpServletRequest request) throws ParseException {
        Jedis resource = jedisPool.getResource();
        try {
//            request.setCharacterEncoding("utf-8");
            System.out.println("=========客户端的characterEncoding======" + request.getCharacterEncoding());
            String operation = getParamVal(request, "operation");
            if (StringUtils.isEmpty(operation)) {
                return ResultEntity.newErrEntity("请传入操作参数");
            }

            String teacehrId = getParamVal(request, "teacherId");
            if (StringUtils.isEmpty(teacehrId)) {
                return ResultEntity.newErrEntity("请填写当前教师的id");
            }
            Teacher teacher = teacherService.findTeacherById(teacehrId);
            String email = teacher.getAccount() + ".com";
            if (null == teacher) {
                return ResultEntity.newErrEntity("当前教师的id不正确");
            }
//            String arr = request.getParameter("arr");
//            String directoryPath = request.getParameter("directoryPath");
//            String directoryPath  =new String(request.getParameter("directoryPath").getBytes());
            String directoryPath = new String(request.getParameter("directoryPath").getBytes("iso-8859-1"), "UTF-8");
            System.out.println("directoryPath放入回收站的" + directoryPath);
//            System.out.println("directoryPath++++decode放入回收站的" + URLDecoder.decode(directoryPath,"utf-8"));
            String arr = new String(request.getParameter("arr").getBytes("iso-8859-1"), "UTF-8");
            //           String arr = new String(request.getParameter("arr").getBytes("iso-8859-1"), "GBK");
            // String arr = new String(request.getParameter("arr").getBytes("gb2312"), "iso-8859-1");
//            String arr = new String(request.getParameter("arr").getBytes());
            System.out.println("arr=====放入回收站的====" + arr);
            if (StringUtils.isEmpty(arr)) {
                return ResultEntity.newErrEntity("请告诉我您要放入回收站的文件哦~");
            }


            String token = new NetDiskUtil().acuireToken(email, RedisKeyUtil.netDiskKeyTokenPrefix + email,resource);
            if (StringUtils.isEmpty(token)) {
                return ResultEntity.newErrEntity("网盘密钥异常，请联系管理员");
            }
            String repositoryId = new NetDiskUtil().acquireRepository("", token, RedisKeyUtil.netDiskKeyRepositoryPrefix + email,resource, email);
            if (StringUtils.isEmpty(repositoryId)) {
                return ResultEntity.newErrEntity("仓库地址为空，请联系管理员");
            }


            Gson gson = new Gson();
            List<SelectedFile> selectedFiles = gson.fromJson(arr, new TypeToken<List<SelectedFile>>() {
            }.getType());
            if (selectedFiles != null && selectedFiles.size() > 0) {
                String url = seaFileServer + "api2/repos/" + repositoryId + "/fileops/move/?p=" + directoryPath;
                String names = "";
                int index = 1;

                for (SelectedFile selectedFile : selectedFiles) {
                    String fileName = selectedFile.getFileName();
                    if (index == selectedFiles.size()) {
                        names += fileName;
                    } else {
                        names += fileName + ":";
                    }
                    index++;
                }

                String destination = "";
                if (operation.equals("put")) {
                    destination = "回收站";
                } else {
                    destination = "/";
                }
                OkHttpClient httpClient = new OkHttpClient();
                FormBody.Builder params = new FormBody.Builder();
                params.add("file_names", names);
                params.add("dst_repo", repositoryId);
                params.add("dst_dir", destination);//目标路径
                params.add("p", "/");//当前要移动的文件的路径

                Request requestDelDir = new Request.Builder()
                        .header("Authorization", "Token " + token)
                        .header("Accept", "application/json; indent=4")
                        .post(params.build())
                        .url(url)
                        .build();
                Response response = httpClient.newCall(requestDelDir).execute();
                System.out.println(response.body().string().toString());
                if (response.isSuccessful()) {
                    return ResultEntity.newResultEntity("success");
                } else {
                    return ResultEntity.newErrEntity("fail");
                }
            } else {
                return ResultEntity.newErrEntity("没有数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity();
        }finally {
            RedisUtil.returnResource(resource);
        }
    }


    /*
   * 回收站文件删除接口
   * 路径：/api/netdisk/delete
   * method:post
   * 参数：
   *       teacherId ：当前登陆教师的id
   *       directoryPath: 当前要删除的文件或者文件夹的路径 例如资料库目录下的A文件夹下的a.txt文件，则该参数值:/A，后面的路径一次类推/A/B/
   *       arr:当前要移动文件夹或者文件的数组{"fileName": fileName, "fileType": fileType}
   * */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultEntity delete(HttpServletRequest request) throws Exception {
        Jedis resource = jedisPool.getResource();
        try {
            String teacehrId = getParamVal(request, "teacherId");
            if (StringUtils.isEmpty(teacehrId)) {
                return ResultEntity.newErrEntity("请填写当前教师的id");
            }
            Teacher teacher = teacherService.findTeacherById(teacehrId);
            String email = teacher.getAccount() + ".com";
            if (null == teacher) {
                return ResultEntity.newErrEntity("当前教师的id不正确");
            }


            String token = new NetDiskUtil().acuireToken(email, RedisKeyUtil.netDiskKeyTokenPrefix + email,resource);
            if (StringUtils.isEmpty(token)) {
                return ResultEntity.newErrEntity("网盘密钥异常，请联系管理员");
            }
            String repositoryId = new NetDiskUtil().acquireRepository("", token, RedisKeyUtil.netDiskKeyRepositoryPrefix + email,resource,email);
            if (StringUtils.isEmpty(repositoryId)) {
                return ResultEntity.newErrEntity("仓库地址为空，请联系管理员");
            }
            String arr = new String(request.getParameter("arr").getBytes("ISO-8859-1"), "UTF-8");
//            String arr = request.getParameter("arr");
            System.out.println("回收站文件删除arr================" + arr);
            Gson gson = new Gson();
            List<SelectedFile> selectedFiles = gson.fromJson(arr, new TypeToken<List<SelectedFile>>() {
            }.getType());

            if (selectedFiles != null && selectedFiles.size() > 0) {
                String url = seaFileServer + "/api2/repos/" + repositoryId + "/fileops/delete/?p=/回收站";
                String names = "";
                int index = 1;
                OkHttpClient httpClient = new OkHttpClient();
                FormBody.Builder params = new FormBody.Builder();
                for (SelectedFile selectedFile : selectedFiles) {
                    String fileName = selectedFile.getFileName();
                    if (index == selectedFiles.size()) {
                        names += fileName;
                    } else {
                        names += fileName + ":";
                    }
                    index++;
                }

                params.add("file_names", names);
                Request requestDelDir = new Request.Builder()
                        .header("Authorization", "Token " + token)
                        .post(params.build())
                        .url(url)
                        .build();
                Response response = httpClient.newCall(requestDelDir).execute();
                System.out.println("删除成功" + response.body().string());
                if (response.isSuccessful()) {
                    return ResultEntity.newResultEntity("success");
                } else {
                    return ResultEntity.newErrEntity("fail");
                }
            } else {
                return ResultEntity.newErrEntity("没有数据");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("删除失败");
        }finally {
            RedisUtil.returnResource(resource);
        }
    }


    /*
    *  查看回收站文件夹下的文件
    *路径：http://localhost:8081/gkPlatform/api/netdisk/dir/files
   * method:post
   * 参数：
   *       teacherId ：当前登陆教师的id
    * */
    @ResponseBody
    @RequestMapping(value = "/dir/fils", method = RequestMethod.POST)
    public ResultEntity dirFiles(HttpServletRequest request) throws ParseException {
        String teacehrId = getParamVal(request, "teacherId");
        if (StringUtils.isEmpty(teacehrId)) {
            return ResultEntity.newErrEntity("请填写当前教师的id");
        }

        Teacher teacher = teacherService.findTeacherById(teacehrId);
        String email = teacher.getAccount() + ".com";
        Map map = new HashedMap();
        Jedis resource = jedisPool.getResource();
        String token = new NetDiskUtil().acuireToken(email, RedisKeyUtil.netDiskKeyTokenPrefix + email,resource);

        if (StringUtils.isEmpty(token)) {
            return ResultEntity.newErrEntity("网盘密钥异常，请联系管理员");
        }

        String repositoryId = new NetDiskUtil().acquireRepository("", token, RedisKeyUtil.netDiskKeyRepositoryPrefix + email,resource,email);
        if (StringUtils.isEmpty(repositoryId)) {
            return ResultEntity.newErrEntity("仓库地址为空，请联系管理员");
        }
        RedisUtil.returnResource(resource);
        String url = seaFileServer + "api2/repos/" + repositoryId + "/" + "dir/?p=/回收站/";

        try {
            List<FileFromSeafileEntity> fileFromSeafileEntityList = NetDiskUtil.getAllFiles(token, url);
            map.put("fileFromSeafileEntityList", fileFromSeafileEntityList);
            map.put("url", url);
            return ResultEntity.newResultEntity(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newErrEntity("发生错误了");
    }

    @ResponseBody
    @RequestMapping(value = "/share/people", method = RequestMethod.POST)
    public ResultEntity checkSharePeople(HttpServletRequest request) {
        try {
            String link = getParamVal(request, "link");
            String teacehrId = getParamVal(request, "id");
            if (StringUtils.isEmpty(teacehrId)) {
                return ResultEntity.newErrEntity("请填写当前教师的id");
            }
            if (StringUtils.isEmpty(link)) {
                return ResultEntity.newErrEntity("当前文件的分享链接不能为空");
            }
            Teacher teacher = teacherService.findTeacherById(teacehrId);
            if (null == teacher) {
                return ResultEntity.newErrEntity("老师的id错误");
            }
            String email = teacher.getAccount() + ".com";
            List<Teacher> list = netDiskService.findSharePeopleByEmail(email, link, teacehrId);
            return ResultEntity.newResultEntity(JSON.toJSON(list.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newErrEntity();
    }

    /**
     * 取消分享方法  同时也是删除的方法
     *
     * @Author:
     * @params:
     * @Descrption:
     * @Date:16:12 2018/1/10
     * @Modified By: LL
     */
    @ResponseBody
    @RequestMapping(value = "/share/cancel")
    public ResultEntity shareCancel(HttpServletRequest request) {
        String ids = getParamVal(request, "ids").trim();
        System.out.println("ids+++" + ids);
        String operation = getParamVal(request, "operation").trim();
        String teacehrId = getParamVal(request, "teacherId").trim();
        System.out.println("teacherId===" + teacehrId);
        if (StringUtils.isEmpty(teacehrId)) {
            return ResultEntity.newErrEntity("请填写当前教师的id");
        }
        if (StringUtils.isEmpty(operation)) {
            return ResultEntity.newErrEntity("请填写当前操作");
        }

        try {
            if (StringUtils.isEmpty(ids)) {
                return ResultEntity.newErrEntity("请选择要取消分享的文件");
            }
            String[] arrIds = ids.split(",");
            int succ = netDiskService.batchDelShareFiles(arrIds, operation, teacehrId);
            if (succ > 0) {
                return ResultEntity.newResultEntity("取消分享成功");
            } else {
                return ResultEntity.newErrEntity("您要操作的数据信息不存在或者发生错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newErrEntity("取消分享失败");
    }
}
