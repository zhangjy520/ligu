package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.mvc.persistence.dao.A_DeviceExtensionMapper;
import cc.ligu.mvc.persistence.dao.DeviceRingMapper;
import cc.ligu.mvc.persistence.dao.DeviceStationMapper;
import cc.ligu.mvc.persistence.dao.ScanLogMapper;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by conn on 2016/8/29.
 */
@Service
public class DeviceServiceImpl extends BasicService implements DeviceService {

    @Autowired
    DeviceRingMapper ringMapper;

    @Autowired
    DeviceStationMapper stationMapper;

    @Autowired
    A_DeviceExtensionMapper deviceExtensionMapper;

    @Autowired
    ScanLogMapper scanLogMapper;

    @Override
    public DeviceStation findStationByMac(String mac) {

        DeviceStationExample example = new DeviceStationExample();
        example.createCriteria().andStationMacEqualTo(mac);

        List<DeviceStation> stations = stationMapper.selectByExample(example);

        DeviceStation station = null;
        if (null != stations && stations.size() > 0) {
            station = stations.get(0);
        }

        return station;
    }

    @Override
    public DeviceRing findRingByMac(String mac) {

        DeviceRingExample example = new DeviceRingExample();
        example.createCriteria().andMacEqualTo(mac).andDelFlagEqualTo(0);

        List<DeviceRing> rings = ringMapper.selectByExample(example);

        DeviceRing ring = null;
        if (null != rings && rings.size() > 0) {
            ring = rings.get(0);
        }

        return ring;
    }

    @Override
    public int saveStation(DeviceStation station, int optId) {

        int count = 0;

        if (null != findStationByMac(station.getStationMac())) {
            DeviceStationExample example = new DeviceStationExample();
            example.createCriteria().andStationMacEqualTo(station.getStationMac());
            station.setUpdateBy(optId);
            station.setUpdateDate(System.currentTimeMillis());
            count = stationMapper.updateByExampleSelective(station, example);
        } else {
            station.setCreateBy(optId);
            station.setCreateDate(System.currentTimeMillis());
            count = stationMapper.insertSelective(station);
        }

        return count;
    }

    @Override
    public int saveRingByMac(DeviceRing ring) {

        int count = 0;

        if (null != findRingByMac(ring.getMac())) {
            DeviceRingExample example = new DeviceRingExample();
            example.createCriteria().andMacEqualTo(ring.getMac());
            ring.setLastUpdate(System.currentTimeMillis());
            count = ringMapper.updateByExampleSelective(ring, example);
        } else {
            ring.setLastUpdate(System.currentTimeMillis());
            count = ringMapper.insertSelective(ring);
        }
        return count;
    }

    @Override
    public int updateRing(DeviceRing ring) {
        return ringMapper.updateByPrimaryKey(ring);
    }

    @Override
    public List<DeviceRing> selectByExample(DeviceRingExample example) {
        return ringMapper.selectByExample(example);
    }

    @Override
    public List<DeviceRing> selectLastRecord(DeviceRing deviceRing) {
        return deviceExtensionMapper.selectLastRingRecord(deviceRing);
    }

    @Override
    public List<DeviceRing> findRingsByExample(DeviceRingExample deviceRingExample) {
        return ringMapper.selectByExample(deviceRingExample);
    }

    @Override
    public List<DeviceRing> findDistinctByExample(DeviceRingExample deviceRingExample) {
        return deviceExtensionMapper.findDistinctRingsByExample(deviceRingExample);
    }

    @Override
    public PageInfo<DeviceStation> findAllDeviceStaion(int pageNum, int pageSize) {

        DeviceStationExample example = new DeviceStationExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause("create_date desc");

        PageHelper.startPage(pageNum, pageSize);
        List<DeviceStation> list = stationMapper.selectByExample(example);
        PageInfo<DeviceStation> pageInfo = new PageInfo<DeviceStation>(list);

        return pageInfo;
    }

    @Override
    public List<DeviceStation> findStationByExample(DeviceStationExample example) {
        List<DeviceStation> list = stationMapper.selectByExample(example);
        return list;
    }

    @Override
    public int deleteStationByMac(String mac) {

        int count = 0;
        if (null != findStationByMac(mac)) {
            DeviceStation station = new DeviceStation();
            station.setDelFlag(1);
            DeviceStationExample example = new DeviceStationExample();
            example.createCriteria().andStationMacEqualTo(mac);

            count = stationMapper.updateByExampleSelective(station, example);
        }

        return count;
    }

    @Override
    public DeviceRing findRingByNum(int no) {

        DeviceRingExample example = new DeviceRingExample();
        example.createCriteria().andRingNumEqualTo(no);

        List<DeviceRing> rings = ringMapper.selectByExample(example);

        DeviceRing ring = null;
        if (null != rings && rings.size() > 0) {
            ring = rings.get(0);
        }

        return ring;
    }

    @Override
    public int deleteRingByMac(DeviceRing ring) {

        DeviceRingExample example = new DeviceRingExample();
        example.createCriteria().andMacEqualTo(ring.getMac());
        int count = ringMapper.deleteByExample(example);

        if (count > 0) {

            ScanLogExample scanLogExample = new ScanLogExample();
            scanLogExample.createCriteria().andMacEqualTo(ring.getMac());
            int delCount = scanLogMapper.deleteByExample(scanLogExample);
            logger.info("====== delete scanLog with ring mac : {} ======", delCount);
        }

        return count;
    }

    @Override
    public List<DeviceRing> findRingByScreenMac(String screenMac) {

        List<DeviceRing> list = deviceExtensionMapper.findRingListByScreenMac(screenMac);

        return list;
    }

    @Override
    public List<DeviceRing> findEmptyRingByScreenMac(String screenMac) {

        List<DeviceRing> list = deviceExtensionMapper.findEmptyRingByScreenMac(screenMac);

        return list;
    }

    @Override
    public List<ScanLog> finScanLogByExample(ScanLogExample scanLogExample) {

        List<ScanLog> list = scanLogMapper.selectByExample(scanLogExample);

        return list;
    }

    @Override
    public int saveScanLog(ScanLog scanLog) {

        ScanLogExample example = new ScanLogExample();
        example.createCriteria().andMacEqualTo(scanLog.getMac());
        List<ScanLog> logs = scanLogMapper.selectByExample(example);
        int count = 0;
        if (null == logs || logs.size() == 0) { // 直接插入

            scanLog.setLastUpdate(System.currentTimeMillis());
            count = scanLogMapper.insertSelective(scanLog);

        } else { // 1 - 3分钟更新一次

            ScanLog tmp = logs.get(0);

            long timestamp = tmp.getLastUpdate();
            long minutes = DateUtils.getDeltaInMinutes(timestamp, System.currentTimeMillis());
//            if (minutes > ConfigData.RING_SCAN_INTERVAL) {
                scanLog.setLastUpdate(System.currentTimeMillis());
                count = scanLogMapper.updateByExampleSelective(scanLog, example);
//            }

        }

        return count;
    }


}
