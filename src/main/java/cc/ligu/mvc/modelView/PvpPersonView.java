package cc.ligu.mvc.modelView;

import cc.ligu.mvc.persistence.entity.PvpArchievement;
import cc.ligu.mvc.persistence.entity.PvpPerson;


public class PvpPersonView  extends PvpPerson {
    Integer archLevel;
    String archName;

    public Integer getArchLevel() {
        return archLevel;
    }

    public void setArchLevel(Integer archLevel) {
        this.archLevel = archLevel;
    }

    public String getArchName() {
        return archName;
    }

    public void setArchName(String archName) {
        this.archName = archName;
    }


}
