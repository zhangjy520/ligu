package cn.gukeer.classcard.controller;

import cn.gukeer.classcard.modelView.ClassCardNotifyView;
import cn.gukeer.classcard.modelView.ClassCardView;
import cn.gukeer.classcard.persistence.entity.ClassCard;
import cn.gukeer.classcard.persistence.entity.ClassCardNotify;
import cn.gukeer.classcard.persistence.entity.ClassCardNotifyRef;
import cn.gukeer.classcard.service.*;
import cn.gukeer.classcard.util.ClassCardCommand;
import cn.gukeer.common.controller.BasicController;
import cn.gukeer.common.entity.ResultEntity;
import cn.gukeer.common.utils.PrimaryKey;
import cn.gukeer.common.utils.PropertiesUtil;
import cn.gukeer.platform.common.UserRoleType;
import cn.gukeer.platform.persistence.entity.TeacherClass;
import cn.gukeer.platform.persistence.entity.User;
import cn.gukeer.platform.service.*;
import cn.gukeer.platform.service.impl.CacheServiceImpl;
import cn.gukeer.sync.netty.classCardAttendance.ClassCardCustomizeServer;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wulianedu.netty.server.ServerInstance;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alpha on 18-1-16.
 */
@Controller
@RequestMapping(value = "/classcard")
public class ClassCardNotifyController extends BasicController {


    @Autowired
    ClassCardService classCardService;

    @Autowired
    TeachTaskService teachTaskService;

    @Autowired
    ClassCardNotifyService classCardNotifyService;

    @Autowired
    ClassCardNotifyRefService classCardNotifyRefService;

    @Autowired
    CacheManager cacheManager;

    Properties properties = PropertiesUtil.getProperties("api.properties");
    Integer netty_classcard_customize_port = Integer.parseInt((String) properties.get("netty_classcard_customize_port"));

    /**
     * 通知公告首页
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/notify/index")
    public String classCardNotifyIndex(HttpServletRequest request, Model model) {

        String title = getParamVal(request, "title");
        try {
            title = java.net.URLDecoder.decode(title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String type = getParamVal(request, "type");
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        PageInfo<ClassCardNotifyView> pageInfo = new PageInfo<>();
        if (subject.isAuthenticated()) {
            //管理员
            if (subject.hasRole(UserRoleType.ROLE_CLASSCARDADMIN) || subject.hasRole(UserRoleType.ROLE_SCHOOLADMIN)) {
                pageInfo = classCardNotifyService.findAllNotify(title, "".equals(type) ? -1 : Integer.parseInt(type), user.getSchoolId(), pageNum, pageSize);
            } else if (subject.hasRole(UserRoleType.ROLE_HEADTEACHER)) {
                String teacherId = user.getRefId();
                //老师的班级(可能多个)
                List<TeacherClass> teacherClasses = teachTaskService.findAllByTeacherId(teacherId);
                List<String> classIds = new ArrayList<>();
                if (teacherClasses != null && teacherClasses.size() > 0) {
                    for (TeacherClass tc : teacherClasses) {
                        classIds.add(tc.getClassId());
                    }
                }
                //获得班级对应的班牌
                List<ClassCard> classCardList = classCardService.findClassCardByClassIds(classIds);
                //班牌id的list
                List<String> classCardIds = new ArrayList<>();
                if (classCardList != null && classCardList.size() > 0) {
                    for (ClassCard cc : classCardList) {
                        classCardIds.add(cc.getId());
                    }
                }
                //班牌和通知公告中间表
                List<ClassCardNotifyRef> allByClassCardIds = classCardNotifyRefService.findAllByClassCardIds(classCardIds);
                List<String> notifyIds = new ArrayList<>();
                if (allByClassCardIds != null && allByClassCardIds.size() > 0) {
                    for (ClassCardNotifyRef cr : allByClassCardIds) {
                        notifyIds.add(cr.getClassCardNotifyId());
                    }
                }
                pageInfo = classCardNotifyService.findById(title, notifyIds, pageNum, pageSize);
            }
        }
        List<ClassCardNotifyView> resultList = classCardNotifyService.transforNotifyView(pageInfo.getList());
        pageInfo.setList(resultList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("title", title);
        model.addAttribute("type", type);

        return "classCard/notify/index";
    }

    @RequestMapping(value = "/notify/edit")
    public String notifyEdit(HttpServletRequest request, Model model) {
        String disabled = getParamVal(request, "disabled");
        String id = getParamVal(request, "id");
        if (StringUtils.isNotBlank(id)) {
            ClassCardNotify classCardNotify = classCardNotifyService.findById(id);
            model.addAttribute("classCardNotify", classCardNotify);
            List<ClassCardNotifyRef> classCardNotifyRefs = classCardNotifyRefService.findAllByNotifyId(id);
            String checkedIds = "";
            List<String> idsList = new ArrayList<>();
            if (classCardNotifyRefs != null && classCardNotifyRefs.size() > 0) {
                for (ClassCardNotifyRef ref : classCardNotifyRefs) {
                    checkedIds += ref.getClassCardId() + ",";
                    idsList.add(ref.getClassCardId());
                }
            }
            List<ClassCard> classCards = classCardService.findClassCardbyIds(idsList);
            StringBuilder sb = new StringBuilder();
            classCards.forEach(classCard -> {
                sb.append(classCard.getEquipmentName());
                sb.append(",");
            });
            model.addAttribute("checkedName", sb.toString());
            model.addAttribute("checkedIds", checkedIds);
            model.addAttribute("notifyId", id);
            model.addAttribute("option", "edit");
        } else {
            model.addAttribute("notifyId", "");
            model.addAttribute("option", "add");
        }
        model.addAttribute("disabled", disabled);
        return "classCard/notify/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/notify/save")
    public ResultEntity saveClassCardNotify(HttpServletRequest request, Model model) {
        String title = getParamVal(request, "title");
        String type = getParamVal(request, "type");
        String content = getParamVal(request, "content");
        String option = getParamVal(request, "option");
        String notifyId = getParamVal(request, "notifyId");
        //选中的设备
        String checkedIds = getParamVal(request, "checkedIds");
        if (StringUtils.isBlank(checkedIds)) {
            return ResultEntity.newErrEntity("设备不能为空");
        }

        ResultEntity resultEntity = ResultEntity.newErrEntity();
        if ("".equals(title) || "".equals(type) || "".equals(content)) {
            return resultEntity;
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        ClassCardNotifyView classCardNotify = new ClassCardNotifyView();
        classCardNotify.setTitle(title);
        classCardNotify.setType(Integer.parseInt(type));
        classCardNotify.setContent(content);

        int count = 0;
        String refId = PrimaryKey.get();
        //新增的公告
        if (StringUtils.isBlank(notifyId)) {
            classCardNotify.setCreateBy(user.getId());
            classCardNotify.setCreateDate(System.currentTimeMillis());
            classCardNotify.setId(refId);
            count = classCardNotifyService.insertClassCardNotify(classCardNotify);
        }
        //编辑公告
        else {
            classCardNotify.setId(notifyId);
            classCardNotify.setUpdateDate(System.currentTimeMillis());
            classCardNotify.setUpdateBy(user.getId());
            count = classCardNotifyService.updateClassCardNotify(classCardNotify);
            //推送删除改公告的指令给相应设备
            List<ClassCardNotifyRef> notifyRefs = classCardNotifyRefService.findAllByNotifyId(notifyId);
            List<String> refcardIds = new ArrayList<>();
            notifyRefs.forEach(ref -> {
                refcardIds.add(ref.getClassCardId());
            });
            List<String> ckList = Arrays.asList(checkedIds.split(","));
            //获得删除的设备id
            refcardIds.removeAll(ckList);
            //推送删除通知公告
            ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
            CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");
            refcardIds.forEach(cardId -> {
                //获取准备推送的设备，获取mac地址
                ClassCard classCard = classCardService.findClassCardByClassCardId(cardId);
                if (classCard != null) {
                    String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;
                    //用map保存需要推送的数据
                    Map<String, Object> notifyMap = new HashMap<>();
                    notifyMap.put("command", ClassCardCommand.NOTIFY_UNPUBLISH);
                    notifyMap.put("id", notifyId);
                    List<Map<String, Object>> notifyList = new LinkedList<>();
                    notifyList.add(notifyMap);
                    //管道通，直接推送
                    if (instance.channelStatus(macFormate)) {
                        System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                        instance.sendMessage(macFormate, new Gson().toJson(notifyList));
                        System.out.println("===============Data sent successfully=============" + new Gson().toJson(notifyList));
                    } else {
                        //推送失败，放入缓冲
                        System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when delete notify mac:" + macFormate);
                        Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.NOTIFY_UNPUBLISH);
                        if (obj != null) {
                            notifyList = (List<Map<String, Object>>) obj;
                            notifyList.add(notifyMap);
                        }
                        cacheService.addCache(macFormate + "_" + ClassCardCommand.NOTIFY_UNPUBLISH, notifyList);
                    }
                }
            });
            Object arr[] = refcardIds.toArray();
            StringBuilder delCardIds = new StringBuilder();
            for (Object id : arr) {
                delCardIds.append(id);
                delCardIds.append(",");
            }
            classCardNotifyRefService.deleteClassCardNotifyRef(delCardIds.toString(), notifyId);
        }
        boolean flag = false;
        try {
            flag = classCardNotifyRefService.insertClassCardNotifyRef(checkedIds, classCardNotify.getId(), user.getSchoolId(), user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //推送通知公告
        ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
        CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

        String[] classCardIds = checkedIds.split(",");
        for (String classcardId : classCardIds) {

            //获取准备推送的设备，获取mac地址
            ClassCard classCard = classCardService.findClassCardByClassCardId(classcardId);
            if (classCard == null) {
                continue;
            } else {
                String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;


                //用map保存需要推送的数据
                Map<String, Object> notifyMap = new HashMap<>();
                //新增的公告
                if ("add".equals(option)) {
                    notifyMap.put("command", ClassCardCommand.NOTIFY_PUBLISH);
                }
                //编辑的公告
                if ("edit".equals(option)) {
                    List<ClassCardNotifyRef> refs = classCardNotifyRefService.findRefByCardIdAndNotifyId(classcardId, notifyId);
                    if (refs == null || refs.size() <= 0) {
                        //编辑时新勾选的班牌
                        notifyMap.put("command", ClassCardCommand.NOTIFY_PUBLISH);
                    } else {
                        //编辑时已经勾选的班牌
                        notifyMap.put("command", ClassCardCommand.NOTIFY_MODIFY);
                    }
                }

                ClassCardNotify cardNotify = classCardNotifyService.findById(classCardNotify.getId());
                classCardNotify.setCreateDate(cardNotify.getCreateDate());

                notifyMap.put("id", classCardNotify.getId());
                notifyMap.put("title", classCardNotify.getTitle());
                notifyMap.put("type", classCardNotify.getType());
                notifyMap.put("createDate", classCardNotify.getCreateDate());
                notifyMap.put("content", classCardNotify.getContent());
                classCardNotifyService.transfornotifyDate(classCardNotify);
                notifyMap.put("publishTime", classCardNotify.getPublishTime());

                List<Map<String, Object>> notifyList = new LinkedList<>();
                notifyList.add(notifyMap);
                //管道通，直接推送
                if (instance.channelStatus(macFormate)) {
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                    instance.sendMessage(macFormate, new Gson().toJson(notifyList));
                    System.out.println("===============Data sent successfully=============" + new Gson().toJson(notifyList));
                } else {
                    //推送失败，放入缓冲
                    System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when push notify mac:" + macFormate);
                    Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.NOTIFY_PUBLISH);
                    if (obj != null) {
                        notifyList = (List<Map<String, Object>>) obj;
                        notifyList.add(notifyMap);
                    }
                    cacheService.addCache(macFormate + "_" + ClassCardCommand.NOTIFY_PUBLISH, notifyList);
                }
            }
        }

        if (count != 0 && flag) {
            resultEntity = ResultEntity.newResultEntity();
        }
        return resultEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/notify/multidelete")
    public ResultEntity deleteNotify(HttpServletRequest request, Model model) {
        String notifyId = getParamVal(request, "notifyId");
        ResultEntity resultEntity = ResultEntity.newErrEntity();
        if (!"".equals(notifyId)) {
            int notifyCount = 0;
            String[] notifyIdArr = notifyId.split(",");
            if (notifyIdArr != null && notifyIdArr.length > 0) {
                //推送删除通知公告
                ServerInstance instance = ClassCardCustomizeServer.getInstance_customize();
                CacheServiceImpl cacheService = new CacheServiceImpl(cacheManager, "classcardcommand-cache");

                for (String id : notifyIdArr) {

                    //根据notifyId 查询班牌Id
                    List<String> classcardIdS = new ArrayList<>();
                    List<ClassCardNotifyRef> cardNotifyRefs = classCardNotifyRefService.findAllByNotifyId(id);
                    for (ClassCardNotifyRef ref : cardNotifyRefs) {
                        classcardIdS.add(ref.getClassCardId());
                    }

                    for (String classcardId : classcardIdS) {
                        //获取准备推送的设备，获取mac地址
                        ClassCard classCard = classCardService.findClassCardByClassCardId(classcardId);
                        if (classCard == null) {
                            continue;
                        } else {
                            String macFormate = classCard.getMacId().replace(":", "_").toUpperCase() + "_" + netty_classcard_customize_port;
                            //用map保存需要推送的数据
                            Map<String, Object> notifyMap = new HashMap<>();
                            notifyMap.put("command", ClassCardCommand.NOTIFY_UNPUBLISH);
                            notifyMap.put("id", id);
                            List<Map<String, Object>> notifyList = new LinkedList<>();
                            notifyList.add(notifyMap);
                            //管道通，直接推送
                            if (instance.channelStatus(macFormate)) {
                                System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel connectivity");
                                instance.sendMessage(macFormate, new Gson().toJson(notifyList));
                                System.out.println("===============Data sent successfully=============" + new Gson().toJson(notifyList));
                            } else {
                                //推送失败，放入缓冲
                                System.out.println("===================[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "]==================Channel unconnected when delete notify mac:" + macFormate);
                                Object obj = cacheService.getCacheByKey(macFormate + "_" + ClassCardCommand.NOTIFY_UNPUBLISH);
                                if (obj != null) {
                                    notifyList = (List<Map<String, Object>>) obj;
                                    notifyList.add(notifyMap);
                                }
                                cacheService.addCache(macFormate + "_" + ClassCardCommand.NOTIFY_UNPUBLISH, notifyList);
                            }
                        }
                    }
                }
                try {
                    notifyCount = classCardNotifyService.deleteClassCardNotify(notifyIdArr);
                    classCardNotifyRefService.deleteRefByNotifyId(notifyIdArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (notifyCount == notifyIdArr.length) {
                    resultEntity = ResultEntity.newResultEntity();
                }
            }
        }
        return resultEntity;
    }

    //发布通知选择设备
    @RequestMapping(value = "/chooseclasscard")
    public String chooseClassCard(HttpServletRequest request, Model model) {
        String checkedIds = getParamVal(request, "checkedIds");
        String disabled = getParamVal(request, "disabled");
        String option = getParamVal(request, "option");

        Map<String, Map<String, List<ClassCardView>>> resultMap = classCardService.selectEquipmentForNotify();
        JsonObject returnData = new JsonParser().parse(new Gson().toJson(resultMap)).getAsJsonObject();
        model.addAttribute("returnData", returnData);
        model.addAttribute("checkedIds", checkedIds);
        model.addAttribute("disabled", disabled);
        model.addAttribute("option", option);

        return "classCard/notify/chooseclasscard";
    }

}
