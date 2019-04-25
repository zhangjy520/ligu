package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.AppGuangGaoMapper;
import cc.ligu.mvc.persistence.dao.AppGuangGaoMapper;
import cc.ligu.mvc.persistence.entity.AppGuangGao;
import cc.ligu.mvc.persistence.entity.AppGuangGaoExample;
import cc.ligu.mvc.service.AppGuangGaoService;
import cc.ligu.mvc.service.AppGuangGaoService;
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
public class AppGuangGaoServiceImpl extends BasicService implements AppGuangGaoService {

    @Autowired
    AppGuangGaoMapper appGuangGaoMapper;

    @Override
    public PageInfo<AppGuangGao> listAllAppGuangGao(int pageSize, int pageNum, AppGuangGao appGuangGao) {
        AppGuangGaoExample example = new AppGuangGaoExample();
        example.createCriteria().andIdIsNotNull();

        PageHelper.startPage(pageNum, pageSize);
        List<AppGuangGao> GuangGaoList = appGuangGaoMapper.selectByExample(example);
        PageInfo<AppGuangGao> page = new PageInfo<AppGuangGao>(GuangGaoList);

        return page;
    }

    @Override
    public int saveAppGuangGao(AppGuangGao appGuangGao) {
        if (StringUtils.isEmpty(appGuangGao.getId())) {
            appGuangGaoMapper.insertSelective(appGuangGao);
        } else {
            appGuangGaoMapper.updateByPrimaryKeySelective(appGuangGao);
        }
        return 1;
    }

    @Override
    public AppGuangGao selectAppGuangGaoByPrimary(int appGuangGaoId) {
        return appGuangGaoMapper.selectByPrimaryKey(appGuangGaoId);
    }

    @Override
    public List<AppGuangGao> guangGaoList(AppGuangGao appGuangGao) {
        AppGuangGaoExample example = new AppGuangGaoExample();
        AppGuangGaoExample.Criteria cri = example.createCriteria();

        if (!StringUtils.isEmpty(appGuangGao.getType())) {
            cri.andTypeEqualTo(appGuangGao.getType());
        }
        return appGuangGaoMapper.selectByExample(example);
    }

    @Override
    public int deleteGuangGao(int id) {
        return appGuangGaoMapper.deleteByPrimaryKey(id);
    }
}
