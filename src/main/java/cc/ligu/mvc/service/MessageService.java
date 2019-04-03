package cc.ligu.mvc.service;


import cc.ligu.mvc.persistence.entity.NoticeMessage;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface MessageService {

    //定时检查保险，薪资过期消息,并存入noticce_message
    void saveMessage();

    //查询
    PageInfo<NoticeMessage> listPageMessage(int pageSize,int pageNum);
}
