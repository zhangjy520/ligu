package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.QuestionMapper;
import cc.ligu.mvc.persistence.dao.SourceMapper;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.QuestionExample;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.persistence.entity.SourceExample;
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
        return page;
    }

    @Override
    public int saveSource(Source source) {
        if (StringUtils.isEmpty(source.getId())) {
            source.setCreateBy(9999);//创建人
            source.setCreateDate(System.currentTimeMillis());//创建时间
            sourceMapper.insertSelective(source);
        } else {
            source.setUpdateBy(9999);
            source.setUpdateDate(System.currentTimeMillis());
            sourceMapper.updateByPrimaryKeySelective(source);
        }
        return 1;
    }

    @Override
    public Source selectSourceByPrimery(int sourceId) {
        return sourceMapper.selectByPrimaryKey(sourceId);
    }

    @Override
    public int deleteSource(Source source) {
        return sourceMapper.deleteByPrimaryKey(source.getId());
    }
}
