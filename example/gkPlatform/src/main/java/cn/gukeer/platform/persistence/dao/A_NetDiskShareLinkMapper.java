package cn.gukeer.platform.persistence.dao;

import cn.gukeer.platform.persistence.entity.NetDiskShareLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LL on 2017/12/13.
 */
public interface A_NetDiskShareLinkMapper {
    public void   batchInsertNetDiskShareLinks(@Param("netDiskShareLinks") List<NetDiskShareLink> netDiskShareLinks);
}
