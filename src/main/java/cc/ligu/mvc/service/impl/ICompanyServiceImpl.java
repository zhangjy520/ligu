package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.InsuranceCompanyMapper;
import cc.ligu.mvc.persistence.dao.ItemMapper;
import cc.ligu.mvc.persistence.entity.InsuranceCompany;
import cc.ligu.mvc.persistence.entity.InsuranceCompanyExample;
import cc.ligu.mvc.persistence.entity.Item;
import cc.ligu.mvc.persistence.entity.ItemExample;
import cc.ligu.mvc.service.ICompanyService;
import cc.ligu.mvc.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class ICompanyServiceImpl extends BasicService implements ICompanyService {

    @Autowired
    InsuranceCompanyMapper insuranceCompanyMapper;

    @Override
    public PageInfo<InsuranceCompany> listAllInsuranceCompany(int pageSize, int pageNum, InsuranceCompany insuranceCompany) {
        InsuranceCompanyExample example = new InsuranceCompanyExample();
        InsuranceCompanyExample.Criteria cri = example.createCriteria();

        if (!StringUtils.isEmpty(insuranceCompany.getName())) {
            cri.andNameLike("%" + insuranceCompany.getName() + "%");
        }
        PageHelper.startPage(pageSize,pageNum);
        List<InsuranceCompany> res = insuranceCompanyMapper.selectByExample(example);
        PageInfo<InsuranceCompany> page = new PageInfo<InsuranceCompany>(res);
        return page;
    }

    @Override
    public List<InsuranceCompany> listAllInsuranceCompany() {
        InsuranceCompanyExample example = new InsuranceCompanyExample();
        example.createCriteria();
        return insuranceCompanyMapper.selectByExample(example);
    }

    @Override
    public int saveInsuranceCompany(InsuranceCompany insuranceCompany) {
        if (StringUtils.isEmpty(insuranceCompany.getId())) {
            insuranceCompanyMapper.insertSelective(insuranceCompany);
        }else{
            insuranceCompanyMapper.updateByPrimaryKeySelective(insuranceCompany);
        }
        return 1;
    }

    @Override
    public InsuranceCompany selectInsuranceCompanyByPrimary(int insuranceCompanyId) {
        return insuranceCompanyMapper.selectByPrimaryKey(insuranceCompanyId);
    }

    @Override
    public int deleteInsuranceCompany(InsuranceCompany insuranceCompany) {
        return insuranceCompanyMapper.deleteByPrimaryKey(insuranceCompany.getId());
    }
}
