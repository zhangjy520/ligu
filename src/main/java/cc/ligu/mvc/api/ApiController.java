/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.api;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.controller.FileController;
import cc.ligu.mvc.modelView.BaoXianView;
import cc.ligu.mvc.modelView.ScoreView;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.*;
import cc.ligu.mvc.service.impl.ItemServiceImpl;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.gson.Gson;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@RequestMapping(value = "/api")
public class ApiController extends BasicController {

    @Resource
    ItemServiceImpl itemService;
    @Resource
    SourceService sourceService;
    @Resource
    UserService userService;
    @Resource
    PersonService personService;
    @Resource
    QuestionService questionService;
    @Resource
    ICompanyService iCompanyService;
    @Resource
    LoginLogService loginLogService;
    @Resource
    AppConfigService appConfigService;
    @Resource
    CacheService cacheService;
    @Resource
    ProjectReportService projectReportService;

    @ApiIgnore
    @ApiOperation(value = "通过客户端id判断是否需要登录", httpMethod = "POST", notes = "验证是否需要登录,不需要登录返回用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/getUser")
    public ResultEntity checkIfLogin(HttpServletRequest request) {
        String clientId = getParamVal(request, "clientId");
//        Object user = SessionTool.getUserInfoFromSession(request, clientId);
        Object user = cacheService.getCacheByKey(clientId);
        if (null == user) {
            return ResultEntity.newErrEntity("您需要登录，请重新登录");
        } else {
            return ResultEntity.newResultEntity(user);
        }
    }

    @ApiOperation(value = "退出登录", httpMethod = "POST", notes = "退出登录，清除服务端session", position = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/logout")
    public ResultEntity applogOut(HttpServletRequest request) {
        String clientId = getParamVal(request, "clientId");
        try {
//            request.getSession().removeAttribute(clientId);
            UserView userView = (UserView) cacheService.getCacheByKey(clientId);

            cacheService.removeCache(clientId);

            LoginLog loginLog = new LoginLog();
            loginLog.setSysUserId(userView.getId());
            loginLog.setRefPersonId(userView.getRefId());
            loginLog.setLoginStatus(1);//0登录中 1已经退出 2其他
            loginLog.setLogoutDate(System.currentTimeMillis());

            loginLogService.saveLoginLog(loginLog);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("服务器内部异常");
        }
        return ResultEntity.newResultEntity("操作成功");
    }

    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "验证登录账号密码,登录成功返回该用户的个人信息", position = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request) {
        String username = getParamVal(request, "username");
        String password = getParamVal(request, "password");
        String clientId = getParamVal(request, "clientId");
        UserView user = userService.selectUserViewByUsernameAndPassword(username, AESencryptor.encryptCBCPKCS5Padding(password));
        if (null == user) {
            return ResultEntity.newErrEntity("用户名或密码错误");
        } else {
            //SessionTool.setUserInfo2Session(request, clientId, user);//将clientId作为key,
            cacheService.addCache(clientId, user);
            LoginLog loginLog = new LoginLog();
            loginLog.setLoginSource(0);//0 app  1 pc
            loginLog.setLoginId(clientId);
            loginLog.setSysUserId(user.getId());
            loginLog.setRefPersonId(user.getRefId());
            loginLog.setUsername(user.getUsername());
            loginLog.setName(user.getName());
            loginLog.setLoginStatus(0);//0登录中 1已经退出 2其他
            loginLog.setLoginDate(System.currentTimeMillis());

            loginLogService.saveLoginLog(loginLog);

            return ResultEntity.newResultEntity(user);
        }
    }

    @ApiIgnore
    @ApiOperation(value = "未登录返回", httpMethod = "GET", notes = "未登录返回json")
    @RequestMapping("/permissionDeny")
    public ResultEntity unLogin(HttpServletRequest request) {
        return ResultEntity.newErrEntity("您需要登录，请重新登录");
    }


    //--------------------------------------------以下是业务接口 需要登录----------------------
    @ApiOperation(value = "获取资源媒体文件", httpMethod = "POST", notes = "根据分页条件获取媒体资源")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "条数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "sourceType", value = "0全部 1安全生产视频课程 2安全生产培训文档 3安全生产安全守则 4施工工艺视频课程 5施工工艺培训文档 6施工工艺工艺示例"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/source")
    public ResultEntity source(HttpServletRequest request) {
        try {
            int pageSize = getPageSize(request);
            int pageNum = getPageNum(request);
            String sourceType = getParamVal(request, "sourceType");
            int type = StringUtils.isEmpty(sourceType) ? 0 : Integer.valueOf(sourceType);
            Source source = new Source();
            source.setType(type);

            PageInfo<Source> pageInfo = sourceService.listAllSource(pageSize, pageNum, source);
            return ResultEntity.newResultEntity(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("操作失败");
        }
    }


    @ApiOperation(value = "申请添加人员黑名单", httpMethod = "POST", notes = "申请添加人员到黑名单，管理员审核后才入真正被拉黑", position = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "姓名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "num", value = "身份证号码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "拉黑原因", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/add/black", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResultEntity addToBlack(@ApiParam(value = "上传身份证图片", required = true) MultipartFile multipartFile, HttpServletRequest request) {
        try {
            String name = getParamVal(request, "name");
            String num = getParamVal(request, "num");
            String remark = getParamVal(request, "remark");

            if (StringUtil.isEmpty(num) || StringUtil.isEmpty(name)) {
                return ResultEntity.newErrEntity("操作失败，身份证和姓名是必填项！");
            }

            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();
                if (multiFileMap.size() > 0) {
                    List<MultipartFile> fileSet = new LinkedList<>();
                    for (Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()) {
                        fileSet = temp.getValue();
                    }
                    if (fileSet.size() > 0) {
                        multipartFile = fileSet.get(0);
                    }
                }
            }

            Map uploads = (Map) new FileController().uploads(multipartFile, request).getData();

            Person person = new Person();
            person.setName(name);
            person.setIdentityNum(num);
            person.setBlackFlag(1);//[0正常 ,1黑名单待审，2黑名单人员]
            person.setRemark(remark);//申请拉黑原因
            person.setBlackImage(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + uploads.get("fileRequestPath"));

            int size = personService.savePerson(person, getAppLoginUser(request));
            return ResultEntity.newResultEntity("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("操作失败");
        }

    }

    @ApiOperation(value = "查看黑名单列表", httpMethod = "POST", notes = "查询黑名单人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/query/black")
    public ResultEntity queryBlack(HttpServletRequest request) {
        Person person = new Person();
        person.setBlackFlag(2);
        try {
            List<Person> pageInfo = personService.listAllPerson(person);
            return ResultEntity.newResultEntity(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("发生异常");
        }
    }

    @ApiOperation(value = "自定义个人头像", httpMethod = "POST", notes = "根据用户Id,客户端id，设置该用户的头像")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/upload/headpic", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResultEntity uploadHeadPic(@ApiParam(value = "上传头像", required = true) MultipartFile multipartFile,
                                      HttpServletRequest request) {
        try {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();
                if (multiFileMap.size() > 0) {
                    List<MultipartFile> fileSet = new LinkedList<>();
                    for (Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()) {
                        fileSet = temp.getValue();
                    }
                    if (fileSet.size() > 0) {
                        multipartFile = fileSet.get(0);
                    }
                }
            }

            Map uploads = (Map) new FileController().uploads(multipartFile, request).getData();
            User user = userService.selectUserViewByUserId(Integer.valueOf(request.getParameter("userId")));
            user.setPhotoUrl(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + uploads.get("fileRequestPath"));
            UserView userView = getAppLoginUser(request);
            userService.saveUser(user, userView);
            return ResultEntity.newResultEntity("上传成功", user.getPhotoUrl());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("设置异常");
        }
    }


    @ApiOperation(value = "上传用户身份证图片", httpMethod = "POST", notes = "根据人员身份证号码,客户端id，设置该用户的头像")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "idNum", value = "人员身份证号码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/upload/idPic", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResultEntity uploadIdPic(@ApiParam(value = "上传身份证图片", required = true) MultipartFile multipartFile,
                                    HttpServletRequest request) {
        try {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();
                if (multiFileMap.size() > 0) {
                    List<MultipartFile> fileSet = new LinkedList<>();
                    for (Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()) {
                        fileSet = temp.getValue();
                    }
                    if (fileSet.size() > 0) {
                        multipartFile = fileSet.get(0);
                    }
                }
            }

            Map uploads = (Map) new FileController().uploads(multipartFile, request).getData();
            Person person = personService.selectPersonByIdNum(request.getParameter("idNum"));
            person.setIdentityImg(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + uploads.get("fileRequestPath"));
            UserView userView = getAppLoginUser(request);
            personService.savePerson(person, userView);
            return ResultEntity.newResultEntity("上传成功", person.getIdentityImg());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("设置异常");
        }
    }

    @ApiOperation(value = "获取试卷", httpMethod = "POST", notes = "根据用户Id,客户端id，随机生成一套试卷，题目数量调用者提供，试卷类型调用者提供[1:平时练习,2:月份考试]")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "count", value = "题目数量", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "type", value = "试卷类型", required = true),
    })
    @RequestMapping(value = "/getExam")
    public ResultEntity getExam(HttpServletRequest request) {
        try {
            int count = getParamInt(request, "count");
            int type = getParamInt(request, "type");

            List<Question> questionList = questionService.selectRandomQuestionByCount(count);
            UserView userView = getAppLoginUser(request);
            StringBuilder questionIds = new StringBuilder();
            for (Question question : questionList) {
                questionIds.append(question.getId() + ",");
            }
            PersonExamHistoryWithBLOBs record = new PersonExamHistoryWithBLOBs();
            record.setPersonId(userView.getRefId());
            record.setFullScore("100");
            record.setExamTime(String.valueOf(System.currentTimeMillis()));
            record.setExamType(type);
            record.setQuestionIds(questionIds.toString());

            questionService.saveExam(record);
            Map map = new HashMap();
            map.put("exam", record);
            map.put("questionList", questionList);
            return ResultEntity.newResultEntity(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取失败");
        }
    }


    @ApiOperation(value = "根据试卷id获取试卷内容", httpMethod = "POST", notes = "根据客户端id，试卷id获取试卷信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "examId", value = "试卷id", required = true),
    })
    @RequestMapping(value = "/getExamById")
    public ResultEntity getExamById(HttpServletRequest request) {
        try {
            int examId = getParamInt(request, "examId");
            PersonExamHistoryWithBLOBs exam = questionService.getExamById(examId);
            List<Question> questionList = questionService.getQuestionListByIds(exam.getQuestionIds());

            Map map = new HashMap();
            map.put("exam", exam);
            map.put("questionList", questionList);
            return ResultEntity.newResultEntity(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取失败");
        }
    }


    @ApiOperation(value = "提交错题列表(需要将错题提交到错题库)", httpMethod = "POST", notes = "根据客户端id，错题id，正确答案，你的答案的json串来提交错题！格式参见文档")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "jsonStr", value = "错题json[{questionId:123,yourAnswer:A,correctAnswer:D}]", required = true),
    })
    @RequestMapping(value = "/uploadWrongExam")
    public ResultEntity uploadWrongExam(HttpServletRequest request) {
        String json = getParamVal(request, "jsonStr");

        try {
            UserView userView = getAppLoginUser(request);
            questionService.saveWrongExam(json, userView);

            return ResultEntity.newResultEntity("提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("提交失败，请检查参数格式");
        }
    }

    @ApiOperation(value = "提交考试结果(考试的结束，需要将错题，分数提交到错题库)", httpMethod = "POST", notes = "根据客户端id，试卷id，错题集合，得分，录入考试成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "examId", value = "这次考试的试卷id，getExam接口的id字段", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "jsonStr", value = "这次考试的错题json串，格式：[{questionId:123,yourAnswer:A,correctAnswer:D}]", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "score", value = "这次考试的得分，比如你取了50道题，那么每道题2分，错一道题扣两分，你把最终得分比如错了2道，你就给我传个96即可", required = true),
    })
    @RequestMapping(value = "/uploadExamResult")
    public ResultEntity uploadExamResult(HttpServletRequest request) {
        int examId = getParamInt(request, "examId");
        String jsonStr = getParamVal(request, "jsonStr");
        String score = getParamVal(request, "score");

        try {
            UserView userView = getAppLoginUser(request);

            JSONArray array = JSONArray.fromObject(jsonStr);
            List<PersonWrongQuestion> list = JSONArray.toList(array, PersonWrongQuestion.class);// 过时方法
            String wrongIds = "";
            for (PersonWrongQuestion wrongQuestion : list) {
                wrongIds += wrongQuestion.getQuestionId() + ",";
                wrongQuestion.setPersonId(userView.getRefId());
                questionService.saveWrongQuestion(wrongQuestion);//将错题添加到错题库
            }

            PersonExamHistoryWithBLOBs bloBs = new PersonExamHistoryWithBLOBs();
            bloBs.setId(examId);
            bloBs.setWrongIds(wrongIds);
            bloBs.setObtainScore(score);

            questionService.saveExamHistory(bloBs);//保存考试成绩

            return ResultEntity.newResultEntity("提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("提交失败，请检查参数格式");
        }
    }

    @ApiOperation(value = "获取错题列表", httpMethod = "POST", notes = "根据客户端id，获取当前登录用户的错题列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/getAllWrongQuestion")
    public ResultEntity getAllWrongQuestion(HttpServletRequest request) {

        try {
            UserView userView = getAppLoginUser(request);
            List<Question> wrongQuestionList = questionService.wrongQuestionList(userView.getRefId());
            return ResultEntity.newResultEntity(wrongQuestionList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取异常");
        }
    }

    @ApiOperation(value = "根据错题id集合，将错题从错题库移除", httpMethod = "POST", notes = "根据客户端id，questionIds将错题从错题库移除。questionids格式：id1,id2")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "questionIds", value = "错题id格式：id1，id2,多个错题id逗号分开，单个错题提交错题id即可", required = true),
    })
    @RequestMapping(value = "/removeWrongQuestion")
    public ResultEntity removeWrongQuestion(HttpServletRequest request) {
        String questionIds = getParamVal(request, "questionIds");
        UserView user = getAppLoginUser(request);

        if (StringUtil.isEmpty(questionIds)) {
            return ResultEntity.newErrEntity("参数格式错误");
        }
        try {
            questionService.removeWrongQuestion(questionIds, user.getRefId());
            return ResultEntity.newResultEntity("移除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("移除异常");
        }
    }


    @ApiOperation(value = "信息录入", httpMethod = "POST", notes = "根据客户端id，录入人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "personName", value = "人员姓名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "identity", value = "身份证号", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "proUnit", value = "隶属单位", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoNum", value = "保险单号"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoCompany", value = "保险公司/承保公司"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoHowMuch", value = "保险额度"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoTime", value = "保险期限"),
    })
    @RequestMapping(value = "/saveInfo")
    public ResultEntity saveInfo(HttpServletRequest request) throws UnsupportedEncodingException {
//        String personName = new String(getParamVal(request, "personName").getBytes("ISO-8859-1"), "utf-8");
        String personName = getParamVal(request, "personName");
        String identify = getParamVal(request, "identity");
        String proUnit = getParamVal(request, "proUnit");
        String baoNum = getParamVal(request, "baoNum");
        String baoCompany = getParamVal(request, "baoCompany");
        String baoTime = getParamVal(request, "baoTime");
        String baoHowMuch = getParamVal(request, "baoHowMuch");
        System.out.println("这次接受到的数据是" + personName);
        if (StringUtil.isEmpty(identify) || StringUtil.isEmpty(personName)) {
            return ResultEntity.newErrEntity("操作失败，身份证和姓名是必填项！");
        }
        UserView userView = getAppLoginUser(request);
        try {
            Person person = new Person();
            person.setName(personName);
            person.setIdentityNum(identify);
            person.setProfessionalUnit(proUnit);

            BaoXianView baoXianView = new BaoXianView();
            baoXianView.setCompany(baoCompany);
            baoXianView.setOrder_num(baoNum);
            baoXianView.setOrder_time(baoTime);
            baoXianView.setHow_much(baoHowMuch);

            person.setInsurancePurchases(new Gson().toJson(baoXianView));

            person.setType(5);//施工人员
            //施工人员
            person.setRoleName(DicUtil.getValueByKeyAndFlag(5, "roles"));
            person.setRolePermission(DicUtil.getValueByKeyAndFlag(5, "permissions"));

            int res = personService.savePerson(person, userView);
            if (-2 == res) {
                return ResultEntity.newResultEntity("该用户已经录入过，信息已经更新");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newResultEntity("提交成功");
    }


    @ApiOperation(value = "信息查询", httpMethod = "POST", notes = "根据客户端id，身份证号来查询人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "identify", value = "身份证号码", required = true),
    })
    @RequestMapping(value = "/queryPerson")
    public ResultEntity queryPerson(HttpServletRequest request) throws UnsupportedEncodingException {
        String identify = getParamVal(request, "identify");
        try {
            UserView userView = new UserView();
            userView.setIdentityNum(identify);

            List<UserView> res = userService.selectUserViewByUserView(userView);

            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("操作失败");
        }
    }


    @ApiOperation(value = "下拉列表数据获取", httpMethod = "POST", notes = "根据客户端id，下拉字典获取下拉数据集合selectId 0承保公司下拉集合/ 1隶属单位集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "selectId", value = "下拉列表selectId", required = true),
    })
    @RequestMapping(value = "/getSelectList")
    public ResultEntity getSelectList(HttpServletRequest request) throws UnsupportedEncodingException {

        try {
            int selectId = getParamInt(request, "selectId");
            List<String> res = personService.getAllSelect(selectId);
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取失败");
        }

    }


    @ApiOperation(value = "获取当前题库版本号", httpMethod = "POST", notes = "根据客户端id，获取题库版本号")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/getPracticeVersion")
    public ResultEntity getVersion(HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            QuestionVersion version = questionService.selectVersion();
            return ResultEntity.newResultEntity(version.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取题库版本号失败");
        }
    }


    @ApiOperation(value = "分页取所有题目，有序的！", httpMethod = "POST", notes = "根据客户端id，分页参数取题库题目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "条数", required = true),
    })
    @RequestMapping(value = "/getPractice")
    public ResultEntity getPractice(HttpServletRequest request) throws UnsupportedEncodingException {

        try {
            int pageSize = getPageSize(request);
            int pageNum = getPageNum(request);

            PageInfo<Question> res = questionService.listAllQuestion(pageSize, pageNum, new Question());//查询所有的题库集合。
            QuestionVersion version = questionService.selectVersion();

            Map r = new HashMap();
            r.put("version", version.getVersion());
            r.put("list", res.getList());
            r.put("total", res.getTotal());

            return ResultEntity.newResultEntity(r);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取失败");
        }

    }

    @ApiOperation(value = "查询所有保险公司列表", httpMethod = "POST", notes = "根据客户端id，查询所有保险公司列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/getBaoXianCompany")
    public ResultEntity getBaoXianCompany(HttpServletRequest request) throws UnsupportedEncodingException {

        try {
            List<InsuranceCompany> res = iCompanyService.listAllInsuranceCompany();
            return ResultEntity.newResultEntity(res);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取失败");
        }

    }

    @ApiOperation(value = "上传资源文件工艺示例图片到资源库", httpMethod = "POST", notes = "上传工艺示例图片需要的参数是clientId，图片，以及图片描述")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "该图片描述"),
    })
    @RequestMapping(value = "/upload/picExample", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResultEntity uploadPicExample(@ApiParam(value = "上传工艺示例", required = true) MultipartFile multipartFile,
                                         HttpServletRequest request) {
        String url = "";
        try {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiFileMap = multiRequest.getMultiFileMap();
                if (multiFileMap.size() > 0) {
                    List<MultipartFile> fileSet = new LinkedList<>();
                    for (Map.Entry<String, List<MultipartFile>> temp : multiFileMap.entrySet()) {
                        fileSet = temp.getValue();
                    }
                    if (fileSet.size() > 0) {
                        multipartFile = fileSet.get(0);
                    }
                }
            }


            String remark = getParamVal(request, "remark");

            Map uploads = (Map) new FileController().uploads(multipartFile, request).getData();

            url = request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + uploads.get("fileRequestPath");
            UserView userView = getAppLoginUser(request);
            Source source = new Source();
            source.setApplyTime(0);
            source.setType(6);
            source.setName(uploads.get("fileName").toString());
            source.setCreateBy(userView.getId());
            source.setCreateDate(System.currentTimeMillis());
            source.setSuffix(uploads.get("suffix").toString());
            source.setUrl(url);
            source.setRemark(remark);

            sourceService.saveSource(source, userView);

            return ResultEntity.newResultEntity("上传成功", url);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("上传异常");
        }
    }


    @ApiOperation(value = "获取个人历史考试，每一次的考试试卷详情", httpMethod = "POST", notes = "根据clientId获取该登录用户的个人历史成绩（只针对考试试卷）详情列表,只返回提交过成绩的考试记录。平时练习不计入成绩.如果传了身份证，那么返回该身份证对应的人的历史成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "identi", value = "身份证"),
    })
    @RequestMapping(value = "/getHistoryScore")
    public ResultEntity getHistoryScore(HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            List<PersonExamHistoryWithBLOBs> res = new ArrayList<>();
            String identi = getParamVal(request, "identi");
            if (StringUtils.isEmpty(identi)) {
                //没传身份证
                res = questionService.getHistoryScore(getAppLoginUser(request));
            } else {
                //传了身份证
                res = questionService.getHistoryScore(userService.selectUserViewByIdenti(identi));
            }
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取异常");
        }
    }

    @ApiOperation(value = "获取某月考试排名列表", httpMethod = "POST", notes = "根据clientId 获取某月份的所有人的成绩情况,如果多次考试，取最高分作为当月最终成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "year", value = "年份例如：2018", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "month", value = "月份例如：7", required = true),
    })
    @RequestMapping(value = "/getMonthScoreList")
    public ResultEntity getMonthScoreList(HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            int month = getParamInt(request, "month");
            int year = getParamInt(request, "year");
            List<ScoreView> res = questionService.getMonthScoreList(year, month);
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取异常");
        }
    }

    @ApiOperation(value = "获取当前登录用户月考试情况，包括所占名次", httpMethod = "POST", notes = "根据clientId 获取指定月份的clientId对应的人的成绩情况")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "year", value = "年份例如：2018", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "month", value = "月份例如：7", required = true),
    })
    @RequestMapping(value = "/personMonthScoreDetail")
    public ResultEntity personMonthScoreDetail(HttpServletRequest request) throws UnsupportedEncodingException {
        try {
            int month = getParamInt(request, "month");
            int year = getParamInt(request, "year");
            UserView userView = getAppLoginUser(request);
            ScoreView res = questionService.personMonthScoreDetail(userView.getRefId(), year, month);
            if (res == null) {
                return ResultEntity.newErrEntity("您本月暂时未参加考试，无成绩详情");
            }
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取异常");
        }
    }


    @ApiOperation(value = "查看app用户活跃情况", httpMethod = "POST", notes = "查询app当天的登录过系统用户数和正在使用app的用户数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/query/login/info")
    public ResultEntity queryLoginInfo(HttpServletRequest request) {

        try {
            Map res = loginLogService.loginReport();
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("查看app用户活跃情况发生错误");
        }
    }

    @ApiOperation(value = "查看当前月考试情况", httpMethod = "POST", notes = "查询当前月的考试情况，返回当前月参加考试的人数,通过考试的人数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/query/exam/info")
    public ResultEntity queryMonthExamDetail(HttpServletRequest request) {

        try {
            Map res = questionService.getExamReport();
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("查看当前月考试情况发生错误");
        }
    }

    @ApiOperation(value = "获取欢迎页面图片", httpMethod = "POST", notes = "获取欢迎页面,不同分辨率的图片")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/welcome/pics")
    public ResultEntity getWelcomePages(HttpServletRequest request) {
        AppConfig appConfig = new AppConfig();
        appConfig.setConfigType("welcome_page_pic");

        try {
            List<AppConfig> configList = appConfigService.configList(appConfig);

            Map map = new HashMap();
            for (AppConfig config : configList) {
                map.put(config.getConfigKey(), config.getConfigValue());
            }
            return ResultEntity.newResultEntity(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("获取欢迎页面图片发生错误");
        }
    }

    @ApiOperation(value = "添加工程报告", httpMethod = "POST", notes = "添加工程报告信息", position = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "name", value = "工程全称", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "simpleName", value = "工程简称", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "desc", value = "工程描述", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/add/project", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResultEntity addProject(@ApiParam(value = "上传工程报告图片", required = true) MultipartFile multipartFile, HttpServletRequest request) {
        try {
            String itemPath = request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port");
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                List<String> uploadList = (List) new FileController().uploadMuti(request).getData();
                ProjectReport projectReport = new ProjectReport();
                projectReport.setProjectName(getParamVal(request, "name"));
                projectReport.setProjectSimpleName(getParamVal(request, "simpleName"));
                projectReport.setProjectDesc(getParamVal(request, "desc"));

                String urls = "";
                for (String url : uploadList) {
                    urls += itemPath + url + ",";
                }
                projectReport.setProjectPic(urls);

                projectReportService.saveProjectReport(projectReport, getAppLoginUser(request));
                return ResultEntity.newResultEntity("上传成功", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("操作失败，请联系管理员");
        }
        return null;
    }

    @ApiOperation(value = "获取工程报告列表", httpMethod = "POST", notes = "根据分页条件获取工程报告列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "条数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/project/list")
    public ResultEntity projectList(HttpServletRequest request) {
        PageInfo<ProjectReport> pageInfo = projectReportService.listAllProjectReport(getPageSize(request), getPageNum(request), null);
        return ResultEntity.newResultEntity(pageInfo);
    }

    @ApiOperation(value = "修改密码", httpMethod = "POST", notes = "根据用户名，修改新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "oldpass", value = "旧密码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "newpass", value = "新密码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/modify/pass")
    public ResultEntity modifyPass(HttpServletRequest request) {
        String username = getParamVal(request, "username");
        String oldpass = getParamVal(request, "oldpass");
        String newpass = getParamVal(request, "newpass");
        UserView user = userService.selectUserViewByUsernameAndPassword(username, AESencryptor.encryptCBCPKCS5Padding(oldpass));
        if (user != null) {
            personService.changeUserPwd(user.getId(), newpass);
            return ResultEntity.newResultEntity("密码修改成功");
        } else {
            return ResultEntity.newErrEntity("旧密码验证错误");
        }

    }


    protected UserView getAppLoginUser(HttpServletRequest request) {
        UserView UserView = (UserView) cacheService.getCacheByKey(request.getParameter("clientId"));
        return UserView;
    }
}
