package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.AppConfig;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AppConfigService {
    PageInfo<AppConfig> listAllAppConfig(int pageSize, int pageNum, AppConfig appConfig);

    int saveAppConfig(AppConfig appConfig);

    AppConfig selectAppConfigByPrimary(int appConfigId);

    List<AppConfig> configList(AppConfig appConfig);

}
