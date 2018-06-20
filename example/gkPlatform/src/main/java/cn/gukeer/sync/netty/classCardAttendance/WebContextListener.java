package cn.gukeer.sync.netty.classCardAttendance;

import cn.gukeer.classcard.util.ClassCardCommand;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by alpha on 17-11-2.
 */
@Component
public class WebContextListener implements InitializingBean {

    @Autowired
    CacheManager cacheManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            //考勤
            ClassCardServer.getClassCardServer().startServer();
            //指令
            ClassCardCommandServer.getClassCardCommandServer().startServer();
            //自定义
            ClassCardCustomizeServer.getClassCardCustomizeServer().startServer();
            ClassCardServer.setCacheManager(cacheManager);
            ClassCardCommandServer.setCacheManager(cacheManager);
            ClassCardCustomizeServer.setCacheManager(cacheManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
