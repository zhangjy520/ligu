package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.utils.GsonUtil;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.DataService;
import cc.ligu.mvc.service.DeviceService;
import cc.ligu.mvc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by conn on 2016/8/29.
 */
@Controller(value = "/data")
//@RequestMapping(value = "/data")
public class DataController extends BasicController {

    @Autowired
    DataService dataService;

    @Autowired
    DeviceService deviceService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {
//        String teacher = request.getParameter("teacher");
//        if (!StringUtil.isEmpty(teacher)) {
        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);
        PageHelper.startPage(pageNum, 10);
//            deviceRing.setName(teacherName);
        List<DeviceRing> ringList = deviceService.findDistinctByExample(new DeviceRingExample());
        PageInfo<DeviceRing> pageInfo = new PageInfo<DeviceRing>(ringList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("ringList", ringList);
//        }
        return "t/tshjk";
    }

    @ResponseBody
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public ResultEntity receive(HttpServletRequest request, Model model) {

        // schoolIdentity_section_grade_class_number 【学校_学段_年级_班级_编号】
        // zgcxx_x_2_3_1 【中关村学校——小学——2年级-3班-基站1】
        // y【幼儿园】 x【小学】 c【初中】 g【高中】
        String position = request.getParameter("position");
        String data = request.getParameter("data");

        JsonArray array = (JsonArray) GsonUtil.str2Json(data);
        for (int i = 0; i < array.size(); i++) {
            JsonObject jsonObject = (JsonObject) array.get(i);
            System.out.println(jsonObject);

            DeviceStation station = new DeviceStation();
            DeviceRing ring = new DeviceRing();

            String mac = "aaa";
            DeviceStation station1 = deviceService.findStationByMac(mac);
            DeviceRing ring1 = deviceService.findRingByMac(mac);

        }

        return ResultEntity.newResultEntity();
    }

    /**
     * POST请求接口调用
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/receive/temp", method = RequestMethod.POST)
    public ResultEntity receiveTempData(HttpServletRequest request) {

        Map<String, String> param = request.getParameterMap();

//        {"name":"rk3368","timStamp":"20161015065627","rings":[{"signal":"-62","mac":"00:0B:57:1D:73:54"},{"signal":"-56","mac":"FB:0E:08:74:2E:2A"},{"signal":"-76","mac":"80:00:00:4D:00:1F"}],"mac":"22:22:3A:E2:4E:29"}

        // 客户端post程序有问题
        JsonObject jsonObject = null;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            String key = entry.getKey();
            jsonObject = (JsonObject) new JsonParser().parse(key);
            break;
        }
        String className = jsonObject.get("name").getAsString();
        String stationMac = jsonObject.get("mac").getAsString();

        JsonArray array = jsonObject.getAsJsonArray("rings");

        for (int i = 0; i < array.size(); i ++) {

            JsonObject obj = (JsonObject) array.get(i);
            String mac = obj.get("mac").getAsString();
            int signal = obj.get("signal").getAsInt();

            DeviceRingExample ringexample = new DeviceRingExample();
            ringexample.createCriteria().andMacEqualTo(mac).andStatusEqualTo(1).andStationMacEqualTo(stationMac);
            DeviceRing deviceRing = null;
            List<DeviceRing> list = deviceService.findRingsByExample(ringexample);
            if (null == list || list.size() == 0) {
                continue;
            } else {
                deviceRing = list.get(0);
            }

            ScanLog scanLog = new ScanLog();
            scanLog.setMac(mac);
            scanLog.setRingSignal(signal);
            scanLog.setStationMac(stationMac);
            scanLog.setName(className);
            scanLog.setRingNum(deviceRing.getRingNum());
            scanLog.setStudentName(deviceRing.getStudentName());
            scanLog.setStudentId(deviceRing.getStudentId());

            // 1-3分钟更新一次策略
            int n = deviceService.saveScanLog(scanLog);
        }

        return ResultEntity.newResultEntity();
    }

    /**
     * 学生详情
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail")
    public String detail(HttpServletRequest request, Model model) {
        try {
            int pageNum = getPageNum(request);
            int pageSize = getPageSize(request);
            String stuId = request.getParameter("xs");
            if (!StringUtil.isEmpty(stuId)) {
                Student stu = studentService.selectByPrimaryKey(Integer.valueOf(stuId));
                if (null != stu) {
                    PageHelper.startPage(pageNum, 10);
                    DeviceRingExample dre = new DeviceRingExample();
                    dre.createCriteria().andStudentIdEqualTo(stu.getId());

                    List<DeviceRing> detailList = deviceService.findRingsByExample(dre);
                    PageInfo<DeviceRing> pageInfo = new PageInfo<DeviceRing>(detailList);

                    model.addAttribute("stu", stu);
                    model.addAttribute("pageInfo", pageInfo);
                    model.addAttribute("detailList", detailList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "t/detail";
    }

    @RequestMapping(value = "/tbodyHealth")
    public String tbodyHealth(HttpServletRequest request, Model model) {
        return "t/tbodyHealth";
    }

    @RequestMapping(value = "/tclassFiles")
    public String tclassFiles(HttpServletRequest request, Model model) {
        return "t/tclassFiles";
    }

    @RequestMapping(value = "/tdailyData")
    public String tdailyData(HttpServletRequest request, Model model) {
        return "t/tdailyData";
    }

    @RequestMapping(value = "/tdailyHealth")
    public String tdailyHealth(HttpServletRequest request, Model model) {
        return "t/tdailyHealth";
    }

    @RequestMapping(value = "/teacherHome")
    public String teacherHome(HttpServletRequest request, Model model) {
        return "t/teacherHome";
    }

    @RequestMapping(value = "/tfileDetail")
    public String tfileDetail(HttpServletRequest request, Model model) {
        return "t/tfileDetail";
    }

    @RequestMapping(value = "/thealthGuide")
    public String thealthGuide(HttpServletRequest request, Model model) {
        return "t/thealthGuide";
    }

    @RequestMapping(value = "/tP.E.test")
    public String tPEtest(HttpServletRequest request, Model model) {
        return "t/tP.E.test";
    }

    @RequestMapping(value = "/tstudentFiles")
    public String tstudentFiles(HttpServletRequest request, Model model) {
        return "t/tstudentFiles";
    }
}
