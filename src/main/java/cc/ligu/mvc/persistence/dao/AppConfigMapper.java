package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.AppConfig;
import cc.ligu.mvc.persistence.entity.AppConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppConfigMapper {
    int deleteByExample(AppConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppConfig record);

    int insertSelective(AppConfig record);

    List<AppConfig> selectByExample(AppConfigExample example);

    AppConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByExample(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByPrimaryKeySelective(AppConfig record);

    int updateByPrimaryKey(AppConfig record);
}