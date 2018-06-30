package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.InsuranceCompany;
import cc.ligu.mvc.persistence.entity.InsuranceCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceCompanyMapper {
    int deleteByExample(InsuranceCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceCompany record);

    int insertSelective(InsuranceCompany record);

    List<InsuranceCompany> selectByExample(InsuranceCompanyExample example);

    InsuranceCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InsuranceCompany record, @Param("example") InsuranceCompanyExample example);

    int updateByExample(@Param("record") InsuranceCompany record, @Param("example") InsuranceCompanyExample example);

    int updateByPrimaryKeySelective(InsuranceCompany record);

    int updateByPrimaryKey(InsuranceCompany record);
}