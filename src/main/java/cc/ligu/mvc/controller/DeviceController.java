package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.common.utils.NumberConvertUtil;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.importExport.ImportRing;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 1. 基站和大屏幕绑定，基站提交数据，带上基站的mac地址；
 * 2. 大屏幕获取数据，带上大屏幕的mac地址提交过来即可；
 * 3. 手环mac和序号绑定；
 * 4. 手环序号和人名绑定；
 * 5. 手环默认随机分班 todo ...；
 * 6. 返回数据json格式。
 * Created by conn on 2016/10/10.
 */
@Controller
@RequestMapping(value = "/device")
public class DeviceController extends BasicController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {

        if (getLoginUser().getUsername().equals("root")) {
            int pageSize = getPageSize(request);
            // 查询所有
            PageInfo<DeviceStation> pageInfo = deviceService.findAllDeviceStaion(0, pageSize);

            model.addAttribute("pageInfo", pageInfo);
            return "device/bindStation";
        } else {

            DeviceRingExample example = new DeviceRingExample();
            example.createCriteria().andStatusNotEqualTo(0);
            PageHelper.startPage(0, 15);
            List<DeviceRing> list = deviceService.selectByExample(example);

            Collections.sort(list, new Comparator<DeviceRing>() {
                @Override
                public int compare(DeviceRing deviceRing, DeviceRing t1) {
                    return deviceRing.getRingNum() - t1.getRingNum();
                }
            });
            PageInfo<DeviceRing> pageInfo = new PageInfo<DeviceRing>(list);
            model.addAttribute("pageInfo", pageInfo);

            return "device/bindRingSecond";
        }

    }


    /**
     * 基站 - 显示屏绑定 - view
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/station/bindStation", method = RequestMethod.GET)
    public String bindStation(HttpServletRequest request, Model model) {

//        int pageNum = getPageNum(request);
        int pageSize = getPageSize(request);
        // 查询所有
        PageInfo<DeviceStation> pageInfo = deviceService.findAllDeviceStaion(0, pageSize);

        model.addAttribute("pageInfo", pageInfo);

        return "device/bindStation";
    }

    @RequestMapping(value = "/station/edit/{mac}")
    public String stationEdit(HttpServletRequest request, Model model,  @PathVariable String mac) {

        DeviceStation station = deviceService.findStationByMac(mac);
        model.addAttribute("station", station);
        model.addAttribute("modify", "uoq7Ja6yban6");

        return "device/bindStation";
    }

    public String stationSave() {

        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/station/del/{mac}", method = RequestMethod.POST)
    public ResultEntity stationDel(HttpServletRequest request, @PathVariable String mac) {

        int count = deviceService.deleteStationByMac(mac);

        return ResultEntity.newResultEntity(count);
    }

    /**
     * 基站 - 显示屏绑定
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/station/doBindStation", method = RequestMethod.POST)
    public ResultEntity doBindStation(HttpServletRequest request) {

        String station = getParamVal(request, "station");
        String screen = getParamVal(request, "screen");
        String className = getParamVal(request, "className");

        // service 根据mac判断modify或者insert
        DeviceStation deviceStation = new DeviceStation();
        deviceStation.setStationMac(station);
        deviceStation.setScreenMac(screen);
        deviceStation.setClassName(className);

        int count = deviceService.saveStation(deviceStation, getLoginUser().getId());

        return ResultEntity.newResultEntity(count);
    }


    /**
     * 手环序号 - mac 绑定 -view
     *
     * @return
     */
    @RequestMapping(value = "/ring/bindRingFirst", method = RequestMethod.GET)
    public String bindRingFirst(HttpServletRequest request, Model model) {

        DeviceRingExample example = new DeviceRingExample();
        example.createCriteria().andDelFlagEqualTo(0);
        int pageNum = getPageNum(request);
        PageHelper.startPage(pageNum, 15);
        List<DeviceRing> list = deviceService.findRingsByExample(example);
        Collections.sort(list, new Comparator<DeviceRing>() {
            @Override
            public int compare(DeviceRing deviceRing, DeviceRing t1) {
                return deviceRing.getRingNum() - t1.getRingNum();
            }
        });

        PageInfo<DeviceRing> pageInfo = new PageInfo<DeviceRing>(list);
        model.addAttribute("pageInfo", pageInfo);

        return "device/bindRingFirst";
    }

    @ResponseBody
    @RequestMapping(value = "/ring/importRings", method = RequestMethod.POST)
    public ResultEntity uploads(@Param("file") MultipartFile file, HttpServletRequest request) throws Exception {

        int count = 0;
        try {
            ImportExcel importExcel = new ImportExcel(file,0, 0); //从2开始
            List<ImportRing> list = importExcel.getDataList(ImportRing.class, 1);
            for (ImportRing importRing : list) {

                DeviceRing deviceRing = new DeviceRing();
                deviceRing.setMac(importRing.getRingMac());
                deviceRing.setRingNum(importRing.getRingNumber());
                deviceRing.setCreateBy(getLoginUser().getId());
                deviceRing.setCreateDate(System.currentTimeMillis());

                int n = deviceService.saveRingByMac(deviceRing);
                count += n;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultEntity.newResultEntity(count);
    }


    /**
     * 手环序号 - mac 绑定
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ring/doBindRingFirst", method = RequestMethod.POST)
    public ResultEntity doBindRingFirst(HttpServletRequest request) {

        String no = getParamVal(request, "no");
        String mac = getParamVal(request, "mac");

        DeviceRing deviceRing = deviceService.findRingByMac(mac);
        /*if (null == deviceRing) {
            return ResultEntity.newErrEntity("手环不存在!");
        } else */
        if (null != deviceRing && deviceRing.getStatus() != 0) {
            return ResultEntity.newErrEntity("该手环已经编号，号码为：" + deviceRing.getRingNum());
        }

        DeviceRing ring = new DeviceRing();
        ring.setRingNum(NumberConvertUtil.convertS2I(no));
        ring.setMac(mac);
        if (null == deviceRing) {
            ring.setCreateDate(System.currentTimeMillis());
            ring.setCreateBy(getLoginUser().getId());
        } else {
            ring.setUpdateBy(getLoginUser().getId());
            ring.setUpdateDate(System.currentTimeMillis());
        }

        int count = deviceService.saveRingByMac(ring);

        return ResultEntity.newResultEntity(count);
    }

    /**
     * 手环序号-使用者姓名 绑定 -view
     * @param request
     * @return
     */
    @RequestMapping(value = "/ring/bindRingSecond", method = RequestMethod.GET)
    public String bindRingSecond(HttpServletRequest request, Model model){

        DeviceRingExample example = new DeviceRingExample();
        example.createCriteria().andStatusNotEqualTo(0);
        example.setOrderByClause("last_update desc");
        int pageNum = getPageNum(request);
        PageHelper.startPage(pageNum, 15);
        List<DeviceRing> list = deviceService.selectByExample(example);

        Collections.sort(list, new Comparator<DeviceRing>() {
            @Override
            public int compare(DeviceRing deviceRing, DeviceRing t1) {
                return (int)(t1.getLastUpdate() - deviceRing.getLastUpdate());
            }
        });

        PageInfo<DeviceRing> pageInfo = new PageInfo<DeviceRing>(list);
        model.addAttribute("pageInfo", pageInfo);

        return "device/bindRingSecond";
    }

    /**
     * 手环序号-使用者姓名 绑定
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ring/doBindRingSecond", method = RequestMethod.POST)
    public ResultEntity doBindRingSecond(HttpServletRequest request){

        String _id = getParamVal(request, "id");
        String no = getParamVal(request, "no");
        String name = getParamVal(request, "name");

        int id = NumberConvertUtil.convertS2I(_id);
        DeviceRing ring = deviceService.findRingByNum(NumberConvertUtil.convertS2I(no));
        if (id == 0) {
            if (null == ring) {
                return ResultEntity.newErrEntity(no + "号手环不存在");
            } else if (ring.getStatus() != 0) {
                return ResultEntity.newErrEntity(no + "号手环已经绑定学生：" + ring.getStudentName());
            }
        }

        DeviceRing deviceRing = new DeviceRing();
        deviceRing.setMac(ring.getMac());
        deviceRing.setRingNum(NumberConvertUtil.convertS2I(no));
        deviceRing.setStudentName(name);
        deviceRing.setStatus(1); // 激活绑定绑定状态

        int count = deviceService.saveRingByMac(deviceRing);

        return ResultEntity.newResultEntity(count);
    }

    /**
     * 编辑已经绑定的学生姓名
     * @param request
     * @param mac
     * @param model
     * @return
     */
    @RequestMapping(value = "/ring/edit/{mac}", method = RequestMethod.GET)
    public String editBindRing(HttpServletRequest request, @PathVariable String mac, Model model) {

        DeviceRing ring = deviceService.findRingByMac(mac);

        model.addAttribute("ring", ring);

        return "device/bindRingSecond";
    }

    /**
     * edit submit
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ring/doEdit", method = RequestMethod.POST)
    public ResultEntity doEditBindRing(HttpServletRequest request) {

        String mac = getParamVal(request, "mac");
        String name = getParamVal(request, "studentName");

        DeviceRing ring = new DeviceRing();
        ring.setMac(mac);
        ring.setStudentName(name);

        int count = deviceService.saveRingByMac(ring);

        return ResultEntity.newResultEntity(count);
    }

    @ResponseBody
    @RequestMapping(value = "/ring/del/{mac}", method = RequestMethod.POST)
    public ResultEntity delBindRing(HttpServletRequest request, @PathVariable String mac) {

        DeviceRing ring = new DeviceRing();
        ring.setMac(mac);

        int count = deviceService.deleteRingByMac(ring);

        return ResultEntity.newResultEntity(count);
    }

    @ResponseBody
    @RequestMapping(value = "/ring/random", method = RequestMethod.POST)
    public ResultEntity randomRingToStation() {

        DeviceStationExample example = new DeviceStationExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause("create_date asc");
        List<DeviceStation> stationList = deviceService.findStationByExample(example);

        DeviceRingExample ringExample = new DeviceRingExample();
        ringExample.createCriteria().andDelFlagEqualTo(0);
        ringExample.setOrderByClause("create_date asc");
        List<DeviceRing> ringList = deviceService.findRingsByExample(ringExample);

        int count = 0;

        for (int i = 0; i < 350; i ++) {
            DeviceRing ring = ringList.get(i);
            DeviceStation station = null;
            if (i < 70) {
                station = stationList.get(0);
            } else if (i >= 70 && i < 140) {
                station = stationList.get(1);
            } else if (i >= 140 && i < 210) {
                station = stationList.get(2);
            } else if (i >= 210 && i < 280) {
                station = stationList.get(3);
            } else if (i >= 280 && i < 380) {
                station = stationList.get(4);
            }
            ring.setStationMac(station.getStationMac());
            ring.setStationName(station.getClassName());
            int n = deviceService.saveRingByMac(ring);
            count += n;
        }

//        for (DeviceRing ring : ringList) {
//            DeviceStation station = stationList.get(index);
//            index = getStationIndex(stationList.size(), index);
//
//            ring.setStationMac(station.getStationMac());
//            ring.setStationName(station.getClassName());
//
//            int n = deviceService.saveRingByMac(ring);
//            count += n;
//        }

        return ResultEntity.newResultEntity(count);
    }

//    private int getStationIndex(int max, int currentIndex) {
//        currentIndex ++;
//        int index = 0;
//        if (currentIndex < max && currentIndex > 0) {
//            index = currentIndex;
//        } else {
//            if (currentIndex == max) {
//                index = 0;
//            }
//        }
//        return index;
//    }

    /**
     * 获取基站对于的手环空数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fetchRings/empty/{screenMac}")
    public ResultEntity fetchEmptyStationRings(HttpServletRequest request, @PathVariable String screenMac) {

        List<DeviceRing> deviceRingList = deviceService.findEmptyRingByScreenMac(screenMac);

//        8号：请假    20号：迟到    31号：缺勤
//        72号：缺勤    75号：迟到    96号：请假
//        123号：迟到    135号：请假    141号：缺勤

//        0默认，1正常，2,离班，3请假，4,迟到，5却勤
        Set<Integer> qingjia = new HashSet<Integer>();
        Set<Integer> chidao = new HashSet<Integer>();
        Set<Integer> queqing = new HashSet<Integer>();
        qingjia.add(60);
        qingjia.add(70+24);
        qingjia.add(140+54);
        qingjia.add(210+15);
        qingjia.add(280+10);

        chidao.add(32);
        chidao.add(70+49);
        chidao.add(140+23);
        chidao.add(210+31);
        chidao.add(280+47);

        queqing.add(46);
        queqing.add(70+38);
        queqing.add(140+42);
        queqing.add(210+37);
        queqing.add(280+32);

        for (DeviceRing ring : deviceRingList) {
            if (qingjia.contains(ring.getRingNum())) {  // 请假
                ring.setStatus(3);
            } else if (chidao.contains(ring.getRingNum())) { // 迟到
                ring.setStatus(4);
            } else if (queqing.contains(ring.getRingNum())) { // 缺勤
                ring.setStatus(5);
            }
        }

        return ResultEntity.newResultEntity(deviceRingList);
    }

    /**
     * 获取基站对于的手环数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fetchRings/{screenMac}")
    public ResultEntity fetchStationRings(HttpServletRequest request, @PathVariable String screenMac) {

        List<DeviceRing> deviceRingList = deviceService.findRingByScreenMac(screenMac);

        if (null == deviceRingList || deviceRingList.size() == 0) {
            return ResultEntity.newResultEntity();
        }

        DeviceRing demoRing = deviceRingList.get(0);
        String stationMac = demoRing.getStationMac();

        ScanLogExample scanLogExample = new ScanLogExample();
        scanLogExample.createCriteria().andStationMacEqualTo(stationMac);
        List<ScanLog> scanLogs = deviceService.finScanLogByExample(scanLogExample);

        Map<String, Object> rstMap = new HashMap<String, Object>();
        rstMap.put("className", demoRing.getStationName());

        Set<Integer> qingjia = new HashSet<Integer>();
        Set<Integer> chidao = new HashSet<Integer>();
        Set<Integer> queqing = new HashSet<Integer>();
        qingjia.add(60);
        qingjia.add(70+24);
        qingjia.add(140+54);
        qingjia.add(210+15);
        qingjia.add(280+10);

        chidao.add(32);
        chidao.add(70+49);
        chidao.add(140+23);
        chidao.add(210+31);
        chidao.add(280+47);

        queqing.add(46);
        queqing.add(70+38);
        queqing.add(140+42);
        queqing.add(210+37);
        queqing.add(280+32);

        for (DeviceRing ring : deviceRingList) {
            int status = 0;
            String studentName = ring.getStudentName();
            if (StringUtils.isBlank(studentName)) { // 姓名异常问题处理
                ring.setStudentName(String.valueOf(ring.getRingNum()));
            }

            if (qingjia.contains(ring.getRingNum())) {  // 请假
                ring.setStatus(3);
                continue;
            } else if (chidao.contains(ring.getRingNum())) { // 迟到
                ring.setStatus(4);
                continue;
            } else if (queqing.contains(ring.getRingNum())) { // 缺勤
                ring.setStatus(5);
                continue;
            }
            for (ScanLog log : scanLogs) {

                if (ring.getMac().equalsIgnoreCase(log.getMac())) { // 找到
                    long minutes = DateUtils.getDeltaInMinutes(log.getLastUpdate(), System.currentTimeMillis());
                    if (minutes < 1) {
                        status = 1;
                    } else if (minutes >= 1) { // 大于设置的值
                        status = 2;
                    }
                    break;
                }
            }
            ring.setStatus(status);
        }

        rstMap.put("ringList", deviceRingList);

        Collections.sort(scanLogs, new Comparator<ScanLog>() {
            @Override
            public int compare(ScanLog scanLog, ScanLog t1) {
                double sortInterval = t1.getLastUpdate() - scanLog.getLastUpdate();
                return (int)sortInterval;
            }
        });

        List<String> newList = new ArrayList<String>();
        if (null != scanLogs && scanLogs.size() > 0) {
            for (int i = 0; i < scanLogs.size() && i < 3; i++) {
                ScanLog log = scanLogs.get(i);
                if (StringUtils.isNotBlank(log.getStudentName())) {
                    newList.add(log.getStudentName());
                }
            }
        }
        rstMap.put("newList", newList);

        return ResultEntity.newResultEntity(rstMap);
    }

}
