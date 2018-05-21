package cc.ligu.mvc.persistence.entity.extension;

import cc.ligu.mvc.persistence.entity.DeviceRing;
import cc.ligu.mvc.persistence.entity.DeviceStation;
import cc.ligu.mvc.persistence.entity.Student;

/**
 * Created by conn on 16-10-11.
 */
public class ExtensionDeviceRing extends DeviceRing {
    private Student student;

    private DeviceStation deviceStation;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DeviceStation getDeviceStation() {
        return deviceStation;
    }

    public void setDeviceStation(DeviceStation deviceStation) {
        this.deviceStation = deviceStation;
    }
}
