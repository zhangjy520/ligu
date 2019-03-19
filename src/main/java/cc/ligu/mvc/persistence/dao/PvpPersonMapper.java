package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.modelView.PvpPersonView;
import cc.ligu.mvc.persistence.entity.PvpPerson;
import cc.ligu.mvc.persistence.entity.PvpPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PvpPersonMapper {
    int deleteByExample(PvpPersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PvpPerson record);

    int insertSelective(PvpPerson record);

    List<PvpPerson> selectByExample(PvpPersonExample example);

    PvpPerson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PvpPerson record, @Param("example") PvpPersonExample example);

    int updateByExample(@Param("record") PvpPerson record, @Param("example") PvpPersonExample example);

    int updateByPrimaryKeySelective(PvpPerson record);

    int updateByPrimaryKey(PvpPerson record);

    PvpPersonView selectLatestPvpByPersonAId(int id);
}