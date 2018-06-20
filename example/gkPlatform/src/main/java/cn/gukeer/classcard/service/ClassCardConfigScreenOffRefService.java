package cn.gukeer.classcard.service;

import cn.gukeer.classcard.modelView.ClassCardConfigScreenOffView;

import java.util.HashMap;
import java.util.List;

/**
 * 开关机配置中的 “时间段配置”
 */
public interface ClassCardConfigScreenOffRefService {

    Integer insertClassCardConfigScreenRef(String refId, String screenOffWeek, HashMap<String, String> screenOffTimeList);

    Integer deleteClassCardConfigScreenRef(String[] configIdArr);

    Integer updateClassCardConfigScreenRef(String id, String screenOffWeek, HashMap<String, String> screenOffTimeList);

    List<ClassCardConfigScreenOffView> findListClassCardScreenOffByCCCId(String classCardConfigId);
}
