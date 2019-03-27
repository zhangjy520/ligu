package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;
import java.util.List;

public class PersonSalary implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 费用类别[生活费 工程款]
     */
    private String feeType;

    /**
     * 人员姓名
     */
    private String personName;

    /**
     * identity_num 人员身份证
     */
    private String personNum;

    /**
     * 发放日期
     */
    private String sendTime;

    /**
     * 工资
     */
    private String sendMuch;

    /**
     * 薪资发放证明文件地址
     */
    private String zhengJuUrls;

    private List<String> zhengJuList;

    public List<String> getZhengJuList() {
        return zhengJuList;
    }

    public PersonSalary setZhengJuList(List<String> zhengJuList) {
        this.zhengJuList = zhengJuList;
        return this;
    }

    /**
     * person_salary
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取费用类别[生活费 工程款]
     * @return fee_type 费用类别[生活费 工程款]
     */
    @ExcelField(title = "费用类别", align = 2, sort = 1, groups = {1, 2}, isnull = 1, isDropDown = 1, dropDownList = {"生活费", "工程款"})
    public String getFeeType() {
        return feeType;
    }

    /**
     * 设置费用类别[生活费 工程款]
     * @param feeType 费用类别[生活费 工程款]
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    /**
     * 获取人员姓名
     * @return person_name 人员姓名
     */
    @ExcelField(title = "姓名", align = 2, sort = 2, groups = {1, 2})
    public String getPersonName() {
        return personName;
    }

    /**
     * 设置人员姓名
     * @param personName 人员姓名
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * 获取identity_num 人员身份证
     * @return person_num identity_num 人员身份证
     */
    @ExcelField(title = "身份证", align = 2, sort = 3, groups = {1, 2})
    public String getPersonNum() {
        return personNum;
    }

    /**
     * 设置identity_num 人员身份证
     * @param personNum identity_num 人员身份证
     */
    public void setPersonNum(String personNum) {
        this.personNum = personNum == null ? null : personNum.trim();
    }

    /**
     * 获取生活费
     * @return send_time 生活费
     */
    @ExcelField(title = "发放日期", align = 2, sort = 4, groups = {1, 2})
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 设置生活费
     * @param sendTime 生活费
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    /**
     * 获取工资
     * @return send_much 工资
     */
    @ExcelField(title = "金额", align = 2, sort = 5, groups = {1, 2})
    public String getSendMuch() {
        return sendMuch;
    }

    /**
     * 设置工资
     * @param sendMuch 工资
     */
    public void setSendMuch(String sendMuch) {
        this.sendMuch = sendMuch == null ? null : sendMuch.trim();
    }

    /**
     * 获取薪资发放证明文件地址
     * @return zheng_ju_urls 薪资发放证明文件地址
     */
    public String getZhengJuUrls() {
        return zhengJuUrls;
    }

    /**
     * 设置薪资发放证明文件地址
     * @param zhengJuUrls 薪资发放证明文件地址
     */
    public void setZhengJuUrls(String zhengJuUrls) {
        this.zhengJuUrls = zhengJuUrls == null ? null : zhengJuUrls.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PersonSalary other = (PersonSalary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFeeType() == null ? other.getFeeType() == null : this.getFeeType().equals(other.getFeeType()))
            && (this.getPersonName() == null ? other.getPersonName() == null : this.getPersonName().equals(other.getPersonName()))
            && (this.getPersonNum() == null ? other.getPersonNum() == null : this.getPersonNum().equals(other.getPersonNum()))
            && (this.getSendTime() == null ? other.getSendTime() == null : this.getSendTime().equals(other.getSendTime()))
            && (this.getSendMuch() == null ? other.getSendMuch() == null : this.getSendMuch().equals(other.getSendMuch()))
            && (this.getZhengJuUrls() == null ? other.getZhengJuUrls() == null : this.getZhengJuUrls().equals(other.getZhengJuUrls()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFeeType() == null) ? 0 : getFeeType().hashCode());
        result = prime * result + ((getPersonName() == null) ? 0 : getPersonName().hashCode());
        result = prime * result + ((getPersonNum() == null) ? 0 : getPersonNum().hashCode());
        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());
        result = prime * result + ((getSendMuch() == null) ? 0 : getSendMuch().hashCode());
        result = prime * result + ((getZhengJuUrls() == null) ? 0 : getZhengJuUrls().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", feeType=").append(feeType);
        sb.append(", personName=").append(personName);
        sb.append(", personNum=").append(personNum);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", sendMuch=").append(sendMuch);
        sb.append(", zhengJuUrls=").append(zhengJuUrls);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}