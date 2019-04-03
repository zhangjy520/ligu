package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.persistence.entity.UserViewExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserViewMapper {
    int deleteByExample(UserViewExample example);

    int insert(UserView record);

    int insertSelective(UserView record);

    List<UserView> selectByExample(UserViewExample example);

    int updateByExampleSelective(@Param("record") UserView record, @Param("example") UserViewExample example);

    int updateByExample(@Param("record") UserView record, @Param("example") UserViewExample example);

    //查询未发放任何钱的人
    List<UserView> selectNotSendSalary();

    List<HashMap> selectOverDateSalary();
}