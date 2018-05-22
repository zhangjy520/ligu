package cn.gukeer.platform.persistence.dao;

import cn.gukeer.platform.persistence.entity.NetDiskShareLink;
import cn.gukeer.platform.persistence.entity.NetDiskShareLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NetDiskShareLinkMapper {
    int deleteByExample(NetDiskShareLinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(NetDiskShareLink record);

    int insertSelective(NetDiskShareLink record);

    List<NetDiskShareLink> selectByExample(NetDiskShareLinkExample example);

    NetDiskShareLink selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NetDiskShareLink record, @Param("example") NetDiskShareLinkExample example);

    int updateByExample(@Param("record") NetDiskShareLink record, @Param("example") NetDiskShareLinkExample example);

    int updateByPrimaryKeySelective(NetDiskShareLink record);

    int updateByPrimaryKey(NetDiskShareLink record);
}