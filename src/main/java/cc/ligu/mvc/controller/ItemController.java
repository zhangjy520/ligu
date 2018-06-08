/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Item;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.service.ItemService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/item")
@Api(value="common", tags={"公共接口"})
@RestController
public class ItemController extends BasicController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/index")
    @ApiOperation(value="test", notes="test,每个国家最多返回8条数据")
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
