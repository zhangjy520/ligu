/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Item;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.UserService;
import cc.ligu.mvc.service.impl.ItemServiceImpl;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.*;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/item")
@Api(value = "ces", description = "sssss")
public class ItemController extends BasicController {

    @Resource
    ItemServiceImpl itemService;

    @Resource
    UserService userService;

    @ApiOperation(value = "用户信息验证接口", httpMethod = "POST", notes = "验证登录账号密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
    })
    @RequestMapping("/api/login")
    public ResultEntity test(HttpServletRequest request) {
        String username = getParamVal(request, "username");
        String password = getParamVal(request, "password");
        UserView user = userService.selectUserViewByUsernameAndPassword(username, AESencryptor.encryptCBCPKCS5Padding(password));
        if (null == user) {
            return ResultEntity.newErrEntity("用户名或密码错误");
        } else {
            return ResultEntity.newResultEntity(user);
        }
    }

    @RequestMapping(value = "/apaai")
    @ApiOperation(value = "根据用户名获取用户对象", httpMethod = "GET", response = String.class, notes = "根据用户名获取用户对象")
    public String itemIndex(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");//项目名称模糊查询

        Item item = new Item();
        item.setName(name);

        PageInfo<Item> pageInfo = itemService.listAllItem(getPageSize(request), getPageNum(request), item);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("chooseName", name);
        return "item/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            Item item = itemService.selectItemByPrimary(Integer.parseInt(id));
            model.addAttribute("item", item);
        }
        model.addAttribute("itemList", itemService.listAllItem());
        return "item/pop/editItem";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveItem(HttpServletRequest request, Model model, Item item) {
        try {
            itemService.saveItem(item);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("500", "保存项目失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存项目成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteItem(Model model, @PathVariable("id") int id) {
        try {
            Item item = new Item();
            item.setId(id);
            itemService.deleteItem(item);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("500", "删除项目失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除项目成功", "");
    }
}
