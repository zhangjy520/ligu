package cn.gukeer.classcard.controller;

import cn.gukeer.classcard.modelView.ClassCardCustomPageView;
import cn.gukeer.classcard.persistence.entity.*;
import cn.gukeer.classcard.service.*;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.utils.*;
import cn.gukeer.platform.common.UserRoleType;
import cn.gukeer.platform.persistence.entity.User;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import cn.gukeer.sync.netty.classCardAttendance.ClassCardCustomizeServer;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.wulianedu.netty.server.ServerInstance;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by leeyh on 18-1-16.
 */
@Controller
@RequestMapping(value = "/classcard/custom")
public class ClassCardCustomContorller extends BasicController {

    @Autowired
    ClassCardService classCardService;
    @Autowired
    ClassCardCustomPageService pageService;
    @Autowired
    ClassCardCustomRefService customRefService;
    @Autowired
    ClassCardCustomTemplateService templateService;
    @Autowired
    ClassCardCustomContentRefService contentRefService;
    @Autowired
    CacheManager cacheManager;
    @Autowired
    ClassSpacePictureService classSpacePictureService;
    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_customize_port = Integer.parseInt((String) properties.get("netty_classcard_customize_port"));

    /**
     * 自定义主页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexCustom(HttpServletRequest request, Model model) {
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        PageInfo<ClassCardCustomPageView> pageInfo = new PageInfo<>();
        if (subject.isAuthenticated()) {
            if (subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN) || subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN)) {
                pageInfo = pageService.findAllPageBySchoolId(user.getSchoolId(), pageNum, pageSize);
            } else {
                List<ClassCard> classCards = classCardService.findClassCardByTeacherId(user.getRefId());
                List<String> classCardIds = new ArrayList<>();
                for (ClassCard classCard : classCards) {
                    classCardIds.add(classCard.getId());
                }
                pageInfo = pageService.findAllConfigByClassCardIds(classCardIds, user.getId(), pageNum, pageSize);
            }
        }
        List<ClassCardCustomPageView> pageViewList = pageService.transformPage(pageInfo.getList());
        pageInfo.setList(pageViewList);
        model.addAttribute("pageInfo", pageInfo);
        return "/classCard/custom/index";
    }

    /**
     * 新增page的时候选择模板
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectTemplate")
    public String selectTemplate(HttpServletRequest request, Model model) {
        //注意：以后模板会有很多，需要添加分页
        int pageNum = 1;
        int pageSize = -1;
        List<ClassCardCustomTemplate> templateList = templateService.findAllTemplateBySchoolId(getLoginUser().getSchoolId(), pageNum, pageSize).getList();
        model.addAttribute("templateList", templateList);
        return "/classCard/custom/template";
    }

    /**
     * 选择好模板后跳转创建page界面
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createPageByTemplate")
    public ResultEntity createPageByTemplate(HttpServletRequest request) {
        String templateId = getParamVal(request, "templateId");
        String customName = getParamVal(request, "customName");
        ResultEntity resultEntity = ResultEntity.newErrEntity("选择错误");
        String filePath = "/classcard/custom/templatePageReturn?templateId=" + templateId + "&customName=" + customName;
        if (StringUtils.isNotEmpty(templateId)) {
            resultEntity = ResultEntity.newResultEntity(filePath);
        }
        return resultEntity;
    }

    @RequestMapping(value = "/templatePageReturn")
    public String pageReturn(HttpServletRequest request, Model model) {
        String templateId = getParamVal(request, "templateId");
        String customName = getParamVal(request, "customName");
        if (StringUtils.isEmpty(templateId)) {
            //防止templateId为空出现空指针异常
            return "/classCard/custom/index";
        }
        ClassCardCustomTemplate template = templateService.findOneById(templateId);
        model.addAttribute("pageName", customName);
        model.addAttribute("templateType", template.getType());
        model.addAttribute("templateId", templateId);
        model.addAttribute("templateFilePath", template.getFilePath());
        return "/classCard/custom/template/pageEditor";
    }

    @RequestMapping(value = "/richEditor")
    public String richEditor(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");
        model.addAttribute("name", name);
        return "/classCard/custom/template/richEditor";
    }

    /**
     * 修改已经保存的数据，数据回填
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit")
    public String editCustom(HttpServletRequest request, Model model) {
        String pageId = getParamVal(request, "pageId");
        String option = getParamVal(request, "option");
        ClassCardCustomPageView customPage = pageService.findViewOneById(pageId);
        ClassCardCustomTemplate customTemplate = templateService.findOneById(customPage.getTemplateId());
        //没有对查询出来的template进行判断，是否为空，若为空跳转模板页面会出现找不到模板页的错误。
        List<ClassCardCustomContentRef> contentRefs = contentRefService.findContentByPageId(pageId);
        if (contentRefs != null || contentRefs.size() != 0) {
            model.addAttribute("pageContent", contentRefs.get(0).getValue());
        }

        //为什么不返回customPage对象(~-v~-),无关紧要懒得改了。
        model.addAttribute("templateId", customPage.getTemplateId());
        model.addAttribute("pageId", customPage.getId());
        model.addAttribute("templateType", customTemplate.getType());
        model.addAttribute("pageName", customPage.getName());
        model.addAttribute("loopTime", customPage.getStartTimeView() + "---" + customPage.getEndTimeView());
        model.addAttribute("loopMark", customPage.getLoopMark());
        model.addAttribute("loopDate", customPage.getLoopDate());
        model.addAttribute("option", option);
        model.addAttribute("templateFilePath", customTemplate.getFilePath());
        return "/classCard/custom/template/pageEditor";
    }

    /**
     * 保存自定义界面
     *
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultEntity saveCustom(HttpServletRequest request) {
        ResultEntity resultEntity = ResultEntity.newErrEntity("保存失败");
        String option = getParamVal(request, "option");
        if ("disabled".equals(option)) {
            return ResultEntity.newErrEntity("已发布，不可编辑");
        }
        String pageName = getParamVal(request, "pageName");
        String templateId = getParamVal(request, "templateId");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (subject.isAuthenticated()) {
            if (!subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN) && !subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN) && !subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                return ResultEntity.newErrEntity("当前用户权限不足");
            }
        }
        //对参数需要做一些判断
        String names = getParamVal(request, "names");
        String contents = getParamVal(request, "contents");
        if (names.split(",", -1).length != contents.split("##@@", -1).length) {
            return ResultEntity.newErrEntity("内容与模板不匹配，保存失败");
        }
        ClassCardCustomPage customPage = new ClassCardCustomPage();
        customPage.setName(pageName);
        customPage.setTemplateId(templateId);
        customPage.setSchoolId(user.getSchoolId());

        String pageId = getParamVal(request, "pageId");
        int resTotal = 0;
        if (StringUtils.isEmpty(pageId)) {
            //insert
            pageId = PrimaryKey.get();
            customPage.setId(pageId);
            customPage.setCreateBy(user.getId());
            customPage.setCreateDate(System.currentTimeMillis());
            customPage.setUpdateDate(System.currentTimeMillis());
            customPage.setUpdateBy(user.getId());
            resTotal += pageService.insertPage(customPage);
            resTotal += contentRefService.insertContent(pageId, names, contents);
        } else {
            //update
            customPage.setId(pageId);
            customPage.setUpdateBy(user.getId());
            customPage.setUpdateDate(System.currentTimeMillis());
            resTotal += pageService.updatePage(customPage);
            resTotal += contentRefService.updateContent(pageId, names, contents);
        }
        if (resTotal != 0) {
            resultEntity = ResultEntity.newResultEntity("保存成功");
        }
        return resultEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/multidelete")
    public ResultEntity deleteCustom(HttpServletRequest request) {
        String customPageIds = getParamVal(request, "pageId");

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (subject.isAuthenticated()) {
            if (!subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN) && !subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN) && !subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                return ResultEntity.newErrEntity("当前用户权限不足");
            }
        }
        ResultEntity resultEntity;
        try {
            resultEntity = pageService.deletePage(customPageIds);
        } catch (RuntimeException e) {
            e.printStackTrace();
            resultEntity = ResultEntity.newErrEntity("包含已发布的页面不能删除");
        }
        return resultEntity;
    }


    @RequestMapping(value = "/publishPage")
    public String publishPage(HttpServletRequest request, Model model) {
        String pageId = getParamVal(request, "pageId");
        String option = getParamVal(request, "option");
        ClassCardCustomPageView customPageView = pageService.findViewOneById(pageId);
        String checkedIds = customRefService.findCheckIds(pageId, -1);
        ClassCardCustomTemplate template = templateService.findOneById(customPageView.getTemplateId());
        model.addAttribute("templateType", template.getType());
        model.addAttribute("customPage", customPageView);
        model.addAttribute("option", option);
        model.addAttribute("checkedIds", checkedIds);
        return "classCard/custom/publish";
    }


    @ResponseBody
    @Transactional
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResultEntity publish(HttpServletRequest request) {
        ResultEntity resultEntity;
        String pageId = getParamVal(request, "pageId");
        String startTime = getParamVal(request, "startTime");
        String endTime = getParamVal(request, "endTime");
        String loopMark = getParamVal(request, "loopMark");
        String loopDate = getParamVal(request, "loopDate");
        String classCardList = getParamVal(request, "classCardList");
        String intervalTime = getParamVal(request, "intervalTime");

        String sfm = "HH:mm";
        Long releaseStartTime, releaseEndTime;
        try {
            releaseStartTime = DateUtils.stringToTimestamp(startTime, sfm);
            releaseEndTime = DateUtils.stringToTimestamp(endTime, sfm);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("发布时间格式错误");
        }
        //32为一个设备的uuid的长度
        if (StringUtils.isEmpty(classCardList) || classCardList.length() < 32) {
            return ResultEntity.newErrEntity("未选择发布设备");
        }
        if ("W".equals(loopMark) || "M".equals(loopMark)) {
            if (StringUtils.isEmpty(loopDate)) {
                return ResultEntity.newErrEntity("未选择循环时间");
            }
        }

        ClassCardCustomPage customPage = new ClassCardCustomPage();
        customPage.setId(pageId);
        customPage.setStartTime(releaseStartTime);
        customPage.setEndTime(releaseEndTime);
        customPage.setLoopMark(loopMark);
        customPage.setLoopDate(loopDate);
        customPage.setUpdateDate(System.currentTimeMillis());
        ClassCardCustomTemplate template = templateService.findOneById(pageService.findOneById(pageId).getTemplateId());
        Integer int_intervalTime = 0;
        if (template != null && "lbt".equals(template.getType())) {
            //页面填写了间隔时间
            if (!"".equals(intervalTime)) {
                if (Integer.parseInt(intervalTime) <= 0) {
                    return ResultEntity.newErrEntity("轮播图播放间隔有误");
                }
                int_intervalTime = Integer.parseInt(intervalTime);
            }

            if (int_intervalTime == null || int_intervalTime <= 0) {
                int_intervalTime = 15;
            }
        }
        customPage.setIntervalTime(int_intervalTime);
        //参数classcardList,LoopMark,Loopdate，startTime,endTime进行发布设备时间段是否重复的判断
        Boolean verifyFlag = pageService.verifyReleaseDate(classCardList, loopMark, loopDate, releaseStartTime, releaseEndTime);
        int count = customRefService.updatePageRelease(classCardList, pageId);
        if (verifyFlag) {
            if (count != 0) {
                //修改page的status状态，0未发布，1已发布
                customPage.setStatus(1);
                resultEntity = ResultEntity.newResultEntity("发布成功");
                //添加班牌设备推送
                try {
                    ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
                    CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
                    //多个设备循环依次推送
                    String[] classcards = classCardList.split(",");
                    ClassCardCustomContentRef pageContent = contentRefService.findContentByPageId(pageId).get(0);

                    String content = pageContent.getValue();
                    if (StringUtils.isNotBlank(content) && "lbt".equals(template.getType())) {
                        //轮播图内容增加调节高度比代码
                        content = addCode(pageContent.getValue());
                        //间隔时间
                        content = content.replace("autoplay: 15000", "autoplay: " + int_intervalTime * 1000);
                    }
                    String serverName = request.getServerName();
                    int serverPort = request.getServerPort();
                    String htmlUrl = "http://" + serverName + ":" + serverPort + "/platform/file/downloadzip?htmlPath=" + customToZip(content, String.valueOf(System.currentTimeMillis()));

                    if (pageContent != null) {
                        for (String classcardId : classcards) {
                            //获取准备推送的设备，获取mac地址
                            ClassCard classCard = classCardService.findClassCardByClassCardId(classcardId);
                            if (classCard == null) {
                                continue;
                            } else {
                                String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;
                                //用map保存需要推送的数据
                                Map<String, Object> customPageMap = new HashMap<>();
                                customPageMap.put("command", ClassCardCommand.CUSTOM_PUBLISH);
                                customPageMap.put("name", customPage.getName());
                                customPageMap.put("startTime", customPage.getStartTime());
                                customPageMap.put("endTime", customPage.getEndTime());
                                customPageMap.put("loopMark", customPage.getLoopMark());
                                customPageMap.put("loopDate", customPage.getLoopDate());
                                //用页面的id作为版本的标识，如果是一个页面不同时间段发布在同一个设备发布会出现问题。问题出现在取消发布的时候不能唯一标识。。
                                customPageMap.put("versionId", customPage.getId());
                                customPageMap.put("htmlUrl", htmlUrl);
                                //customPageMap.put("content", content);
                                customPageMap.put("systemTime", System.currentTimeMillis());
                                List<Map<String, Object>> customPageList = new LinkedList<>();
                                customPageList.add(customPageMap);
                                //管道通，直接推送
                                if (instance.channelStatus(macFormate)) {
                                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                                    instance.sendMessage(macFormate, new Gson().toJson(customPageList));
                                    System.out.println("===============Data sent successfully=============" + new Gson().toJson(customPageList));
                                    System.out.println("mac:" + macFormate + "-----zidingyi----：：：：：：" + content);
                                } else {
                                    //推送失败，放入缓冲
                                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when publish custom mac:" + macFormate);
                                    Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH);
                                    if (obj != null) {
                                        customPageList = (List<Map<String, Object>>) obj;
                                        customPageList.add(customPageMap);
                                    }
                                    cacheService.addCache(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH, customPageList);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                resultEntity = ResultEntity.newErrEntity("发布设备或者页面选择错误");
            }
        } else {
            resultEntity = ResultEntity.newErrEntity("发布设备时间段重叠");
        }
        pageService.updatePage(customPage);
        return resultEntity;
    }
    /*@ResponseBody
    @Transactional
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public ResultEntity publish(HttpServletRequest request) {
        ResultEntity resultEntity;
        String pageId = getParamVal(request, "pageId");
        String startTime = getParamVal(request, "startTime");
        String endTime = getParamVal(request, "endTime");
        String loopMark = getParamVal(request, "loopMark");
        String loopDate = getParamVal(request, "loopDate");
        String classCardList = getParamVal(request, "classCardList");
        String intervalTime = getParamVal(request, "intervalTime");

        String sfm = "HH:mm";
        Long releaseStartTime, releaseEndTime;
        try {
            releaseStartTime = DateUtils.stringToTimestamp(startTime, sfm);
            releaseEndTime = DateUtils.stringToTimestamp(endTime, sfm);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("发布时间格式错误");
        }
        //32为一个设备的uuid的长度
        if (StringUtils.isEmpty(classCardList) || classCardList.length() < 32) {
            return ResultEntity.newErrEntity("未选择发布设备");
        }
        if ("W".equals(loopMark) || "M".equals(loopMark)) {
            if (StringUtils.isEmpty(loopDate)) {
                return ResultEntity.newErrEntity("未选择循环时间");
            }
        }

        ClassCardCustomPage customPage = new ClassCardCustomPage();
        customPage.setId(pageId);
        customPage.setStartTime(releaseStartTime);
        customPage.setEndTime(releaseEndTime);
        customPage.setLoopMark(loopMark);
        customPage.setLoopDate(loopDate);
        ClassCardCustomTemplate template = templateService.findOneById(pageService.findOneById(pageId).getTemplateId());
        Integer int_intervalTime=0;
        if (template != null && "lbt".equals(template.getType())) {
            //页面填写了间隔时间
            if(!"".equals(intervalTime)){
                if (Integer.parseInt(intervalTime) <= 0) {
                    return ResultEntity.newErrEntity("轮播图播放间隔有误");
                }
                int_intervalTime=  Integer.parseInt(intervalTime);
            }

            if (int_intervalTime == null || int_intervalTime <= 0) {
                int_intervalTime = 15;
            }
        }
        customPage.setIntervalTime(int_intervalTime);
        //参数classcardList,LoopMark,Loopdate，startTime,endTime进行发布设备时间段是否重复的判断
        Boolean verifyFlag = pageService.verifyReleaseDate(classCardList, loopMark, loopDate, releaseStartTime, releaseEndTime);
        int count = customRefService.updatePageRelease(classCardList, pageId);
        if (verifyFlag) {
            if (count != 0) {
                //修改page的status状态，0未发布，1已发布
                customPage.setStatus(1);
                resultEntity = ResultEntity.newResultEntity("发布成功");
                //添加班牌设备推送
                try {
                    ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
                    CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
                    //多个设备循环依次推送
                    String[] classcards = classCardList.split(",");
                    ClassCardCustomContentRef pageContent = contentRefService.findContentByPageId(pageId).get(0);
                    if (pageContent != null) {
                        for (String classcardId : classcards) {
                            //获取准备推送的设备，获取mac地址
                            ClassCard classCard = classCardService.findClassCardByClassCardId(classcardId);
                            if (classCard == null) {
                                continue;
                            } else {
                                String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;
                                //用map保存需要推送的数据
                                Map<String, Object> customPageMap = new HashMap<>();
                                customPageMap.put("command", ClassCardCommand.CUSTOM_PUBLISH);
                                customPageMap.put("name", customPage.getName());
                                customPageMap.put("startTime", customPage.getStartTime());
                                customPageMap.put("endTime", customPage.getEndTime());
                                customPageMap.put("loopMark", customPage.getLoopMark());
                                customPageMap.put("loopDate", customPage.getLoopDate());
                                //用页面的id作为版本的标识，如果是一个页面不同时间段发布在同一个设备发布会出现问题。问题出现在取消发布的时候不能唯一标识。。
                                customPageMap.put("versionId", customPage.getId());

                                String content = pageContent.getValue();
                                if (StringUtils.isNotBlank(content) && "lbt".equals(template.getType())) {
                                    //轮播图内容增加调节高度比代码
                                    content = addCode(pageContent.getValue());
                                    //间隔时间
                                    content = content.replace("autoplay: 15000", "autoplay: " + int_intervalTime * 1000);
                                }

                                customPageMap.put("content", content);
                                customPageMap.put("systemTime", System.currentTimeMillis());
                                List<Map<String, Object>> customPageList = new LinkedList<>();
                                customPageList.add(customPageMap);
                                //管道通，直接推送
                                if (instance.channelStatus(macFormate)) {
                                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                                    instance.sendMessage(macFormate, new Gson().toJson(customPageList));
                                    System.out.println("===============Data sent successfully=============" + new Gson().toJson(customPageList));
                                    System.out.println("mac:" + macFormate + "-----zidingyi----：：：：：：" + content);
                                } else {
                                    //推送失败，放入缓冲
                                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when publish custom mac:" + macFormate);
                                    Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH);
                                    if (obj != null) {
                                        customPageList = (List<Map<String, Object>>) obj;
                                        customPageList.add(customPageMap);
                                    }
                                    cacheService.addCache(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH, customPageList);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                resultEntity = ResultEntity.newErrEntity("发布设备或者页面选择错误");
            }
        } else {
            resultEntity = ResultEntity.newErrEntity("发布设备时间段重叠");
        }
        pageService.updatePage(customPage);
        return resultEntity;
    }*/

    @ResponseBody
    @Transactional
    @RequestMapping(value = "/unpublish")
    public ResultEntity unpublish(HttpServletRequest request) {
        ResultEntity resultEntity = ResultEntity.newErrEntity("取消发布失败");
        int count = 0;
        String pageId = getParamVal(request, "pageId");
        String classCardList = getParamVal(request, "classcardId");
        if (classCardList.isEmpty()) {
            classCardList = customRefService.findCheckIds(pageId, 0);
            //修改page的状态
            ClassCardCustomPage customPage = new ClassCardCustomPage();
            customPage.setId(pageId);
            customPage.setStatus(0);
            customPage.setUpdateDate(System.currentTimeMillis());
            customPage.setUpdateBy(getLoginUser().getId());
            count += pageService.updatePage(customPage);
        }
        //将已发布关联设备记录标记del_flag标记为1,没有直接删除方便下次发布回填
        count += customRefService.setDelFlagById(pageId, classCardList);
        //count += customRefService.deleteCustomRefById(pageId);
        if (count >= 1) {
            resultEntity = ResultEntity.newResultEntity("取消发布成功");
            //添加班牌设备推送
            try {
                ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
                CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
                //多个设备循环依次推送
                String[] classcardIds = classCardList.split(",");
                for (String classcardId : classcardIds) {
                    ClassCard classCard = classCardService.findClassCardByClassCardId(classcardId);
                    if (classCard == null) {
                        continue;
                    }
                    String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;
                    Map<String, Object> customPageMap = new HashMap<>();
                    customPageMap.put("command", ClassCardCommand.CUSTOM_UNPUBLISH);
                    customPageMap.put("versionId", pageId);
                    customPageMap.put("systemTime", System.currentTimeMillis());
                    List<Map<String, Object>> customPageList = new LinkedList<>();
                    customPageList.add(customPageMap);
                    if (instance.channelStatus(macFormate)) {
                        System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                        instance.sendMessage(macFormate, new Gson().toJson(customPageList));
                        System.out.println("===============Data sent successfully=============" + new Gson().toJson(customPageList));
                    } else {
                        System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when unpublish custom mac:" + macFormate);
                        Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH);
                        if (obj != null) {
                            customPageList = (List<Map<String, Object>>) obj;
                            boolean flag = true;
                            //循环判断取消发布的pageId是否在已发布的缓冲中存在。并且是待发布的command
                            for (Map<String, Object> map : customPageList) {
                                if (pageId.equals(map.get("versionId"))) {
                                    if (ClassCardCommand.CUSTOM_PUBLISH.equals(map.get("command"))) {
                                        customPageList.remove(map);
                                        flag = false;
                                        break;
                                    }
                                }
                            }
                            if (flag) {
                                customPageList.add(customPageMap);
                            }
                        }
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.CUSTOM_PUBLISH, customPageList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultEntity;
    }

    @RequestMapping(value = "/template/index")
    public String templateIndex(HttpServletRequest request, Model model) {
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        PageInfo<ClassCardCustomTemplate> pageInfo = new PageInfo<>();
        if (subject.isAuthenticated()) {
            if (subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)) {
                pageService.findAllPageBySchoolId(user.getSchoolId(), pageNum, pageSize);
                pageInfo = templateService.findAllTemplateBySchoolId(user.getSchoolId(), pageNum, pageSize);
            } else {
                pageInfo = null;
            }
        }
        model.addAttribute("pageInfo", pageInfo);
        return "/classCard/custom/template/index";
    }

    /**
     * 编辑创建的自定义界面进行预览
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/preview")
    public String preview(HttpServletRequest request, Model model) {
        String pageId = request.getParameter("pageId");
        String templateType = getParamVal(request, "templateType");
        model.addAttribute("templateType", templateType);
        return "/classCard/custom/template/preview";
    }

    @RequestMapping(value = "/managerImg")
    public String managerImg(HttpServletRequest request) {
        return "/classCard/custom/template/managerImgLBT";
    }

    /**
     * 选择自定义界面的背景图
     */
    @RequestMapping(value = "/chooseBG")
    public String chooseBG(HttpServletRequest request, Model model) {
        //根据登陆人的学校查询对应的背景图
        String schoolId = getLoginUser().getSchoolId();
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);
        PageInfo<ClassSpacePicture> spacePicturePageInfo = classSpacePictureService.findPicByClassCardIdAndPidAndSchoolId("", "bgpic", schoolId, pageNum, pageSize);
        List<ClassSpacePicture> list = spacePicturePageInfo.getList();
        int serverPort = request.getServerPort();
        String serverName = request.getServerName();
        list.forEach(item -> {
            if (item != null && StringUtils.isNotBlank(item.getPicUrl())) {
                item.setPicUrl("http://" + serverName + ":" + serverPort + "/platform/file/pic/show?picPath=" + item.getPicUrl());
            }
        });
        model.addAttribute("bgImageList", list);
        return "/classCard/custom/template/chooseBGImage";
    }

    @RequestMapping(value = "/bgImage/index")
    public String bgImageIndex(HttpServletRequest request, Model model) {
        String schoolId = getLoginUser().getSchoolId();
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        PageInfo<ClassSpacePicture> spacePicturePageInfo = classSpacePictureService.findPicByClassCardIdAndPidAndSchoolId("", "bgpic", schoolId, pageNum, pageSize);
        model.addAttribute("bgImageList", spacePicturePageInfo.getList());
        return "classCard/custom/bgImage";
    }

    @RequestMapping(value = "/oneCustomInfo")
    public String oneCustomInfo(HttpServletRequest request, Model model) {
        String classcardId = getParamVal(request, "id");
        List<ClassCardCustomPageView> customPageViews = pageService.findCustomPageListByIds(customRefService.findIdListByClasscardId(classcardId));
        model.addAttribute("customPageViews", customPageViews);
        model.addAttribute("classcardId", classcardId);
        return "classCard/editCustom";
    }

    @RequestMapping(value = "/findPublishClasscard")
    public String findPublishClasscard(HttpServletRequest request, Model model) {
        String pageId = request.getParameter("pageId");
        List<String> classcardIds = customRefService.findPublishClasscardByPageId(pageId);
        List<ClassCard> publishClassCards = new ArrayList<>();

        List<ClassCard> cards = classCardService.findClassCardbyIds(classcardIds);
        if(cards!=null && cards.size()>0){
            publishClassCards=cards;
        }

        model.addAttribute("publishClasscards", publishClassCards);
        return "classCard/custom/publishClasscard";
    }

    /**
     * 复制自定义
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/copy")
    public ResultEntity copy(HttpServletRequest request) {
        String customId = getParamVal(request, "customId");
        ClassCardCustomPage customPage = pageService.findOneById(customId);
        if (customPage == null) {
            return ResultEntity.newErrEntity("复制失败");
        }
        ClassCardCustomPage copyCustom = new ClassCardCustomPage();

        if (StringUtils.isNotBlank(customPage.getName())) {
            if (customPage.getName().contains("(复制)")) {
                copyCustom.setName(customPage.getName());
            } else {
                copyCustom.setName(customPage.getName() + "(复制)");
            }
        } else {
            copyCustom.setName("");
        }

        String copyCustomId = PrimaryKey.get();
        copyCustom.setId(copyCustomId);
        copyCustom.setStartTime(customPage.getStartTime());
        copyCustom.setEndTime(customPage.getEndTime());
        copyCustom.setTemplateId(customPage.getTemplateId());
        copyCustom.setLoopMark(customPage.getLoopMark());
        copyCustom.setLoopDate(customPage.getLoopDate());
        copyCustom.setCreateBy(getLoginUser().getId());
        copyCustom.setCreateDate(System.currentTimeMillis());
        copyCustom.setSchoolId(customPage.getSchoolId());
        copyCustom.setIntervalTime(customPage.getIntervalTime());
        copyCustom.setUpdateDate(System.currentTimeMillis());

        try {
            pageService.insertPage(copyCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<ClassCardCustomContentRef> contentRefs = contentRefService.findContentByPageId(customId);
        ClassCardCustomContentRef ref = null;
        if (contentRefs != null && contentRefs.size() > 0) {
            ref = contentRefs.get(0);
        }
        if (ref != null) {
           /* ClassCardCustomContentRef copyRef =new ClassCardCustomContentRef();
            copyRef.setId(PrimaryKey.get());
            copyRef.setName(ref.getName());
            copyRef.setPageId(copyCustomId);
            copyRef.setValue(ref.getValue());*/
            try {
                contentRefService.insertContent(copyCustomId, ref.getName(), ref.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return ResultEntity.newResultEntity();
    }

    public String addCode(String contentHtml) {
        StringBuilder stringBuilder = new StringBuilder();
        int indexOf = contentHtml.indexOf("addsomething;");
        stringBuilder.append(contentHtml.substring(0, indexOf + 13));
        stringBuilder.append("$('#bgImage').height('100%');");
        stringBuilder.append(contentHtml.substring(indexOf + 13, contentHtml.length()));
        return stringBuilder.toString();
    }

    /**
     * 将自定义中html存入文件并压缩zip
     *
     * @param content
     * @return 下载zip文件地址
     */
    public String customToZip(String content, String name) {
        String vfsRootPath = VFSUtil.getVFSRootPath();
        ///opt/platform/vfsroot/classcard/customPage
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String yearMouth = simpleDateFormat.format(new Date());
        String htmlPackagePath = vfsRootPath + "classcard/customPage/html/" + yearMouth;

        File htmlPackage = new File(htmlPackagePath);
        if (!htmlPackage.exists()) {
            htmlPackage.mkdirs();
        }

        //自定义html的文件路径
        String htmlPath = htmlPackage + "/" + name + ".html";
        File html = new File(htmlPath);
        if (!html.exists()) {
            try {
                html.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //自定义转成字节数组
        byte bytes[] = new byte[1024 * 1024];
        try {
            bytes = content.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //将html代码写入文件
        try (FileOutputStream fos = new FileOutputStream(html);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        ) {
            osw.write(content);
            osw.flush();
            //fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlPath;
    }
}
