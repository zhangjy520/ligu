package cn.gukeer.classcard.controller;

import cn.gukeer.classcard.modelView.ClassCardAppView;
import cn.gukeer.classcard.modelView.ClassCardView;
import cn.gukeer.classcard.persistence.entity.ClassCard;
import cn.gukeer.classcard.persistence.entity.ClassCardApp;
import cn.gukeer.classcard.persistence.entity.ClassCardAppRef;
import cn.gukeer.classcard.service.ClassCardAppService;
import cn.gukeer.classcard.service.ClassCardService;
import cn.gukeer.classcard.util.ApkFeedBackStatus;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.utils.NumberConvertUtil;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.common.utils.StringUtils;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import cn.gukeer.sync.netty.classCardAttendance.ClassCardCommandServer;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wulianedu.netty.server.ServerInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 18-1-9.
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController extends BasicController {

    @Autowired
    ClassCardAppService classCardAppService;

    @Autowired
    ClassCardService classCardService;

    @Autowired
    CacheManager cacheManager;

    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_command_port = Integer.parseInt((String) properties.get("netty_classcard_command_port"));


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {

        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);
        String appName = getParamVal(request, "appName");
        try {
            appName = java.net.URLDecoder.decode(appName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        PageInfo<ClassCardAppView> pageInfo = classCardAppService.findAllClassCardApp(getLoginUser().getSchoolId(), appName, pageNum, pageSize);
        formatAppUploadTime(pageInfo.getList());

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("appName", appName);
        return "classCard/app/index";
    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Model model) {

        String appId = getParamVal(request, "appId");
        if (StringUtils.isNotBlank(appId)) {
            ClassCardApp classCardApp = classCardAppService.findClassCardAppById(appId);
            model.addAttribute("classCardApp", classCardApp);
        } else {
            model.addAttribute("classCardApp", null);
        }
        model.addAttribute("appId", appId);
        model.addAttribute("domain", (String) properties.get("domain") + "/");
        model.addAttribute("uptoken_url", "file/getuptoken");
        model.addAttribute("schoolId", getLoginUser().getSchoolId());
        return "classCard/app/edit";
    }

    // TODO: 18-5-16 修改apk也要推送最新的
    @ResponseBody
    @RequestMapping(value = "modify")
    public ResultEntity modifyClassCardApp(HttpServletRequest request) {
        String appId = getParamVal(request, "appId");
        String appName = getParamVal(request, "appName");
        String appUrl = getParamVal(request, "appUrl");
        String versionCode_ = getParamVal(request, "versionCode");
        int versionCode = NumberConvertUtil.convertS2I(versionCode_);
        String packageName = getParamVal(request, "packageName");
        String autoStart = getParamVal(request, "autoStart");
        String fileName = getParamVal(request, "fileName");

        ClassCardApp classCardApp = new ClassCardApp();
        classCardApp.setAppName(appName);
        classCardApp.setAppUrl(appUrl);
        classCardApp.setVersionCode(versionCode);
        classCardApp.setPackageName(packageName);
        classCardApp.setAutoStart(NumberConvertUtil.convertS2I(autoStart));
        classCardApp.setFileName(fileName);
        try {
            if (StringUtils.isBlank(appId)) {
                if (null != classCardAppService.findAppByName(appName, getLoginUser().getSchoolId())) {
                    return ResultEntity.newErrEntity("模块名称已存在");
                }
                if (null != classCardAppService.findAppByPackageName(packageName, getLoginUser().getSchoolId())) {
                    return ResultEntity.newErrEntity("包名已存在");
                }
                classCardApp.setId(PrimaryKey.get());
                classCardApp.setCreateBy(getLoginUser().getId());
                classCardApp.setCreateDate(System.currentTimeMillis());
                classCardApp.setSchoolId(getLoginUser().getSchoolId());
                if (classCardAppService.insertClassCardApp(classCardApp)) {
                    return ResultEntity.newResultEntity();
                }
            } else {
                classCardApp.setId(appId);
                classCardApp.setUpdateBy(getLoginUser().getId());
                classCardApp.setUpdateDate(System.currentTimeMillis());
                if (classCardAppService.updateClassCardApp(classCardApp)) {

                    //修改apk后推送相应设备
                    ServerInstance instance = ClassCardCommandServer.getInstance_command();
                    CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
                    List<ClassCardAppRef> cardAppRefs = classCardAppService.findRefByAppId(appId);
                    con:
                    for (ClassCardAppRef ref : cardAppRefs) {
                        ClassCard classCard = classCardService.findClassCardByClassCardId(ref.getClassCardId());
                        if (null == classCard) {
                            continue;
                        }
                        String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_command_port;

                        //管道连通,可推送数据
                        if (instance.channelStatus(macFormate)) {
                            System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                            Map<String, Object> installMap = new HashMap<>();
                            installMap.put("command", ClassCardCommand.APK_INSTALL);
                            List<Map<String, Object>> classCardAppList = new ArrayList<>();
                            Map<String, Object> appListMap = new HashMap<>();
                            appListMap.put("time", System.currentTimeMillis());
                            appListMap.put("apk", classCardApp);
                            classCardAppList.add(appListMap);
                            installMap.put("data", classCardAppList);
                            instance.sendMessage(macFormate, new Gson().toJson(installMap));
                            System.out.println("===============Data sent successfully=============" + new Gson().toJson(installMap));
                            //推送失败放到缓存
                        } else {
                            System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when install apk mac:" + macFormate);
                            Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.APK_INSTALL);
                            //缓存中有该mac对应的指令
                            if (null != obj) {
                                Map<String, Object> installMap = (Map<String, Object>) obj;
                                List<Map<String, Object>> dataList = (List<Map<String, Object>>) installMap.get("data");
                                //若缓存中有该app信息则更新修改时间（time）
                                for (Map<String, Object> dataMap : dataList) {
                                    ClassCardApp apk = (ClassCardApp) dataMap.get("apk");
                                    if (apk.getId().equals(classCardApp.getId())) {
                                        dataMap.put("time", System.currentTimeMillis());
                                        dataMap.put("apk", classCardApp);
                                        continue con;
                                    }
                                }
                                Map<String, Object> addMap = new HashMap<>();
                                addMap.put("time", System.currentTimeMillis());
                                addMap.put("apk", classCardApp);
                                dataList.add(addMap);
                                cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_INSTALL, installMap);
                                //缓存中没有该mac对应的指令
                            } else {
                                Map<String, Object> installMap = new HashMap<>();
                                List<Map<String, Object>> classCardAppList = new ArrayList<>();
                                Map<String, Object> appListMap = new HashMap<>();
                                appListMap.put("time", System.currentTimeMillis());
                                appListMap.put("apk", classCardApp);
                                classCardAppList.add(appListMap);
                                installMap.put("command", ClassCardCommand.APK_INSTALL);
                                installMap.put("data", classCardAppList);
                                cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_INSTALL, installMap);
                            }
                        }
                    }
                    return ResultEntity.newResultEntity();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void formatAppUploadTime(List<ClassCardAppView> classCardAppViews) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ClassCardAppView classCardAppView : classCardAppViews) {
            if (classCardAppView != null && classCardAppView.getCreateDate() != null) {
                classCardAppView.setUploadTime(sdf.format(new Date(classCardAppView.getCreateDate())));
            }
        }
    }

    /**
     * 获取全部班牌
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "chooseclasscard", method = RequestMethod.GET)
    public String chooseClassCard(HttpServletRequest request, Model model) {
        String appIds = getParamVal(request, "appIds");
        Map<String, Map<String, List<ClassCardView>>> resultMap = classCardService.selectEquipmentForNotify();
        JsonObject returnData = new JsonParser().parse(new Gson().toJson(resultMap)).getAsJsonObject();

        //查找分配过该app的班牌
        List<ClassCardView> classCards = classCardAppService.findClassCardByappId(appIds, getLoginUser().getSchoolId());
        StringBuilder checkedIds = new StringBuilder();
        classCards.forEach(card -> {
            checkedIds.append(card.getId()).append(",");
        });
        model.addAttribute("checkedIds", checkedIds);
        model.addAttribute("returnData", returnData);
        model.addAttribute("appIds", appIds);
        return "classCard/app/chooseclasscard";
    }

    /**
     * 为班牌分配应用
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "classcard-app", method = RequestMethod.POST)
    public ResultEntity distributionAppSave(HttpServletRequest request) {
        String checkedClassCardIds = getParamVal(request, "checkedClassCardIds");
        String appIds = getParamVal(request, "appIds");

        if (StringUtils.isBlank(checkedClassCardIds)) {
            return ResultEntity.newErrEntity("未选择班牌！");
        }
        if (StringUtils.isBlank(appIds)) {
            return ResultEntity.newErrEntity("未选择模块！");
        }

        List<String> classCardIdList = Arrays.asList(checkedClassCardIds.split(","));
        List<String> classAppIdList = Arrays.asList(appIds.split(","));

        //入库的对应关系数据
        List<ClassCardAppRef> batchInsertRefs = new ArrayList<>();
        //推送的数据
        List<ClassCardAppRef> tmpRefs = new ArrayList<>();
        for (String appId : classAppIdList) {
            for (String classCardId : classCardIdList) {
                ClassCardAppRef appRefs = classCardAppService.findRefByClassCardIdAndAppId(classCardId, appId);
                ClassCardAppRef tmpRef = new ClassCardAppRef();
                // TODO: 18-5-11 这里逻辑不对,如果更新apk则没有时间....等返回安装结果改
                //为班牌增加新的apk
                if (appRefs == null) {
                    ClassCardAppRef classCardAppRef = new ClassCardAppRef();
                    classCardAppRef.setClassCardAppId(appId);
                    classCardAppRef.setClassCardId(classCardId);
                    classCardAppRef.setSchoolId(getLoginUser().getSchoolId());
                    classCardAppRef.setId(PrimaryKey.get());
                    classCardAppRef.setCreateDate(System.currentTimeMillis());
                    classCardAppRef.setCreateBy(getLoginUser().getId());
                    batchInsertRefs.add(classCardAppRef);
                    tmpRefs.add(classCardAppRef);
                } else {
                    tmpRef = appRefs;
                    tmpRef.setFeedBackRemarks(appRefs.getFeedBackRemarks());
                    tmpRef.setFeedBackTime(appRefs.getFeedBackTime());
                    tmpRef.setFeedBackStatus(appRefs.getFeedBackStatus());
                    tmpRefs.add(tmpRef);
                }
            }
        }
        //批量插入分配给班牌的模块
        try {

            if (batchInsertRefs != null && batchInsertRefs.size() > 0) {
                classCardAppService.batchInsertClassCardAppRef(batchInsertRefs);
            }
            ServerInstance instance = ClassCardCommandServer.getInstance_command();
            CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

            st:
            for (ClassCardAppRef ccr : tmpRefs) {
                //更新分配时间
                ccr.setCreateDate(System.currentTimeMillis());
                try {
                    classCardAppService.updateClassCardAppRef(ccr);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                ClassCard classCard = classCardService.findClassCardByClassCardId(ccr.getClassCardId());
                ClassCardApp classCardApp = classCardAppService.findClassCardAppById(ccr.getClassCardAppId());
                if (null == classCard || null == classCardApp) {
                    continue;
                }
                String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_command_port;

                //管道连通,可推送数据
                if (instance.channelStatus(macFormate)) {
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                    Map<String, Object> installMap = new HashMap<>();
                    installMap.put("command", ClassCardCommand.APK_INSTALL);
                    List<Map<String, Object>> classCardAppList = new ArrayList<>();
                    Map<String, Object> appListMap = new HashMap<>();
                    appListMap.put("time", System.currentTimeMillis());
                    appListMap.put("apk", classCardApp);
                    classCardAppList.add(appListMap);
                    installMap.put("data", classCardAppList);
                    instance.sendMessage(macFormate, new Gson().toJson(installMap));
                    System.out.println("===============Data sent successfully=============" + new Gson().toJson(installMap));
                    //推送失败放到缓存
                } else {
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when install apk mac:" + macFormate);

                    //安装状态置为失败
                    if (ccr.getFeedBackStatus() == null || ccr.getFeedBackStatus() == ApkFeedBackStatus.APK_FEED_BACK_STATUS_FAIL.getIndex()) {
                        ccr.setFeedBackTime(System.currentTimeMillis());
                        ccr.setFeedBackStatus(ApkFeedBackStatus.APK_FEED_BACK_STATUS_FAIL.getIndex());
                        ccr.setFeedBackRemarks(ApkFeedBackStatus.APK_FEED_BACK_STATUS_FAIL.getStatus());
                        try {
                            classCardAppService.updateClassCardAppRef(ccr);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.APK_INSTALL);
                    //缓存中有该mac对应的指令
                    if (null != obj) {
                        Map<String, Object> installMap = (Map<String, Object>) obj;
                        List<Map<String, Object>> dataList = (List<Map<String, Object>>) installMap.get("data");
                        //若缓存中有该app信息则更新修改时间（time）
                        for (Map<String, Object> dataMap : dataList) {
                            ClassCardApp apk = (ClassCardApp) dataMap.get("apk");
                            if (apk.getId().equals(classCardApp.getId())) {
                                dataMap.put("time", System.currentTimeMillis());
                                dataMap.put("apk", classCardApp);
                                continue st;
                            }
                        }
                        Map<String, Object> addMap = new HashMap<>();
                        addMap.put("time", System.currentTimeMillis());
                        addMap.put("apk", classCardApp);
                        dataList.add(addMap);
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_INSTALL, installMap);
                        //缓存中没有该mac对应的指令
                    } else {
                        Map<String, Object> installMap = new HashMap<>();
                        List<Map<String, Object>> classCardAppList = new ArrayList<>();
                        Map<String, Object> appListMap = new HashMap<>();
                        appListMap.put("time", System.currentTimeMillis());
                        appListMap.put("apk", classCardApp);
                        classCardAppList.add(appListMap);
                        installMap.put("command", ClassCardCommand.APK_INSTALL);
                        installMap.put("data", classCardAppList);
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_INSTALL, installMap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newResultEntity();
    }

    /**
     * 获取班牌全部app
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "classcard-app", method = RequestMethod.GET)
    public String distributionAppShow(HttpServletRequest request, Model model) {

        String id = getParamVal(request, "id");
        List<ClassCardAppRef> cardAppRefs = classCardAppService.findRefByClassCardId(id);

        List<String> appIdList = new ArrayList<>();
        if (cardAppRefs != null && cardAppRefs.size() > 0) {
            for (ClassCardAppRef cardAppRef : cardAppRefs) {
                appIdList.add(cardAppRef.getClassCardAppId());
            }
        }
        List<ClassCardApp> classCardApps = new ArrayList<>();
        if (appIdList.size() > 0) {
            classCardApps = classCardAppService.findAppByIds(appIdList);
        }
        Properties properties = PropertiesUtil.getProperties("api.properties");
        String superPackage = (String) properties.get("super_apk_package_name");
        model.addAttribute("superPackage", superPackage);

        model.addAttribute("classCardApps", classCardApps);
        model.addAttribute("classCardId", id);
        return "classCard/app/showclasscardapp";
    }


    /**
     * 卸载班牌的某个app
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteClassCardAppRef")
    public ResultEntity deleteClassCardAppRef(HttpServletRequest request) {
        String classCardId = getParamVal(request, "classCardId");
        String appIds = getParamVal(request, "appIds");
        if (StringUtils.isBlank(appIds)) {
            return ResultEntity.newErrEntity();
        }

        int ret = pushDelOrUnInstall(appIds, classCardId);
        if (ret == 0) {
            return ResultEntity.newResultEntity();
        } else {
            return ResultEntity.newErrEntity("卸载失败,请检查网络状况或重新安\"后台管理\"apk再推送应用");
        }
    }

    @ResponseBody
    @RequestMapping(value = "multidelete")
    public ResultEntity multideleteApp(HttpServletRequest request) {
        String appIds = getParamVal(request, "appIds");
        if (StringUtils.isBlank(appIds)) {
            return ResultEntity.newErrEntity("未选择模块");
        }
        String[] appIdArray = appIds.split(",");
        List<ClassCardApp> cardApps = classCardAppService.findAppByIds(Arrays.asList(appIdArray));
        Properties properties = PropertiesUtil.getProperties("api.properties");
        String superPackage = (String) properties.get("super_apk_package_name");
        //不删除班牌，后台管理两个模块
        for (ClassCardApp app : cardApps) {
            if (superPackage.contains(app.getPackageName())) {
                return ResultEntity.newErrEntity("班牌和后台管理模块不可删除！");
            }
        }
        int ret = pushDelOrUnInstall(appIds, null);
        if (ret != 0) {
            return ResultEntity.newErrEntity();
        }
        try {
            if (classCardAppService.deleteClassCardApp(Arrays.asList(appIdArray))) {
                return ResultEntity.newResultEntity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/findappclasscard")
    public String findAppClasscard(HttpServletRequest request, Model model) {
        String appId = getParamVal(request, "appId");
        List<ClassCardView> classCards = classCardAppService.findClassCardByappId(appId, getLoginUser().getSchoolId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        classCards.forEach(classcard -> {
            if (classcard != null) {
                if (classcard.getCardRefAppCreateDate() != null) {
                    classcard.setAppDistributionTime(simpleDateFormat.format(new Date(classcard.getCardRefAppCreateDate())));
                } else {
                    classcard.setAppDistributionTime("");
                }
                if (classcard.getFeedBackStatus() != null) {
                    classcard.setAppStatus((ApkFeedBackStatus.getValue(classcard.getFeedBackStatus())).split(",")[0]);
                }
                if (classcard.getFeedBackTime() != null) {
                    classcard.setFeedBackTimeFormat(simpleDateFormat.format(new Date(classcard.getFeedBackTime())));
                } else {
                    classcard.setFeedBackTimeFormat("");
                }
            }
        });

        model.addAttribute("classCards", classCards);
        model.addAttribute("size", classCards.size());
        return "classCard/app/showappclasscard";
    }


    public int pushDelOrUnInstall(String appIds, String classCardId) {
        int ret = 0;
        String[] appIdArr = appIds.split(",");
        for (String appId : appIdArr) {
            ClassCardApp classCardApp = classCardAppService.findClassCardAppById(appId);
            List<ClassCardAppRef> appRefs = new ArrayList<>();
            //卸载单个班牌的
            if (StringUtils.isNotBlank(classCardId)) {
                ClassCardAppRef ref = classCardAppService.findRefByClassCardIdAndAppId(classCardId, appId);
                appRefs.add(ref);
            }
            //卸载班牌的多个
            else {
                appRefs = classCardAppService.findRefByAppId(appId);
            }

            for (ClassCardAppRef ref : appRefs) {
                ClassCard classCard = classCardService.findClassCardByClassCardId(ref.getClassCardId());
                if (null == classCard || null == classCardApp) {
                    return ret++;
                }

                String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_command_port;

                ServerInstance instance = ClassCardCommandServer.getInstance_command();
                CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
                //通道畅通
                if (instance.channelStatus(macFormate)) {
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                    Map<String, Object> unInstallMap = new HashMap<>();
                    unInstallMap.put("command", ClassCardCommand.APK_UNINSTALL);
                    List<Map<String, Object>> classCardAppList = new ArrayList<>();
                    Map<String, Object> appListMap = new HashMap<>();
                    appListMap.put("time", System.currentTimeMillis());
                    appListMap.put("apk", classCardApp);
                    classCardAppList.add(appListMap);
                    unInstallMap.put("data", classCardAppList);
                    instance.sendMessage(macFormate, new Gson().toJson(unInstallMap));
                    System.out.println("===============Data sent successfully=============" + new Gson().toJson(unInstallMap));
                    try {
                        classCardAppService.deleteClassCardAppRef(classCard.getId(), appId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //推送失败放到缓存
                } else {
                    ret++;
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when delete or uninstall apk mac:" + macFormate);
                    //应用设置为卸载失败状态
                    ref.setUpdateDate(System.currentTimeMillis());
                    ref.setUninstallStatus(ApkFeedBackStatus.APK_FEED_BACK_STATUS_UNINSTALL_FAIL.getIndex());
                    try {
                        classCardAppService.updateClassCardAppRef(ref);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.APK_UNINSTALL);
                    //缓存中有该mac对应的指令
                    if (null != obj) {
                        Map<String, Object> unInstallMap = (Map<String, Object>) obj;
                        List<Map<String, Object>> dataList = (List<Map<String, Object>>) unInstallMap.get("data");
                        //若缓存中有该app信息则更新修改时间（time）
                        for (Map<String, Object> dataMap : dataList) {
                            ClassCardApp apk = (ClassCardApp) dataMap.get("apk");
                            if (apk.getId().equals(classCardApp.getId())) {
                                dataMap.put("time", System.currentTimeMillis());
                                return ret;
                            }
                        }
                        Map<String, Object> addMap = new HashMap<>();
                        addMap.put("time", System.currentTimeMillis());
                        addMap.put("apk", classCardApp);
                        dataList.add(addMap);
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_UNINSTALL, unInstallMap);
                        //缓存中没有该mac对应的指令
                    } else {
                        Map<String, Object> unInstallMap = new HashMap<>();
                        List<Map<String, Object>> classCardAppList = new ArrayList<>();
                        Map<String, Object> appListMap = new HashMap<>();
                        appListMap.put("time", System.currentTimeMillis());
                        appListMap.put("apk", classCardApp);
                        classCardAppList.add(appListMap);
                        unInstallMap.put("command", ClassCardCommand.APK_UNINSTALL);
                        unInstallMap.put("data", classCardAppList);
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.APK_UNINSTALL, unInstallMap);
                    }
                }
            }
        }
        return ret;
    }
}
