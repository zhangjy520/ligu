package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.AppGuangGao;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AppGuangGaoService {
    PageInfo<AppGuangGao> listAllAppGuangGao(int pageSize, int pageNum, AppGuangGao appGuangGao);

    int saveAppGuangGao(AppGuangGao appGuangGao);

    AppGuangGao selectAppGuangGaoByPrimary(int appGuangGaoId);

    List<AppGuangGao> guangGaoList(AppGuangGao appGuangGao);

    int deleteGuangGao(int id);

}
