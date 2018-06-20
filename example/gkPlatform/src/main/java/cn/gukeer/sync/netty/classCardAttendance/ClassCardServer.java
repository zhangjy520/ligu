package cn.gukeer.sync.netty.classCardAttendance;

import cn.gukeer.classcard.modelView.CheckAttendanceView;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.common.CourseUtil;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wulianedu.netty.listener.MessageListener;
import com.wulianedu.netty.listener.ServerSendMsgCallback;
import com.wulianedu.netty.server.ServerInstance;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 17-11-8.
 */
@Component
public class ClassCardServer implements MessageListener, ServerSendMsgCallback {
    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_attendance_port = Integer.parseInt((String) properties.get("netty_classcard_attendance_port"));

    private static CacheManager cacheManager;

    //考勤实例
    private static ServerInstance instance_attendance;


    private static ClassCardServer classCardServer;

    public static synchronized ClassCardServer getClassCardServer() {
        if (null == classCardServer) {
            classCardServer = new ClassCardServer();
        }
        return classCardServer;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    public static void setCacheManager(CacheManager cacheManager) {
        ClassCardServer.cacheManager = cacheManager;
    }

    public static ServerInstance getInstance_attendance() {
        return instance_attendance;
    }

    public static void setInstance_attendance(ServerInstance instance_attendance) {
        ClassCardServer.instance_attendance = instance_attendance;
    }


    private ClassCardServer() {
    }

    public void startServer() {
        instance_attendance = new ServerInstance(this, this, netty_classcard_attendance_port);
        instance_attendance.connect();
    }

    @Override
    public void onMessageReceive(String mac) {
        //考勤cache
        CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcard-cache");
        //考勤缓存
        Object obj = cacheService.getCacheByKey(mac);

        boolean fla = instance_attendance.channelStatus(mac);
        if (!fla) {
            System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
                    + "]@@@@@@@@@@@ Channel unconnected  when attendence cache ~ mac :" + mac);
            return;
        }

        System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@Preparing push cache data !! mac is:" + mac);

        //===========================缓存中有考勤数据便推送
        if (null != obj && instance_attendance.channelStatus(mac)) {
            int currentNode = CourseUtil.currentNode(mac);
            if (currentNode == -1) {
                return;
            }
            List<CheckAttendanceView> retList = new ArrayList<>();
            Gson gson = new Gson();
            List<CheckAttendanceView> checkAttendanceList = gson.fromJson(gson.toJson(obj), new TypeToken<List<CheckAttendanceView>>() {
            }.getType());

            for (CheckAttendanceView cav : checkAttendanceList) {
                if (cav.getLessonNo() == currentNode) {
                    retList.add(cav);
                }
            }
            if (retList.size() > 0) {
                Map<String, Object> attdenceMap = new HashMap<>();
                attdenceMap.put("command", ClassCardCommand.CLASSCARD_ATTENDANCE);
                attdenceMap.put("data", retList);
                instance_attendance.sendMessage(mac, new Gson().toJson(attdenceMap));
                System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@Cache data is sent successfully !! data is:" + new Gson().toJson(attdenceMap));
            }
            cacheService.removeCache(mac);
           /* if (instance_attendance.channelStatus(mac)) {
                instance_attendance.sendMessage(mac, "instance_attendance过来了～～～～～～～");
            }*/
        }
        System.out.println("@@@@@@@@@@@[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]@@@@@@@@@@@@@@@ finished push cache data !! mac is:" + mac);
        System.out.println("attendance cache finshed~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * 失败消息回调
     * identify[channel标识] message[消息内容] code[标识发送消息]
     *
     * @param message
     * @param code
     */
    @Override
    public void failureMessage(String identify, Object message, int code) {
        System.out.println("[warning] send message fail \n" + "identify:" + identify + "\n" + "message:" + message + "\n" + "code:" + code + "------------------------------");
    }
}
