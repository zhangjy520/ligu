package cc.ligu.common.config;

import java.io.Serializable;

/**
 * Created by zjy on 2018/5/22.
 */
public class KVEntity implements Serializable{
    private String key;
    private String value;
    public KVEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
