package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.FeedBack;
import cc.ligu.mvc.persistence.entity.UserView;

import java.util.HashMap;
import java.util.List;

public interface FeedBackService {
    int saveFeedBack(FeedBack feedBack, UserView userView);
    List<HashMap> selectFeedBackList();

}
