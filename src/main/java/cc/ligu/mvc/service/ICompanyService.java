package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.InsuranceCompany;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICompanyService {
    PageInfo<InsuranceCompany> listAllInsuranceCompany(int pageSize, int pageNum, InsuranceCompany insuranceCompany);

    List<InsuranceCompany> listAllInsuranceCompany();

    int saveInsuranceCompany(InsuranceCompany insuranceCompany);

    InsuranceCompany selectInsuranceCompanyByPrimary(int insuranceCompanyId);

    int deleteInsuranceCompany(InsuranceCompany insuranceCompany);
}
