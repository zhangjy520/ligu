package cc.ligu.mvc.service.impl;

import cc.ligu.mvc.persistence.dao.LoginLogMapper;
import cc.ligu.mvc.persistence.entity.LoginLog;
import cc.ligu.mvc.persistence.entity.LoginLogExample;
import cc.ligu.mvc.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public int saveLoginLog(LoginLog loginLog) {
        LoginLogExample loginLogExample = new LoginLogExample();
        loginLogExample.createCriteria().andSysUserIdEqualTo(loginLog.getSysUserId())
                .andRefPersonIdEqualTo(loginLog.getRefPersonId());

        List<LoginLog> loginRecord = loginLogMapper.selectByExample(loginLogExample);
        if (loginRecord.size()>0){
            loginLog.setId(loginRecord.get(0).getId());
        }

        if (StringUtils.isEmpty(loginLog.getId())) {
            //getId 封装Integer类型,默认值null
            return loginLogMapper.insertSelective(loginLog);
        } else {
            return loginLogMapper.updateByPrimaryKeySelective(loginLog);
        }
    }

    @Override
    public Map loginReport() {
        LoginLogExample exampleTodayUsers = new LoginLogExample();
        exampleTodayUsers.createCriteria().andLoginDateGreaterThan(getTodayStart().getTime());
        List<LoginLog> todayUsers = loginLogMapper.selectByExample(exampleTodayUsers);

        LoginLogExample exampleCurrent = new LoginLogExample();
        exampleCurrent.createCriteria().andLoginStatusEqualTo(0);//0登录中 1已经退出 2其他
        List<LoginLog> currentLoginUsers = loginLogMapper.selectByExample(exampleCurrent);

        Map result = new HashMap();
        result.put("todayUsers",todayUsers.size());//今日活跃度
        result.put("currentLoginUsers",currentLoginUsers.size());//当前正在登录的数量

        return result;
    }

    public static Date getTodayStart() {
        Calendar calendar = Calendar.getInstance();
        return doGetDateStart(calendar);
    }

    private static Date doGetDateStart(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

}
