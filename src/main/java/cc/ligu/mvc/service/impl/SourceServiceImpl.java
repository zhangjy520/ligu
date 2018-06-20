package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.QuestionMapper;
import cc.ligu.mvc.persistence.dao.SourceMapper;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.QuestionService;
import cc.ligu.mvc.service.SourceService;
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
public class SourceServiceImpl extends BasicService implements SourceService {

    @Autowired
    SourceMapper sourceMapper;

    @Override
    public PageInfo<Source> listAllSource(int pageSize, int pageNum, Source source) {
        SourceExample sourceExample = new SourceExample();
        SourceExample.Criteria criteria = sourceExample.createCriteria().andDelFlagEqualTo(0);

        if (!StringUtils.isEmpty(source.getName())) {
            criteria.andNameLike("%" + source.getName() + "%");
        }
        if (source.getType()!=0){
            criteria.andTypeEqualTo(source.getType());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Source> questionList = sourceMapper.selectByExample(sourceExample);
        PageInfo<Source> page = new PageInfo<Source>(questionList);

        //查询文档，设置该文档请求数+1;
        for (Source sourceUpdate :questionList) {
            sourceUpdate.setApplyTime(sourceUpdate.getApplyTime()+1);
            sourceMapper.updateByPrimaryKeySelective(sourceUpdate);
        }
        return page;
    }

    @Override
    public int saveSource(Source source, UserView userView) {
        if (StringUtils.isEmpty(source.getId())) {
            source.setCreateDate(System.currentTimeMillis());//创建时间
            source.setCreateBy(userView.getId());//创建人
            sourceMapper.insertSelective(source);
        } else {
            source.setUpdateBy(userView.getId());
            source.setUpdateDate(System.currentTimeMillis());
            sourceMapper.updateByPrimaryKeySelective(source);
        }
        return 1;
    }

    @Override
    public Source selectSourceByPrimary(int sourceId) {
        return sourceMapper.selectByPrimaryKey(sourceId);
    }

    @Override
    public int deleteSource(Source source) {
        return sourceMapper.deleteByPrimaryKey(source.getId());
    }
}
