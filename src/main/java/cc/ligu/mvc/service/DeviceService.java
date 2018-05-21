package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by conn on 2016/8/29.
 */
public interface DeviceService {
    DeviceStation findStationByMac(String mac);

    DeviceRing findRingByMac(String mac);

    int saveStation(DeviceStation station, int optId);

    int saveRingByMac(DeviceRing ring);

    int updateRing(DeviceRing ring);

    List<DeviceRing> selectByExample(DeviceRingExample example);

    List<DeviceRing> selectLastRecord(DeviceRing deviceRing);

    List<DeviceRing> findRingsByExample(DeviceRingExample deviceRingExample);

    List<DeviceRing> findDistinctByExample(DeviceRingExample deviceRingExample);

    PageInfo<DeviceStation> findAllDeviceStaion(int pageNum, int pageSize);

    List<DeviceStation> findStationByExample(DeviceStationExample example);

    int deleteStationByMac(String mac);

    DeviceRing findRingByNum(int no);

    int deleteRingByMac(DeviceRing ring);

    List<DeviceRing> findRingByScreenMac(String screenMac);

    List<DeviceRing> findEmptyRingByScreenMac(String screenMac);

    int saveScanLog(ScanLog scanLog);

    List<ScanLog> finScanLogByExample(ScanLogExample scanLogExample);
}
