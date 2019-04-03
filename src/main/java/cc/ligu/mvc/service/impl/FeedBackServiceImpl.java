package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.mvc.persistence.dao.FeedBackMapper;
import cc.ligu.mvc.persistence.dao.SourceMapper;
import cc.ligu.mvc.persistence.entity.FeedBack;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.persistence.entity.SourceExample;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.FeedBackService;
import cc.ligu.mvc.service.SourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class FeedBackServiceImpl extends BasicService implements FeedBackService {


    @Autowired
    FeedBackMapper feedBackMapper;

    @Override
    public int saveFeedBack(FeedBack feedBack, UserView userView) {
        if (null == feedBack.getId() || feedBack.getId() == 0) {
            //insert
            feedBack.setPersonId(userView.getRefId());
            feedBackMapper.insertSelective(feedBack);
        } else {
            //update
            feedBackMapper.updateByPrimaryKeySelective(feedBack);
        }
        return 0;
    }

    @Override
    public List<HashMap> selectFeedBackList() {
        List<HashMap> res = feedBackMapper.selectFeedBackList();
        for (HashMap m : res) {
            m.put("time", DateUtils.millsToyyyyMMdd(Long.valueOf(m.get("time").toString())));
        }
        return res;
    }
}
