package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.LoginLog;

import java.util.Map;

/*
 * @Author zhangjianyu
 * @Description //登录日志表
 * @return
 **/
public interface LoginLogService {

    //保存，修改登录日志  0登录中 1已经退出 2其他
    int saveLoginLog(LoginLog loginLog);

    //登录统计(当前在线人数,当日活跃用户数)
    Map loginReport();
}
