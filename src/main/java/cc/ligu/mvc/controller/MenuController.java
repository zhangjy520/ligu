package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.utils.NumberConvertUtil;
import cc.ligu.mvc.persistence.entity.Menu;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by conn on 2016/8/1.
 * menu
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BasicController{

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){

        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        PageInfo<Menu> pageInfo = menuService.findAllList(pageNum, pageSize);
        List<Menu> menuList = pageInfo.getList();

        model.addAttribute("menuList", menuList);

        return "menu/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, Model model) {

        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);

        PageInfo<Menu> pageInfo = menuService.findAllList(pageNum, pageSize);
        List<Menu> menuList = pageInfo.getList();

        model.addAttribute("menuList", menuList);

        return "menu/edit";
    }

    /**
     * 编辑
     */
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Model model) {

        String id =getParamVal(request, "id");
        int _id = NumberConvertUtil.convertS2I(id);

        Menu menu = menuService.findMenuById(_id);
        model.addAttribute("menu", menu);

        return "menu/edit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultEntity update(HttpServletRequest request, Model model) {

        String id =getParamVal(request, "id");
        String name =getParamVal(request, "name");
        String href =getParamVal(request, "href");
        String permission =getParamVal(request, "permission");
        String remarks =getParamVal(request, "remarks");

        int _id = NumberConvertUtil.convertS2I(id);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Menu menu = new Menu();
        menu.setId(_id);
        menu.setName(name);
        menu.setHref(href);
        menu.setPermission(permission);
        menu.setRemarks(remarks);

        if (_id == 0) {
            menu.setId(null);
            menu.setCreateBy(user.getId());
            menu.setCreateDate(System.currentTimeMillis());
            menuService.insertMenu(menu);
        } else {
            menu.setUpdateBy(user.getId());
            menu.setUpdateDate(System.currentTimeMillis());
            menuService.updateMenu(menu);
        }

        return ResultEntity.newResultEntity();
    }

    @RequestMapping(value = "/addSub")
    public String addSub(HttpServletRequest request, Model model) {

        String parentId =getParamVal(request, "parentId");
        String subId =getParamVal(request, "subId");

        int _pid = NumberConvertUtil.convertS2I(parentId);
        Menu parent = menuService.findMenuById(_pid);

        int _sid = NumberConvertUtil.convertS2I(subId);
        Menu sub = menuService.findMenuById(_sid);

        model.addAttribute("parent", parent);
        model.addAttribute("sub", sub);

        return "menu/addSub";
    }

    @ResponseBody
    @RequestMapping(value = "/saveSub", method = RequestMethod.POST)
    public ResultEntity addSubMenu(HttpServletRequest request) {

        // 父菜单 ID
        String menuId =getParamVal(request, "menuId");
        // 子菜单 ID
        String subId =getParamVal(request, "subId");
        String name =getParamVal(request, "name");
        String href =getParamVal(request, "href");
        String permission =getParamVal(request, "permission");
        String remarks =getParamVal(request, "remarks");

        int _menuId = NumberConvertUtil.convertS2I(menuId);
        Menu parent = menuService.findMenuById(_menuId);

        int _subId = NumberConvertUtil.convertS2I(subId);
        Menu sub = new Menu();
        sub.setName(name);
        sub.setHref(href);
        sub.setPermission(permission);
        sub.setRemarks(remarks);

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (_subId == 0) { // insert
            sub.setParentId(parent.getId());
            sub.setCreateBy(user.getId());
            sub.setCreateDate(System.currentTimeMillis());
            menuService.insertMenu(sub);
        } else { // update
            sub.setParentId(parent.getId());
            sub.setId(_subId);
            sub.setUpdateBy(user.getId());
            sub.setUpdateDate(System.currentTimeMillis());
            menuService.updateMenu(sub);
        }

        return ResultEntity.newResultEntity();
    }
}
