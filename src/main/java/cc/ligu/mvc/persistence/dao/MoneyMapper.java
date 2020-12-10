package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.Money;
import cc.ligu.mvc.persistence.entity.MoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyMapper {
    int deleteByExample(MoneyExample example);

    int deleteByPrimaryKey(String moneyName);

    int insert(Money record);

    int insertSelective(Money record);

    List<Money> selectByExample(MoneyExample example);

    Money selectByPrimaryKey(String moneyName);

    int updateByExampleSelective(@Param("record") Money record, @Param("example") MoneyExample example);

    int updateByExample(@Param("record") Money record, @Param("example") MoneyExample example);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);
}