package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ScanLog;
import cc.ligu.mvc.persistence.entity.ScanLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScanLogMapper {
    int deleteByExample(ScanLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScanLog record);

    int insertSelective(ScanLog record);

    List<ScanLog> selectByExample(ScanLogExample example);

    ScanLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScanLog record, @Param("example") ScanLogExample example);

    int updateByExample(@Param("record") ScanLog record, @Param("example") ScanLogExample example);

    int updateByPrimaryKeySelective(ScanLog record);

    int updateByPrimaryKey(ScanLog record);
}