package cc.ligu.mvc.modelView.importExport;


import cc.ligu.common.utils.excel.annotation.ExcelField;

/**
 * Created by conn on 2016/8/21.
 */
public class ImportRing {

    private Integer ringNumber;
    private String ringMac;

    @ExcelField(title = "手环编号", align = 2, sort = 1, groups = {1, 2},isnull=1)
    public Integer getRingNumber() {
        return ringNumber;
    }

    public void setRingNumber(Integer ringNumber) {
        this.ringNumber = ringNumber;
    }

    @ExcelField(title = "手环MAC", align = 2, sort = 1, groups = {1, 2},isnull=1)
    public String getRingMac() {
        return ringMac;
    }

    public void setRingMac(String ringMac) {
        this.ringMac = ringMac;
    }
}
