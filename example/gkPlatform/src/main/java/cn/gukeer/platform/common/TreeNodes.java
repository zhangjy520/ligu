package cn.gukeer.platform.common;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LL on 2018/3/20.
 *
 * @Author:
 * @Descrption:
 * @Date:created in 17:35 2018/3/20
 * @Modified By:
 */
public class TreeNodes implements Serializable{
    private String id;
    private String pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
