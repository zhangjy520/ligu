/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.api;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.mvc.modelView.BaoXianView;
import cc.ligu.mvc.service.*;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.controller.FileController;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.impl.ItemServiceImpl;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    CacheService cacheService;

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
            request.getSession().removeAttribute(clientId);
        } catch (Exception e) {
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
            cacheService.addCache(clientId,user);
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
    public ResultEntity loginT(HttpServletRequest request) {
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
    @RequestMapping("/add/black")
    public ResultEntity addToBlack(HttpServletRequest request) {
        try {
            String name = new String(getParamVal(request, "name").getBytes("ISO-8859-1"),"utf-8");
            String num = new String(getParamVal(request, "num").getBytes("ISO-8859-1"),"utf-8");
            String remark = new String(getParamVal(request, "remark").getBytes("ISO-8859-1"),"utf-8");
            Person person = new Person();
            person.setName(name);
            person.setIdentityNum(num);
            person.setBlackFlag(1);//[0正常 ,1黑名单待审，2黑名单人员]
            person.setRemark(remark);//申请拉黑原因

            int size = personService.savePerson(person, getAppLoginUser(request));
            return ResultEntity.newResultEntity("添加成功");
        } catch (Exception e) {
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
            Map uploads = (Map) new FileController().uploads(multipartFile, request).getData();
            User user = userService.selectUserViewByUserId(Integer.valueOf(request.getParameter("userId")));
            user.setPhotoUrl(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + uploads.get("fileRequestPath"));
            UserView userView = getAppLoginUser(request);
            userService.saveUser(user, userView);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.newErrEntity("设置异常");
        }
        return ResultEntity.newResultEntity("设置成功");
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

            List<Map> questionList = questionService.selectRandomQuestionByCount(count);
            UserView userView = getAppLoginUser(request);
            StringBuilder questionIds = new StringBuilder();
            for (Map question : questionList) {
                questionIds.append(question.get("id") + ",");
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
            return ResultEntity.newErrEntity("操作失败");
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
            return ResultEntity.newErrEntity("操作失败");
        }
    }


    @ApiOperation(value = "提交错题列表", httpMethod = "POST", notes = "根据客户端id，错题id，正确答案，你的答案的json串来提交错题！格式参见文档")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "jsonStr", value = "错题json[{questionId:123,yourAnswer:A,correctAnswer:D}]", required = true),
    })
    @RequestMapping(value = "/uploadWrongExam")
    public ResultEntity uploadWrongExam(HttpServletRequest request) {
        String json = getParamVal(request, "jsonStr");

        try {
            UserView userView = getAppLoginUser(request);
            questionService.saveWrongExam(json,userView);

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
        String  questionIds = getParamVal(request, "questionIds");
        UserView user = getAppLoginUser(request);

        try {
            questionService.removeWrongQuestion(questionIds,user.getRefId());
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
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoNum", value = "保险单号", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoCompany", value = "保险公司", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "baoTime", value = "保险期限", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "company", value = "承包公司", required = true),
    })
    @RequestMapping(value = "/saveInfo")
    public ResultEntity saveInfo(HttpServletRequest request) throws UnsupportedEncodingException {
        String personName = new String(getParamVal(request, "personName").getBytes("ISO-8859-1"),"utf-8");
        String identify = new String(getParamVal(request, "identity").getBytes("ISO-8859-1"),"utf-8");
        String proUnit = new String(getParamVal(request, "proUnit").getBytes("ISO-8859-1"),"utf-8");
        String baoNum = new String(getParamVal(request, "baoNum").getBytes("ISO-8859-1"),"utf-8");
        String company = new String(getParamVal(request, "company").getBytes("ISO-8859-1"),"utf-8");
        String baoCompany = new String(getParamVal(request, "baoCompany").getBytes("ISO-8859-1"),"utf-8");
        String baoTime = new String(getParamVal(request, "baoTime").getBytes("ISO-8859-1"),"utf-8");
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

            person.setInsurancePurchases(new Gson().toJson(baoXianView));
            person.setCompany(company);

            int res = personService.savePerson(person, userView);
            if(-2==res){
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
        String identify = new String(getParamVal(request, "identify").getBytes("ISO-8859-1"),"utf-8");
        try {
            UserView userView = new UserView();
            userView.setIdentityNum(identify);

            List<UserView> res = userService.selectUserViewByUserView(userView);

            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
            return ResultEntity.newErrEntity("操作失败");
        }
    }


    @ApiOperation(value = "下拉列表数据获取", httpMethod = "POST", notes = "根据客户端id，下拉字典获取下拉数据集合selectId 0承包公司下拉集合/ 1隶属单位集合")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "selectId", value = "下拉列表selectId", required = true),
    })
    @RequestMapping(value = "/getSelectList")
    public ResultEntity getSelectList(HttpServletRequest request) throws UnsupportedEncodingException {

        try {
            int selectId = getParamInt(request,"selectId");
            List<String> res = personService.getAllSelect(selectId);
            return ResultEntity.newResultEntity(res);
        } catch (Exception e) {
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

            PageInfo<Question> res = questionService.listAllQuestion(pageSize,pageNum,new Question());//查询所有的题库集合。
            QuestionVersion version = questionService.selectVersion();

            Map r = new HashMap();
            r.put("version",version.getVersion());
            r.put("list",res.getList());
            r.put("total",res.getTotal());

            return ResultEntity.newResultEntity(r);

        } catch (Exception e) {
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
            return ResultEntity.newErrEntity("获取失败");
        }

    }


    protected UserView getAppLoginUser(HttpServletRequest request) {
        UserView UserView = (UserView) cacheService.getCacheByKey(request.getParameter("clientId"));
        return UserView;
    }
}
