package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.PvpArchievement;
import cc.ligu.mvc.persistence.entity.PvpArchievementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PvpArchievementMapper {
    int deleteByExample(PvpArchievementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PvpArchievement record);

    int insertSelective(PvpArchievement record);

    List<PvpArchievement> selectByExample(PvpArchievementExample example);

    PvpArchievement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PvpArchievement record, @Param("example") PvpArchievementExample example);

    int updateByExample(@Param("record") PvpArchievement record, @Param("example") PvpArchievementExample example);

    int updateByPrimaryKeySelective(PvpArchievement record);

    int updateByPrimaryKey(PvpArchievement record);
}