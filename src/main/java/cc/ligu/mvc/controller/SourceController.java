/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.service.SourceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/doc")
@Controller
public class SourceController extends BasicController {

    @Autowired
    SourceService sourceService;

    @RequestMapping(value = "/index")
    public String souceIndex(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");//文档名称模糊查询
        String docType = getParamVal(request, "type", "0");//文档类型精确查询 文档类别：0全部 1安全生产视频课程 2安全生产培训文档 3安全生产安全守则 4施工工艺视频课程 5施工工艺培训文档 6施工工艺工艺示例

        Source source = new Source();
        source.setName(name);
        source.setType(Integer.parseInt(docType));

        PageInfo<Source> pageInfo = sourceService.listAllSource(getPageSize(request), getPageNum(request), source);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("chooseType", docType);
        model.addAttribute("chooseName", name);
        return "document/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            Source source = sourceService.selectSourceByPrimary(Integer.parseInt(id));
            model.addAttribute("source", source);
        }
        return "document/pop/editDocument";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveDocument(HttpServletRequest request, Model model, Source source) {
        try {
            String url = source.getUrl();
            if (StringUtils.isEmpty(url)) {
                //如果外链地址填写为空，证明是上传文件操作
                url = getParamVal(request, "fileUrl");
                source.setUrl(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + url);
            }
            sourceService.saveSource(source,getLoginUser());
        } catch (Exception e) {
            e.printStackTrace();
            return DWZResponseUtil.callbackFail("300", "保存资源失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存资源成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteDocument(Model model, @PathVariable("id") int id) {
        try {
            Source source = new Source();
            source.setId(id);
            sourceService.deleteSource(source);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除资源失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除资源成功", "");
    }
}
