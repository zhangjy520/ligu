package cn.gukeer.sync.netDiskAccount;

import cn.gukeer.common.security.AESencryptor;
import cn.gukeer.common.security.MD5Utils;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.common.utils.RedisUtil;
import cn.gukeer.platform.common.NetDiskUtil;
import cn.gukeer.platform.common.RedisKeyUtil;
import cn.gukeer.platform.common.SchoolAppStatus;
import cn.gukeer.platform.persistence.dao.*;
import cn.gukeer.platform.persistence.entity.*;
import com.google.gson.Gson;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author LL
 * @date 2017/11/16
 */
@Service
public class CreateNetAccount {
    @Autowired
    AppMapper appMapper;

    @Autowired
    SchoolAppMapper schoolAppMapper;

    @Autowired
    SyncTeacherMapper syncTeacherMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    NetDiskAccountMapper netDiskAccountMapper;

    Properties properties = PropertiesUtil.getProperties("api.properties");
    String seaFileServer = (String) properties.get("seaFileServer");

    public void createNetAccount() {
        AppExample appExample = new AppExample();
        appExample.createCriteria().andAppStatusEqualTo(1).andDelFlagEqualTo(0).andNameEqualTo("教师网盘");
        List<App> appList = appMapper.selectByExample(appExample);
        App app = null;
        if (null != appList && appList.size() > 0) {
            app = appList.get(0);
        }

        List<SchoolApp> schoolApps = new ArrayList<>();
        if (null != app) {
            String appId = app.getId();
            SchoolAppExample schoolAppExample = new SchoolAppExample();
            schoolAppExample.createCriteria().andAppIdEqualTo(appId).andAppStatusEqualTo(SchoolAppStatus.ONLINE.getStatenum());
            schoolApps = schoolAppMapper.selectByExample(schoolAppExample);
        }

        List<SyncTeacher> syncTeachers = new ArrayList<>();
        List<String> schoolIds = new ArrayList<>();
        Jedis resource = jedisPool.getResource();
        try {


            if (null != schoolApps && schoolApps.size() > 0) {
                for (SchoolApp schoolApp : schoolApps) {
                    schoolIds.add(schoolApp.getSchoolId());
                    String schoolId = schoolApp.getSchoolId();
                    SyncTeacherExample syncTeacherExample = new SyncTeacherExample();
                    syncTeacherExample.createCriteria().andDelFlagEqualTo(0).andSchoolIdEqualTo(schoolId).andAccountIsNotNull().andEventEqualTo("INSERT").andSyncDelFlagLike("%,0%");
//                syncTeacherExample.or(syncTeacherExample.createCriteria().andEventEqualTo("DELETE"));
                    syncTeachers = syncTeacherMapper.selectByExample(syncTeacherExample);

                    List<NetDiskAccount> netDiskAccounts = new ArrayList<>();
                    if (schoolIds != null && schoolIds.size() > 0) {
                        NetDiskAccountExample netDiskAccountExample = new NetDiskAccountExample();
                        netDiskAccountExample.createCriteria().andSchoolIdIn(schoolIds);
                        netDiskAccounts = netDiskAccountMapper.selectByExample(netDiskAccountExample);
                    }

                    List<String> teacherIds = new ArrayList<>();
                    List<SyncTeacher> adminSyncTeachers = new ArrayList<>();
                    List<User> users = new ArrayList<>();
                    if (null != syncTeachers && syncTeachers.size() > 0) {
                        for (SyncTeacher syncTeacher : syncTeachers) {
                            teacherIds.add(syncTeacher.getSyncId());
                            if (syncTeacher.getAccount().contains("admin")) {
                                adminSyncTeachers.add(syncTeacher);
                            }
                        }

                        UserExample userExample = new UserExample();
                        userExample.createCriteria().andDelFlagEqualTo(0).andRefIdIn(teacherIds);
                        users = userMapper.selectByExample(userExample);
                        String token = NetDiskUtil.acuireToken("admin@team" + ".com", "c2d2c4b347549ab19ca54ca1aadffcf8", resource);
                        List<NetDiskAccount> oneAccount = new ArrayList<>();
                        for (SyncTeacher syncTeacher : syncTeachers) {
                            if ("b14e6ff4d716906e7db294699bc8ba54".equals(syncTeacher.getSchoolId())) {
                                String event = syncTeacher.getEvent();
                                String account = syncTeacher.getAccount();
                                for (User user : users) {
                                    NetDiskAccount netDiskAccount = new NetDiskAccount();
                                    netDiskAccount.setId(PrimaryKey.get());
                                    netDiskAccount.setSchoolId("b14e6ff4d716906e7db294699bc8ba54");
                                    netDiskAccount.setDelFlag(0);
                                    netDiskAccount.setEmail(account + ",com");
                                    netDiskAccount.setCreaterEmail("admin@team" + ".com");
                                    netDiskAccount.setCreaterToken(token);
                                    netDiskAccount.setInsertTime(System.currentTimeMillis());
                                    oneAccount.add(netDiskAccount);
                                    if (netDiskAccounts.contains(oneAccount)) {
                                        continue;
                                    }

                                    if (event.equals("INSERT")) {
                                        if (StringUtils.isNotEmpty(token)) {
                                            String rst = NetDiskUtil.createAccount(token, seaFileServer, account + ".com", resource);
                                            if (rst.equals("success")) {
                                                netDiskAccountMapper.insertSelective(netDiskAccount);
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtil.returnResource(resource);
        }
    }


    public String delAccount(String email, String token) {
        Jedis resource = jedisPool.getResource();
        String emailInredis = RedisUtil.find(RedisKeyUtil.netDiskKeyEmailPrefix + email, resource);
        String TokenInredis = RedisUtil.find(RedisKeyUtil.netDiskKeyEmailPrefix + email, resource);
        String repositoryInredis = RedisUtil.find(RedisKeyUtil.netDiskKeyEmailPrefix + email, resource);
        String recycleInredis = RedisUtil.find(RedisKeyUtil.netDiskKeyEmailPrefix + email, resource);

        if (StringUtils.isNotEmpty(emailInredis)) {
            RedisUtil.del(emailInredis, resource);
        }

        if (StringUtils.isNotEmpty(TokenInredis)) {
            RedisUtil.del(TokenInredis, resource);
        }
        if (StringUtils.isNotEmpty(repositoryInredis)) {
            RedisUtil.del(repositoryInredis, resource);
        }
        if (StringUtils.isNotEmpty(recycleInredis)) {
            RedisUtil.del(recycleInredis, resource);
        }
        RedisUtil.returnResource(resource);


        OkHttpClient httpClient = new OkHttpClient();
        Request requestToken = new Request.Builder()
                .delete()
                .header("Authorization", "Token " + token)
                .url(seaFileServer + "/api2/accounts/" + email + "/")
                .build();
        String rst = "";
        try {
            Response responseToken = httpClient.newCall(requestToken).execute();
            if (responseToken.isSuccessful()) {
                rst = responseToken.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
