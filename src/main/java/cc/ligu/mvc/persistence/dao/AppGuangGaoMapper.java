package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.AppGuangGao;
import cc.ligu.mvc.persistence.entity.AppGuangGaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppGuangGaoMapper {
    int deleteByExample(AppGuangGaoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppGuangGao record);

    int insertSelective(AppGuangGao record);

    List<AppGuangGao> selectByExample(AppGuangGaoExample example);

    AppGuangGao selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppGuangGao record, @Param("example") AppGuangGaoExample example);

    int updateByExample(@Param("record") AppGuangGao record, @Param("example") AppGuangGaoExample example);

    int updateByPrimaryKeySelective(AppGuangGao record);

    int updateByPrimaryKey(AppGuangGao record);
}