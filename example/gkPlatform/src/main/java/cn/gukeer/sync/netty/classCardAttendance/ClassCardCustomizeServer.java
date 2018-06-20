package cn.gukeer.sync.netty.classCardAttendance;

import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import com.google.gson.Gson;
import com.wulianedu.netty.listener.MessageListener;
import com.wulianedu.netty.listener.ServerSendMsgCallback;
import com.wulianedu.netty.server.ServerInstance;
import org.springframework.cache.CacheManager;

import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * Created by alpha on 18-3-1.
 */
public class ClassCardCustomizeServer implements MessageListener,ServerSendMsgCallback {
    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_customize_port = Integer.parseInt((String) properties.get("netty_classcard_customize_port"));

    private static CacheManager cacheManager;

    //自定义实例
    private static ServerInstance instance_customize;

    private static ClassCardCustomizeServer classCardCustomizeServer;

    public static synchronized ClassCardCustomizeServer getClassCardCustomizeServer() {
        if (null == classCardCustomizeServer) {
            classCardCustomizeServer = new ClassCardCustomizeServer();
        }
        return classCardCustomizeServer;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    public static void setCacheManager(CacheManager cacheManager) {
        ClassCardCustomizeServer.cacheManager = cacheManager;
    }

    public static ServerInstance getInstance_customize() {
        return instance_customize;
    }

    public static void setInstance_customize(ServerInstance instance_customize) {
        ClassCardCustomizeServer.instance_customize = instance_customize;
    }

    public void startServer() {
        instance_customize = new ServerInstance(this,this, netty_classcard_customize_port);
        instance_customize.connect();
    }

    @Override
    public void onMessageReceive(String mac) {
        //指令cache
        CacheServiceImpl commandCacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

        //班牌自定义界面缓冲
        Object customObj = commandCacheService.getCacheByKey(mac + "_" + ClassCardCommand.CUSTOM_PUBLISH);

        //通知公告发布
        Object notifyObj=commandCacheService.getCacheByKey(mac+"_"+ClassCardCommand.NOTIFY_PUBLISH);

        //通知公告取消
        Object notifyUnPubObj=commandCacheService.getCacheByKey(mac+"_"+ClassCardCommand.NOTIFY_UNPUBLISH);

        boolean fla = instance_customize.channelStatus(mac);
        if (!fla) {
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
                    + "]@@@@@@@@@@@ Channel unconnected  when customize cache ~ mac :" + mac);
            return;
        }

        //===========================自定义缓存
        if (null != customObj && instance_customize.channelStatus(mac)) {
            instance_customize.sendMessage(mac, new Gson().toJson(customObj));
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ CustomPage_COMMAND Cache data is sent successfully !! ");
            System.out.println("data is "+customObj);
            commandCacheService.removeCache(mac + "_" + ClassCardCommand.CUSTOM_PUBLISH);
        }

        //===========================通知公告
        if (null != notifyObj && instance_customize.channelStatus(mac)) {
            instance_customize.sendMessage(mac, new Gson().toJson(notifyObj));
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ CustomPage_COMMAND Cache data is sent successfully !! ");
            System.out.println("data is "+notifyObj);
            commandCacheService.removeCache(mac + "_" + ClassCardCommand.NOTIFY_PUBLISH);
        }

        //===========================通知公告取消
        if (null != notifyUnPubObj && instance_customize.channelStatus(mac)) {
            instance_customize.sendMessage(mac, new Gson().toJson(notifyUnPubObj));
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ CustomPage_COMMAND Cache data is sent successfully !! ");
            System.out.println("data is "+notifyUnPubObj);
            commandCacheService.removeCache(mac + "_" + ClassCardCommand.NOTIFY_UNPUBLISH);
        }

        System.out.println("customize cache finshed~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void failureMessage(String s, Object o, int i) {

    }
}
