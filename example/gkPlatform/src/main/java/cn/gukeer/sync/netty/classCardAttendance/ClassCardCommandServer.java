package cn.gukeer.sync.netty.classCardAttendance;

import cn.gukeer.classcard.persistence.entity.ClassCardApp;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import com.google.gson.Gson;
import com.wulianedu.netty.listener.MessageListener;
import com.wulianedu.netty.listener.ServerSendMsgCallback;
import com.wulianedu.netty.server.ServerInstance;
import org.springframework.cache.CacheManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 18-3-1.
 */
public class ClassCardCommandServer implements MessageListener ,ServerSendMsgCallback {
    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_command_port = Integer.parseInt((String) properties.get("netty_classcard_command_port"));

    private static CacheManager cacheManager;

    //指令实例
    private static ServerInstance instance_command;

    private static ClassCardCommandServer classCardCommandServer;

    public static synchronized ClassCardCommandServer getClassCardCommandServer() {
        if (null == classCardCommandServer) {
            classCardCommandServer = new ClassCardCommandServer();
        }
        return classCardCommandServer;
    }

    private ClassCardCommandServer() {
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    public static void setCacheManager(CacheManager cacheManager) {
        ClassCardCommandServer.cacheManager = cacheManager;
    }

    public static ServerInstance getInstance_command() {
        return instance_command;
    }

    public static void setInstance_command(ServerInstance instance_command) {
        ClassCardCommandServer.instance_command = instance_command;
    }

    public void startServer() {
        instance_command = new ServerInstance(this, this,netty_classcard_command_port);
        instance_command.connect();
    }

    @Override
    public void onMessageReceive(String mac) {
        //指令cache
        CacheServiceImpl commandCacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

        //安装指令缓存
        Object installObj = commandCacheService.getCacheByKey(mac + "_" + ClassCardCommand.APK_INSTALL);
        //卸载指令缓存
        Object unInstallObj = commandCacheService.getCacheByKey(mac + "_" + ClassCardCommand.APK_UNINSTALL);
        //班牌配置缓存
        Object configObj = commandCacheService.getCacheByKey(mac + "_" + ClassCardCommand.CONFIG_UPDATE);

        boolean fla = instance_command.channelStatus(mac);
        if (!fla) {
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
                    + "]@@@@@@@@@@@ Channel unconnected  when command cache ~ mac :" + mac);
            return;
        }

        //===========================缓存中有apk指令便推送
        if ((null != installObj || null != unInstallObj) && instance_command.channelStatus(mac)) {
            Map<String, Object> installMap = new HashMap<>();
            if (null != installObj) {
                installMap = (Map<String, Object>) installObj;
            }
            List<Map<String, Object>> installDatas = null;
            if (null != installMap && installMap.get("data") != null) {
                installDatas = (List<Map<String, Object>>) installMap.get("data");
            }

            Map<String, Object> unInstallMap = new HashMap<>();
            if (null != unInstallObj) {
                unInstallMap = (Map<String, Object>) unInstallObj;
            }
            List<Map<String, Object>> unInstallDatas = null;
            if (null != unInstallMap && unInstallMap.get("data") != null) {
                unInstallDatas = (List<Map<String, Object>>) unInstallMap.get("data");
            }

            Map<String, Object> removeRedundantMap = removeRedundant(installDatas, unInstallDatas);


            //apk安装缓存
            if (null != removeRedundantMap.get("installDatas") && instance_command.channelStatus(mac)) {
                Map<String, Object> retInstallMap = new HashMap<>();
                retInstallMap.put("command", ClassCardCommand.APK_INSTALL);
                retInstallMap.put("data", removeRedundantMap.get("installDatas"));
                instance_command.sendMessage(mac, new Gson().toJson(retInstallMap));
                System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ APK_INSTALL Cache data is sent successfully !! data is:" + new Gson().toJson(retInstallMap));
                commandCacheService.removeCache(mac + "_" + ClassCardCommand.APK_INSTALL);
                commandCacheService.removeCache(mac + "_" + ClassCardCommand.APK_UNINSTALL);
            }
            //apk卸载缓存
            if (null != removeRedundantMap.get("unInstallDatas") && instance_command.channelStatus(mac)) {
                Map<String, Object> retUnInstallMap = new HashMap<>();
                retUnInstallMap.put("command", ClassCardCommand.APK_UNINSTALL);
                retUnInstallMap.put("data", removeRedundantMap.get("unInstallDatas"));
                instance_command.sendMessage(mac, new Gson().toJson(retUnInstallMap));
                System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ APK_UNINSTALL Cache data is sent successfully !! data is:" + new Gson().toJson(retUnInstallMap));
                commandCacheService.removeCache(mac + "_" + ClassCardCommand.APK_UNINSTALL);
                commandCacheService.removeCache(mac + "_" + ClassCardCommand.APK_INSTALL);
            }
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ APK_COMMAND Cache data is sent successfully !! ");
        }

        //===========================配置缓存
        if (null != configObj && instance_command.channelStatus(mac)) {
            instance_command.sendMessage(mac, new Gson().toJson(configObj));
            /*if (instance_command.channelStatus(mac)) {
                instance_command.sendMessage(mac, "instance_command_config过来了～～～～～～～");
            }*/
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ CONFIG_COMMAND Cache data is sent successfully !! ");
            commandCacheService.removeCache(mac + "_" + ClassCardCommand.CONFIG_UPDATE);
        }

        System.out.println("command cache finshed~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * 去除两个命令集合中无效的命令
     *
     * @param installDatas
     * @param unInstallDatas
     * @return
     */
    public Map<String, Object> removeRedundant(List<Map<String, Object>> installDatas, List<Map<String, Object>> unInstallDatas) {

        Map<String, Object> retMap = new HashMap<>();
        if (null == installDatas && null != unInstallDatas) {
            retMap.put("unInstallDatas", unInstallDatas);
            retMap.put("installDatas", null);
            return retMap;
        }
        if (null != installDatas && null == unInstallDatas) {
            retMap.put("installDatas", installDatas);
            retMap.put("unInstallDatas", null);
            return retMap;
        }
        if (null == installDatas && null == unInstallDatas) {
            retMap.put("unInstallDatas", null);
            retMap.put("installDatas", null);
            return retMap;
        }

        List<Map<String, Object>> retInstall = new ArrayList<>();
        List<Map<String, Object>> retUnInstall = new ArrayList<>();

        install:
        for (Map<String, Object> installMap : installDatas) {
            for (Map<String, Object> unInstallMap : unInstallDatas) {
                ClassCardApp installApk = (ClassCardApp) installMap.get("apk");
                ClassCardApp unInstallApk = (ClassCardApp) unInstallMap.get("apk");
                if (installApk.getId().equals(unInstallApk.getId())) {
                    Long installTime = (Long) installMap.get("time");
                    Long unInstallTime = (Long) unInstallMap.get("time");
                    if (installTime > unInstallTime) {
                        retInstall.add(installMap);
                    }
                    continue install;
                }
            }
            retInstall.add(installMap);
        }

        unInstall:
        for (Map<String, Object> unInstallMap : unInstallDatas) {
            for (Map<String, Object> installMap : installDatas) {
                ClassCardApp installApk = (ClassCardApp) installMap.get("apk");
                ClassCardApp unInstallApk = (ClassCardApp) unInstallMap.get("apk");
                if (installApk.getId().equals(unInstallApk.getId())) {
                    Long installTime = (Long) installMap.get("time");
                    Long unInstallTime = (Long) unInstallMap.get("time");
                    if (installTime < unInstallTime) {
                        retUnInstall.add(unInstallMap);
                    }
                    continue unInstall;
                }
            }
            retUnInstall.add(unInstallMap);
        }

        retMap.put("unInstallDatas", retUnInstall.size() == 0 ? null : retUnInstall);
        retMap.put("installDatas", retInstall.size() == 0 ? null : retInstall);
        return retMap;

    }

    @Override
    public void failureMessage(String s, Object o, int i) {

    }
}

