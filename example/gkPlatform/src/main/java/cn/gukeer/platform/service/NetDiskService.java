package cn.gukeer.platform.service;

import cn.gukeer.platform.persistence.entity.NetDiskShareLink;
import cn.gukeer.platform.persistence.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * Created by LL on 2017/12/13.
 */
public interface NetDiskService {
    void  batchInsertNetDiskShareLinks(List<NetDiskShareLink>  netDiskShareLinks);

    Map<String,String> findAllSharedBySchoolId(String schoolId);

    List<NetDiskShareLink> findNetDiskShareLinkByShareTypeAndTeacherId(String refId, Integer type);

    int batchDelShareFiles(String[] arrIds,String operation,String teacherId);

    List<Teacher> findSharePeopleByEmail(String email,String link,String teacherId);

    List<NetDiskShareLink> findNetDiskShareLinkByIds(String[] arrIds);
}
