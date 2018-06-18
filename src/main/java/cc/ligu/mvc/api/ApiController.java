/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.api;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.common.utils.SessionTool;
import cc.ligu.mvc.controller.FileController;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.PersonService;
import cc.ligu.mvc.service.SourceService;
import cc.ligu.mvc.service.UserService;
import cc.ligu.mvc.service.impl.ItemServiceImpl;
import com.github.pagehelper.PageInfo;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.*;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @ApiIgnore
    @ApiOperation(value = "通过客户端id判断是否需要登录", httpMethod = "POST", notes = "验证是否需要登录,不需要登录返回用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/getUser")
    public ResultEntity checkIfLogin(HttpServletRequest request) {
        String clientId = getParamVal(request, "clientId");
        Object user = SessionTool.getUserInfoFromSession(request, clientId);

        if (null == user) {
            return ResultEntity.newErrEntity("您需要登录，请重新登录");
        } else {
            return ResultEntity.newResultEntity(user);
        }
    }

    @ApiOperation(value = "退出登录", httpMethod = "POST", notes = "退出登录，清除服务端session",position = 1)
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

    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "验证登录账号密码,登录成功返回该用户的个人信息",position = 1)
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
            SessionTool.setUserInfo2Session(request, clientId, user);//将clientId作为key,
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
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "sourceType", value = "0全部 1培训文档 2安全原则 3视频课程"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/source")
    public ResultEntity loginT(HttpServletRequest request) {
        int pageSize = getPageSize(request);
        int pageNum = getPageNum(request);
        String sourceType = getParamVal(request,"sourceType");
        int type = StringUtils.isEmpty(sourceType)?0:Integer.valueOf(sourceType);
        Source source = new Source();
        source.setType(type);

        PageInfo<Source> pageInfo = sourceService.listAllSource(pageSize,pageNum,source);
        return ResultEntity.newResultEntity(pageInfo);
    }


    @ApiOperation(value = "添加黑名单", httpMethod = "POST", notes = "添加人员到黑名单",position = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String",name = "name", value = "姓名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String",name = "num", value = "身份证号码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/add/black")
    public ResultEntity addToBlack(HttpServletRequest request) {
        String name = getParamVal(request,"name");
        String num = getParamVal(request,"num");
        Person person = new Person();
        person.setName(name);
        person.setIdentityNum(num);
        person.setBlackFlag(1);

        int size = personService.savePerson(person,getAppLoginUser(request));
        return ResultEntity.newResultEntity("添加成功");
    }

    @ApiOperation(value = "查看黑名单列表", httpMethod = "POST", notes = "查询黑名单人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping("/query/black")
    public ResultEntity queryBlack(HttpServletRequest request) {
        Person person = new Person();
        person.setBlackFlag(1);
        List<Person> pageInfo = personService.listAllPerson(person);
        return ResultEntity.newResultEntity(pageInfo);
    }

    @ApiOperation(value = "自定义个人头像",httpMethod = "POST",notes = "根据用户Id,客户端id，设置该用户的头像")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "clientId", value = "客户端id", required = true),
    })
    @RequestMapping(value = "/upload/headpic",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    public ResultEntity uploadHeadPic(@ApiParam(value = "上传头像", required = true)MultipartFile multipartFile,
                                      HttpServletRequest request){
        try {
            Map uploads = (Map) new FileController().uploads(multipartFile,request).getData();
            User user = userService.selectUserViewByUserId(Integer.valueOf(request.getParameter("userId")));
            user.setPhotoUrl(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") +uploads.get("fileRequestPath"));
            UserView userView = getAppLoginUser(request);
            userService.saveUser(user,userView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.newResultEntity("设置成功");
    }
}
