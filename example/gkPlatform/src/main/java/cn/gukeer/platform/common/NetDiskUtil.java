package cn.gukeer.platform.common;

import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.security.MD5Utils;
import cn.gukeer.common.utils.HttpRequestUtil;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.common.utils.RedisUtil;
import cn.gukeer.platform.persistence.entity.FileFromSeafileEntity;
import cn.gukeer.platform.persistence.entity.NetDiskShareLink;
import cn.gukeer.platform.persistence.entity.SelectedFile;
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
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by LL on 2018/1/10.
 *
 * @Author:
 * @Descrption:
 * @Date:created in 9:53 2018/1/10
 * @Modified By:
 */
public class NetDiskUtil extends BasicController {
    @Autowired
    static  JedisPool jedisPool;

    static Properties properties = PropertiesUtil.getProperties("api.properties");
    static String seaFileServer = (String) properties.get("seaFileServer");
    static String seafileDownload = (String)properties.get("seafileDownload");

    public static String getLink(Boolean isDir, String link,String token) {
        try {
            if (isDir) {
                OkHttpClient httpClient = new OkHttpClient();
                String downloadUrlZip = seaFileServer + "api/v2.1/share-link-zip-task/?share_link_token=" + token + "&path=/";
                Request requestZip = new Request.Builder()
                        .url(downloadUrlZip)
                        .build();
                Response responseZip = httpClient.newCall(requestZip).execute();
                String rstZipToken = responseZip.body().string();
                Map mapZipToken = new Gson().fromJson(rstZipToken, Map.class);

                //第二步：Query Task Progress
                Request requestHttpProgress = new Request.Builder()
                        .url(seaFileServer + "api/v2.1/" + "query-zip-progress/?token=" + mapZipToken.get("zip_token"))
                        .build();
                Response response = httpClient.newCall(requestHttpProgress).execute();
                link = seafileDownload + mapZipToken.get("zip_token");
                System.out.println(link + "===============dir link");
            } else {
                URL url = new URL(link+"?dl=1");
//               URL url = new URL("http://120.27.46.200:60001/d/9b547ab0f52a4cfd96d4/");
                //HttpURLConnection是protected修饰的，无法直接new对象
                //url的openConnection方法返回值是URLConnection类的对象，需要强转为HttpURLConnection
                //所以直接通过url调用openConnection方法来实现创建HttpURLConnection的对象
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                huc.setInstanceFollowRedirects(false);
                int responseCode = huc.getResponseCode();
                if (responseCode==302){
                    link = huc.getHeaderField("Location");
                }
                System.out.println(link + "===============file link");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }

    /*
  * 遍历得到的一个文件夹下的所有文件夹和文件，改变对象的时间格式的方法
  * */
    public static List<FileFromSeafileEntity> convertDate(List<FileFromSeafileEntity> fileFromSeafileEntityList) {
        if (null != fileFromSeafileEntityList && fileFromSeafileEntityList.size() > 0) {
            for (FileFromSeafileEntity fileFromSeafileEntity : fileFromSeafileEntityList) {
                fileFromSeafileEntity.getName();
                Long fileSize = fileFromSeafileEntity.getSize();
                if (fileSize != null) {
//                    String fileSizeStr = fileSize / 1000+"";
//                    fileFromSeafileEntity.setSizeStr(fileSizeStr);
                    Long mtime = fileFromSeafileEntity.getMtime()*1000;
                    try {
                        if (mtime!=null)
                            fileFromSeafileEntity.setTime(longToString(mtime, "yyyy-MM-dd"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileFromSeafileEntityList;
    }

    public static List<NetDiskShareLink> setNetDiskShareLinkList(List<NetDiskShareLink> netDiskShareLinks, String schoolId, String teacherId, String rst, String[] chooseIdArr, Map netDiskLinksDbmap, String fileSize,String repositoryId) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(rst);
            String ojectName = jsonObject.get("obj_name").toString();
            String path = jsonObject.get("path").toString();
//            String link = seaFileServer+"thumbnail/"+repositoryId+"/1024"+path;
            String link = jsonObject.get("link").toString();
            ///////////////////////////////////////////
            //在这将文件写到服务器
            /////////////////////////////////////////////
            String isDir = jsonObject.get("is_dir").toString();
            JSONObject permissions = (JSONObject) jsonObject.get("permissions");
            String canPreview = permissions.get("can_preview").toString();
            String canDownload = permissions.get("can_download").toString();
            String repoName = jsonObject.get("repo_name").toString();
            String fileToken = jsonObject.get("token").toString();
            String email = jsonObject.get("username").toString();
            System.out.println("拿主动分享的人信息");
            String linkDbShare = (String) netDiskLinksDbmap.get(email + teacherId + ShareType.SHARE.getStatenum() + link);
            System.out.println("拿主动分享的人信息succ");
            if (StringUtils.isEmpty(linkDbShare)) {
                NetDiskShareLink netDiskShareLink = setNetDiskLink(schoolId, teacherId, email, canDownload, canPreview, ojectName, isDir, link, path, repoName, fileToken, ShareType.SHARE.getStatenum(), fileSize,repositoryId);
                netDiskShareLinks.add(netDiskShareLink);
            }

            if (null != chooseIdArr && chooseIdArr.length > 0) {
                for (String id : chooseIdArr) {
                    System.out.println("拿被动分享的人信息");
                    String linkDbShared = (String) netDiskLinksDbmap.get(email + id + ShareType.SHARED.getStatenum() + link);
                    System.out.println("拿被动分享的人信息succ");
                    if (StringUtils.isNotEmpty(linkDbShared)) {
                        continue;
                    }
                    NetDiskShareLink netDiskShareLink = setNetDiskLink(schoolId, id, email, canDownload, canPreview, ojectName, isDir, link, path, repoName, fileToken, ShareType.SHARED.getStatenum(), fileSize,repositoryId);
                    netDiskShareLinks.add(netDiskShareLink);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return netDiskShareLinks;
    }

    public static NetDiskShareLink setNetDiskLink(String schoolId, String id, String email, String canDownload, String canPreview,
                                                  String ojectName, String isDir, String link, String path, String repoName,
                                                  String fileToken, Integer type, String fileSize,String repositoryId) {
        System.out.println("setNetDiskLink进");
        NetDiskShareLink netDiskShareLink = new NetDiskShareLink();
        netDiskShareLink.setShareType(type);
        netDiskShareLink.setId(PrimaryKey.get());
        netDiskShareLink.setSchoolId(schoolId);
        netDiskShareLink.setTeacherId(id);
        netDiskShareLink.setEmail(email);
        netDiskShareLink.setCanDownlod(Boolean.parseBoolean(canDownload));
        netDiskShareLink.setCanPreview(Boolean.parseBoolean(canPreview));
        netDiskShareLink.setCreateTime(System.currentTimeMillis());
        netDiskShareLink.setFileName(ojectName);
        netDiskShareLink.setIsDir(Boolean.parseBoolean(isDir));
        netDiskShareLink.setLink(link);
        netDiskShareLink.setPath(path);
        netDiskShareLink.setRepoName(repoName);
        netDiskShareLink.setToken(fileToken);
        netDiskShareLink.setFileSize(fileSize);
        System.out.println("setNetDiskLink出");
        return netDiskShareLink;
    }


    /*
    * 获取分享链接的方法
    * */
    public static List<NetDiskShareLink> bathNetDiskShareLink(String teacherId, List<SelectedFile> selectedFiles, String directoryPath, String repositoryId, String token, String[] chooseIdArr, Map netDiskLinksDbmap, String schoolId) {
        Response response = null;
        String rst = "";
        Map<String, String> map = new HashedMap();
        List<NetDiskShareLink> netDiskShareLinks = new ArrayList<>();
        try {
            for (SelectedFile selectedFile : selectedFiles) {
                String fileName = selectedFile.getFileName();
                String fileType = selectedFile.getFileType();
                String fileSize = selectedFile.getFileSize();

                FormBody.Builder params = new FormBody.Builder();
                params.add("path", directoryPath + fileName);
                params.add("repo_id", repositoryId);

                //create share upload link
                OkHttpClient httpClient = new OkHttpClient();
                Request requestRenameFile = new Request.Builder()
                        .header("Authorization", "Token " + token)
                        .header("Accept", " application/json;charset=utf-8;indent=4")
                        .post(params.build())
                        .url(seaFileServer + "api/v2.1/share-links/")
                        .build();

                response = httpClient.newCall(requestRenameFile).execute();
                rst = response.body().string();
                System.out.println("一个分享成功后返回+=+++++++++++++++" + rst);
                if (response.isSuccessful()) {
                    netDiskShareLinks = NetDiskUtil.setNetDiskShareLinkList(netDiskShareLinks, schoolId, teacherId, rst, chooseIdArr, netDiskLinksDbmap, fileSize,repositoryId);
                }
            }
            return netDiskShareLinks;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
  * 获取资料库Id的方法
  * */
    public static String acquireRepository(String adminToken, String token, String repositoryPrefix, Jedis resource, String email) {
        String repositoryId = RedisUtil.find(repositoryPrefix, resource);
        if (StringUtils.isNotEmpty(repositoryId)) {
            return repositoryId;
        }
        Response response = null;
        String repository = "";

        try {
            OkHttpClient httpClient = new OkHttpClient();
            Request requestRepository = new Request.Builder()
                    .header("Authorization", "Token " + token)
                    .header("Accept", "application/json; indent=4")
                    .url(seaFileServer + "api2/repos/")
                    .build();

            response = httpClient.newCall(requestRepository).execute();
            if (response.isSuccessful()) {
                repository = response.body().string();
            }
            Gson gson = new Gson();
            List<Map> mapList = gson.fromJson(repository, new TypeToken<List<Map>>() {
            }.getType());
            if (mapList != null && mapList.size() > 0) {
                Map map6 = mapList.get(0);
                repositoryId = (String) map6.get("id");
                if (StringUtils.isNotEmpty(repositoryId)) {
                    RedisUtil.add(repositoryPrefix, repositoryId, resource);
                    return repositoryId;
                }
            } else {
                repositoryId = createRepository(email, token, resource);
                return repositoryId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String acuireToken(String email, String tokenPrefix, Jedis resource) {
        String token = "";
        try {
            token = RedisUtil.find(tokenPrefix, resource);
            if (StringUtils.isNotEmpty(token)) {
                return token;
            }
            OkHttpClient httpClient = new OkHttpClient();
            FormBody.Builder params = new FormBody.Builder();
            params.add("username", email);
            params.add("password", NetDiskUtil.createPassword(email));

            Request requestToken = new Request.Builder()
                    .post(params.build())
                    .url(seaFileServer + "/api2/auth-token/")
                    .build();
            String jsonToken = "";
            Gson gson = new Gson();

            Response responseToken = httpClient.newCall(requestToken).execute();
            if (responseToken.isSuccessful()) {
                jsonToken = responseToken.body().string();
                Map tokenMap = gson.fromJson(jsonToken, Map.class);
                token = (String) tokenMap.get("token");
                System.out.println("rst: " + responseToken);
                RedisUtil.add(tokenPrefix, token, resource);
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //该参数的格式为：admin@team.com 邮箱格式
    public static String createPassword(String email) {
        String password = MD5Utils.md5(email);
        return password;
    }


    //token 是学校云盘管理员的token  email是要创建的email账号
    public static String createAccount(String adminToken, String serverUrl, String email, Jedis jedis) {
        String redisEmailKey = RedisKeyUtil.netDiskKeyEmailPrefix + email;

        String redisEmailValue = RedisUtil.find(redisEmailKey, jedis);
        if (StringUtils.isNotEmpty(redisEmailValue)) {
            return "";
        }

        String redisTokenPrefix = RedisKeyUtil.netDiskKeyTokenPrefix + email;
        String oneToken = acuireToken(email, redisTokenPrefix, jedis);
        if (StringUtils.isNotEmpty(oneToken)) {
            return "";
        }

        FormBody.Builder params = new FormBody.Builder();
        params.add("is_staf", "False");
        params.add("is_active ", "True");
        String password = NetDiskUtil.createPassword(email);
        params.add("password", password);

        OkHttpClient httpClient = new OkHttpClient();
        Request requestCreat = new Request.Builder()
                .header("Authorization", "Token " + adminToken)
                .header("Accept", "application/json; indent=4")
                .put(params.build())
                .url(serverUrl + "api2/accounts/" + email + "/")
                .build();
        Response response = null;
        String rst = "";

        try {
            //第一步：创建账号
            response = httpClient.newCall(requestCreat).execute();
            if (response.isSuccessful()) {
                rst = response.body().string();
                if (response.isSuccessful()) {
                    RedisUtil.add(redisEmailKey, email, jedis);
                } else {
                    return "false";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response.isSuccessful()) {
            //云盘oneTeacehrToken  回收站  repository验证
            String repositoryId = "";
            try {
                //获取oneTeacehrToken
                oneToken = NetDiskUtil.acuireToken(email, redisTokenPrefix, jedis);
                if (StringUtils.isNotEmpty(oneToken)) {
                    //获取资料库Id
                    repositoryId = NetDiskUtil.acquireRepository(adminToken, oneToken, RedisKeyUtil.netDiskKeyRepositoryPrefix + email, jedis, email);
                    if (StringUtils.isNotEmpty(repositoryId)) {
                        String recyclePrefix = RedisKeyUtil.netDiskKeyRecyclePrefix + email;
                        if (StringUtils.isEmpty(RedisUtil.find(recyclePrefix, jedis))) {
                            //若redis中没有，则调用查看根目录下所有的文件的接口  循环遍历是否存在回收站文件夹
                            List<FileFromSeafileEntity> allFiles = NetDiskUtil.getAllFiles(oneToken, seaFileServer + "api2/repos/" + repositoryId + "/dir/?p=/");
                            Boolean isExistTreu = false;
                            if (null != allFiles && allFiles.size() > 0) {
                                //存在回收站
                                for (FileFromSeafileEntity fileFromSeafileEntity : allFiles) {
                                    if (fileFromSeafileEntity.getName().equals("回收站")) {
                                        isExistTreu = true;
                                        RedisUtil.add(recyclePrefix, email + "recycle", jedis);
                                        return "success";
                                    }
                                }
                            }

                            if (!isExistTreu) {
                                //不存在回收站
                                String url = seaFileServer + "api2/repos/" + repositoryId + "/dir/?p=/回收站";
                                String createRecycle = NetDiskUtil.mkdirMethod(oneToken, url);
                                System.out.println(createRecycle.trim().equals("success"));
                                if (createRecycle.equals("success")) {
                                    RedisUtil.add(recyclePrefix, email + "recycle", jedis);
                                    return "success";
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rst;
        } else {
            return "";
        }
    }

    public static String createRepository(String email, String token, Jedis jedis) {
        //http://120.27.46.200:60001/api2/repos/
        try {
            FormBody.Builder params = new FormBody.Builder();
            params.add("desc", "newlibrary");
            params.add("name", "aaa");

            OkHttpClient httpClient = new OkHttpClient();
            Request requestCreat = new Request.Builder()
                    .header("Authorization", "Token " + token)
                    .header("Accept", "application/json; indent=4")
                    .post(params.build())
                    .url(seaFileServer + "api2/repos/")
                    .build();
            Response response = null;
            //第一步：创建账号
            response = httpClient.newCall(requestCreat).execute();
            if (response.isSuccessful()) {
                Gson gson = new Gson();
                Map tokenMap = gson.fromJson(response.body().string(), Map.class);
                String ropositoryId = (String) tokenMap.get("repo_id");
                RedisUtil.add(RedisKeyUtil.netDiskKeyRepositoryPrefix + email, ropositoryId, jedis);
                return ropositoryId;
            }
        } catch (Exception e) {

        }
        return "";
    }

    //获取所有的目录 或者文件
    public static List<FileFromSeafileEntity> getAllFiles(String token, String url) {
        OkHttpClient httpClient = new OkHttpClient();
        Request requestAccountInfo = new Request.Builder()
                .header("Authorization", "Token " + token)
                .header("Accept", "application/json; indent=4")
                .url(url)
                .build();

        Response response = null;
        String rst = "";
        List<FileFromSeafileEntity> fileFromSeafileEntityList = null;
        try {
            response = httpClient.newCall(requestAccountInfo).execute();
            rst = response.body().string();
            if (StringUtils.isNotEmpty(rst)) {
                Gson gson = new Gson();
                fileFromSeafileEntityList = gson.fromJson(rst, new TypeToken<List<FileFromSeafileEntity>>() {
                }.getType());
                fileFromSeafileEntityList = NetDiskUtil.convertDate(fileFromSeafileEntityList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileFromSeafileEntityList;
    }

    public static String mkdirMethod(String token, String url) {
        String rst = "";
        try {
            FormBody.Builder params = new FormBody.Builder();
            params.add("operation", "mkdir");
            OkHttpClient httpClient = new OkHttpClient();
            Request requesthttp = new Request.Builder()
                    .header("Authorization", "Token " + token)
                    .header("Accept", " application/json;charset=utf-8;indent=4")
                    .post(params.build())
                    .url(url)
                    .build();
            Response response = httpClient.newCall(requesthttp).execute();
            if (response.isSuccessful()) {
                rst = response.body().string();
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rst;
    }


}
