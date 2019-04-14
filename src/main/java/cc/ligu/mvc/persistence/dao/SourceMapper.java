package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.persistence.entity.SourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceMapper {
    int deleteByExample(SourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Source record);

    int insertSelective(Source record);

    List<Source> selectByExample(SourceExample example);

    List<Source> selectByExampleWithOutBigBlob(SourceExample example);

    Source selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Source record, @Param("example") SourceExample example);

    int updateByExample(@Param("record") Source record, @Param("example") SourceExample example);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
}