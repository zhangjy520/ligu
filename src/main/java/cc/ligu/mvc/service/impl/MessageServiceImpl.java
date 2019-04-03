package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.mvc.modelView.MessageView;
import cc.ligu.mvc.persistence.dao.FeedBackMapper;
import cc.ligu.mvc.persistence.dao.NoticeMessageMapper;
import cc.ligu.mvc.persistence.entity.FeedBack;
import cc.ligu.mvc.persistence.entity.NoticeMessage;
import cc.ligu.mvc.persistence.entity.NoticeMessageExample;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.FeedBackService;
import cc.ligu.mvc.service.MessageService;
import cc.ligu.mvc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class MessageServiceImpl extends BasicService implements MessageService {

    @Autowired
    UserService userService;

    @Autowired
    NoticeMessageMapper noticeMessageMapper;

    @Override
    public void saveMessage() {
        HashMap query = userService.selectAllInsuPassUsers();
        HashMap query1 = userService.selectAllSalaryPassUsers();
        List<UserView> insu1 = (List<UserView>) query.get("noSet");//保险未发放人员
        List<UserView> insu2 = (List<UserView>) query.get("overTime");//保险过期人员
        List<UserView> salary1 = (List<UserView>) query1.get("noSet");//薪资未发放人员
        List<HashMap> salary2 = (List<HashMap>) query1.get("overTime");//薪资过期人员
        //保险未交 消息
        for (UserView view : insu1) {
            NoticeMessage noticeMessage = new NoticeMessage();
            noticeMessage.setTitle("保险未交");
            noticeMessage.setMessage("该工人保险未缴纳");
            noticeMessage.setNoticeTo(view.getRefId());
            noticeMessage.setNoticeFrom(0);//系统定时任务触发
            noticeMessage.setNoticeTime(DateUtils.getYYYYMMDD());
            noticeMessage.setType(MessageView.INSU_NOT_SEND);
            noticeMessage.setRemark(view.getName());
            noticeMessage.setFlag("0,"+view.getRefId()+","+MessageView.INSU_NOT_SEND);//通知时间，人ID,消息类别(用来判断此条消息是否已经发送过，如果发生过，不再入库)
            try {
                noticeMessageMapper.insertSelectiveDuUpdate(noticeMessage);
            }catch (Exception e){
                //flag会唯一校验，插入冲突是正常情况，同条消息不多次发送
            }
        }
        //保险过期 消息
        for (UserView view : insu2) {
            NoticeMessage noticeMessage = new NoticeMessage();
            noticeMessage.setTitle("保险过期");
            noticeMessage.setMessage("该工人保险有效期是：" + view.getInsuTime() + ",现在已过期");
            noticeMessage.setNoticeTo(view.getRefId());
            noticeMessage.setNoticeFrom(0);//系统定时任务触发
            noticeMessage.setNoticeTime(view.getInsuTime());
            noticeMessage.setType(MessageView.INSU_OVER_TIME);
            noticeMessage.setRemark(view.getName());
            noticeMessage.setFlag(view.getInsuTime()+","+view.getRefId()+","+MessageView.INSU_OVER_TIME);//通知时间，人ID,消息类别(用来判断此条消息是否已经发送过，如果发生过，不再入库)
            try {
                noticeMessageMapper.insertSelectiveDuUpdate(noticeMessage);
            }catch (Exception e){
                //flag会唯一校验，插入冲突是正常情况，同条消息不多次发送
            }
        }

        //工程款和生活费未发 消息
        for (UserView view : salary1) {
            NoticeMessage noticeMessage = new NoticeMessage();
            noticeMessage.setTitle("薪资未发");
            noticeMessage.setMessage("该工人工程款和生活费未发放");
            noticeMessage.setNoticeTo(view.getRefId());
            noticeMessage.setNoticeFrom(0);//系统定时任务触发
            noticeMessage.setNoticeTime(DateUtils.getYYYYMMDD());
            noticeMessage.setRemark(view.getName());
            noticeMessage.setType(MessageView.SALARY_NOT_SEND);
            noticeMessage.setFlag("0"+","+view.getRefId()+","+MessageView.SALARY_NOT_SEND);//通知时间，人ID,消息类别(用来判断此条消息是否已经发送过，如果发生过，不再入库)
            try {
                noticeMessageMapper.insertSelectiveDuUpdate(noticeMessage);
            }catch (Exception e){
                //flag会唯一校验，插入冲突是正常情况，同条消息不多次发送
            }
        }

        //工程款或生活费超时过期 消息
        for (HashMap view : salary2) {
            NoticeMessage noticeMessage = new NoticeMessage();
            noticeMessage.setTitle("薪资过期");
            noticeMessage.setMessage("该工人" + view.get("fee_type") + " " + view.get("send_time") + "之后的未发放");
            noticeMessage.setNoticeFrom(0);//系统定时任务触发
            noticeMessage.setNoticeTime(view.get("send_time").toString());
            noticeMessage.setRemark(view.get("person_name").toString());
            noticeMessage.setType(MessageView.SALARY_OVER_TIME);
            noticeMessage.setFlag(view.get("send_time")+","+view.get("person_num")+","+MessageView.SALARY_OVER_TIME);//通知时间，人ID,消息类别(用来判断此条消息是否已经发送过，如果发生过，不再入库)
            try {
                noticeMessageMapper.insertSelectiveDuUpdate(noticeMessage);
            }catch (Exception e){
                //flag会唯一校验，插入冲突是正常情况，同条消息不多次发送
            }
        }
    }

    @Override
    public PageInfo<NoticeMessage> listPageMessage(int pageSize, int pageNum) {
        NoticeMessageExample example = new NoticeMessageExample();
        example.setOrderByClause("notice_message.`type` desc ,notice_message.`notice_time` desc");
        example.createCriteria().andDelFlagEqualTo(0).andIsReadEqualTo(0);
        PageHelper.startPage(pageNum,pageSize);

        List<NoticeMessage> res = noticeMessageMapper.selectByExample(example);
        PageInfo<NoticeMessage> pageInfo = new PageInfo<>(res);
        return pageInfo;
    }
}
