/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.FileUtils;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Source;
import cc.ligu.mvc.service.SourceService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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

        PageInfo<Source> pageInfo = sourceService.listAllSourceByType(getPageSize(request), getPageNum(request), source, 0);

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
            sourceService.saveSource(source, getLoginUser());
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


    //秀米编辑器
    @RequestMapping(value = "/h5index")
    public String h5index(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");//文档名称模糊查询
        String docType = getParamVal(request, "type", "0");//文档类型精确查询 文档类别：0全部 1安全生产视频课程 2安全生产培训文档 3安全生产安全守则 4施工工艺视频课程 5施工工艺培训文档 6施工工艺工艺示例

        Source source = new Source();
        source.setName(name);
        source.setType(Integer.parseInt(docType));

        PageInfo<Source> pageInfo = sourceService.listAllSourceByType(getPageSize(request), getPageNum(request), source, 1);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("chooseType", docType);
        model.addAttribute("chooseName", name);
        return "document/h5index";
    }

    @RequestMapping("/pop/h5modify")
    public String h5modify(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        List sourceNameList = new ArrayList<>();
        PageInfo<Source> pageInfo = sourceService.listAllSourceByType(getPageSize(request), getPageNum(request), new Source(), 1);
        for (Source s : pageInfo.getList()) {
            HashMap map = new HashMap();
            map.put("id",s.getId());
            map.put("name",s.getName());
            sourceNameList.add(map);
        }
        if (!StringUtils.isEmpty(id)) {
            Source source = sourceService.selectSourceByPrimary(Integer.parseInt(id));
            model.addAttribute("source", source);
        }
        model.addAttribute("sourceNameList",new Gson().toJson(sourceNameList));
        return "document/pop/h5editDocument";
    }

    @ResponseBody
    @RequestMapping(value = "/saveh5", method = RequestMethod.POST)
    public DWZResponse saveh5(HttpServletRequest request, Model model, Source source) {
        String headContent = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\"></head>";
        String footContent = "</html>";
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            if ("content".equals(paraName)) {
                String bodyContent = request.getParameter(paraName);

                source.setHtmlContent(headContent + bodyContent + footContent);
                break;
            }

        }

        try {
            String url = saveLocalHtml(request, source.getName(), source.getHtmlContent());
            source.setUrl(url);
            sourceService.saveSource(source, getLoginUser());
        } catch (IOException e) {
            e.printStackTrace();
            return DWZResponseUtil.callbackFail("500", "保存资源失败", "_blank");
        }

        return DWZResponseUtil.callbackSuccess("保存资源成功", "_blank");
    }

    public String saveLocalHtml(HttpServletRequest request, String fileName, String fileContent) throws IOException {
        String upLoadPath = FileUtils.VFS_ROOT_PATH + FileUtils.H5_ATTACH;
        File filePath = new File(upLoadPath);
        File fileHtml = new File(upLoadPath + fileName + ".html");
        if (fileHtml.exists()) {
            fileHtml.delete();
            fileHtml.createNewFile();
        } else {
            filePath.mkdirs();
        }
        BufferedWriter w = null;
        w = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(upLoadPath + fileName + ".html"), "utf-8"));
        w.write(fileContent);
        w.close();

        String schme = "http";
        if (!StringUtils.isEmpty(request.getScheme())) {
            schme = request.getScheme();
        }
        String requirPath = schme + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + FileUtils.H5_ATTACH + fileName + ".html";
        return requirPath;
    }
}
