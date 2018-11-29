package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.AppConfigMapper;
import cc.ligu.mvc.persistence.entity.AppConfig;
import cc.ligu.mvc.persistence.entity.AppConfigExample;
import cc.ligu.mvc.service.AppConfigService;
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
public class AppConfigServiceImpl extends BasicService implements AppConfigService {

    @Autowired
    AppConfigMapper appConfigMapper;

    @Override
    public PageInfo<AppConfig> listAllAppConfig(int pageSize, int pageNum, AppConfig appConfig) {
        AppConfigExample example = new AppConfigExample();
        example.createCriteria().andIdIsNotNull();

        PageHelper.startPage(pageNum, pageSize);
        List<AppConfig> configList = appConfigMapper.selectByExample(example);
        PageInfo<AppConfig> page = new PageInfo<AppConfig>(configList);

        return page;
    }

    @Override
    public int saveAppConfig(AppConfig appConfig) {
        if (StringUtils.isEmpty(appConfig.getId())) {
            appConfigMapper.insertSelective(appConfig);
        } else {
            appConfigMapper.updateByPrimaryKeySelective(appConfig);
        }
        return 1;
    }

    @Override
    public AppConfig selectAppConfigByPrimary(int appConfigId) {
        return appConfigMapper.selectByPrimaryKey(appConfigId);
    }

    @Override
    public List<AppConfig> configList(AppConfig appConfig) {
        AppConfigExample example = new AppConfigExample();
        AppConfigExample.Criteria cri = example.createCriteria();

        if (!StringUtils.isEmpty(appConfig.getConfigType())) {
            cri.andConfigTypeEqualTo(appConfig.getConfigType());
        }
        return appConfigMapper.selectByExample(example);
    }
}
