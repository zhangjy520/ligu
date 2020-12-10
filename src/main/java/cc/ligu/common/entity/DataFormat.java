package cc.ligu.common.entity;

import java.util.List;

/**
 * Created by GW on 2016/8/31.
 */
public class DataFormat {
    private String mac;
    private String name;
    private List<Integer> signalLevel;
    private List<String> rings;
    private String timeStamp;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSignalLevel() {
        return signalLevel;
    }

    public void setSignalLevel(List<Integer> signalLevel) {
        this.signalLevel = signalLevel;
    }

    public List<String> getRings() {
        return rings;
    }

    public void setRings(List<String> rings) {
        this.rings = rings;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
