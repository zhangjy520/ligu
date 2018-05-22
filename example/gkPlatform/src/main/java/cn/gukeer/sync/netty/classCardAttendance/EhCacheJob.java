package cn.gukeer.sync.netty.classCardAttendance;

import cn.gukeer.platform.service.CacheService;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

/**
 * Created by alpha on 17-11-20.
 */
public class EhCacheJob {

    @Autowired
    CacheManager cacheManager;

    public void execute() {
        System.out.println("CACHE CLEAR STARTING...+++++++++++++++++++++++++++++++++++++++++++++");
        CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcard-cache");
        cacheService.removeAll();

//        CacheServiceImpl cacheService1 = new CacheServiceImpl(cacheManager,"table-cache-node");
//        cacheService1.removeAll();
        System.out.println("CACHE CLEAR  ENDING ...+++++++++++++++++++++++++++++++++++++++++++++");
    }
}
