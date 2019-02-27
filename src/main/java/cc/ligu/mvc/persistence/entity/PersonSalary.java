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
     * 人员姓名
     */
    private String personName;

    /**
     * identity_num 人员身份证
     */
    private String personNum;

    /**
     * 生活费
     */
    private String salaryLife;

    /**
     * 工资
     */
    private String salarySum;

    /**
     * 生活费发放年月[201903]
     */
    private String timeLife;

    /**
     * 工资发放年月[201903]
     */
    private String timeSum;

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
     * 获取人员姓名
     * @return person_name 人员姓名
     */
    @ExcelField(title = "姓名", align = 2, sort = 1,isnull = 1, groups = {1, 2})
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
    @ExcelField(title = "身份证号", align = 2, sort = 2,isnull = 1, groups = {1, 2})
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
     * @return salary_life 生活费
     */
    @ExcelField(title = "生活费金额", align = 2, sort = 3,isnull = 1, groups = {1, 2})
    public String getSalaryLife() {
        return salaryLife;
    }

    /**
     * 设置生活费
     * @param salaryLife 生活费
     */
    public void setSalaryLife(String salaryLife) {
        this.salaryLife = salaryLife == null ? null : salaryLife.trim();
    }

    /**
     * 获取工资
     * @return salary_sum 工资
     */
    @ExcelField(title = "工资金额", align = 2, sort = 5,isnull = 1, groups = {1, 2})
    public String getSalarySum() {
        return salarySum;
    }

    /**
     * 设置工资
     * @param salarySum 工资
     */
    public void setSalarySum(String salarySum) {
        this.salarySum = salarySum == null ? null : salarySum.trim();
    }

    /**
     * 获取生活费发放年月[201903]
     * @return time_life 生活费发放年月[201903]
     */
    @ExcelField(title = "生活费发放日期", align = 2, sort = 4,isnull = 1, groups = {1, 2})
    public String getTimeLife() {
        return timeLife;
    }

    /**
     * 设置生活费发放年月[201903]
     * @param timeLife 生活费发放年月[201903]
     */
    public void setTimeLife(String timeLife) {
        this.timeLife = timeLife == null ? null : timeLife.trim();
    }

    /**
     * 获取工资发放年月[201903]
     * @return time_sum 工资发放年月[201903]
     */
    @ExcelField(title = "工资发放日期", align = 2, sort = 6,isnull = 1, groups = {1, 2})
    public String getTimeSum() {
        return timeSum;
    }

    /**
     * 设置工资发放年月[201903]
     * @param timeSum 工资发放年月[201903]
     */
    public void setTimeSum(String timeSum) {
        this.timeSum = timeSum == null ? null : timeSum.trim();
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
                && (this.getPersonName() == null ? other.getPersonName() == null : this.getPersonName().equals(other.getPersonName()))
                && (this.getPersonNum() == null ? other.getPersonNum() == null : this.getPersonNum().equals(other.getPersonNum()))
                && (this.getSalaryLife() == null ? other.getSalaryLife() == null : this.getSalaryLife().equals(other.getSalaryLife()))
                && (this.getSalarySum() == null ? other.getSalarySum() == null : this.getSalarySum().equals(other.getSalarySum()))
                && (this.getTimeLife() == null ? other.getTimeLife() == null : this.getTimeLife().equals(other.getTimeLife()))
                && (this.getTimeSum() == null ? other.getTimeSum() == null : this.getTimeSum().equals(other.getTimeSum()))
                && (this.getZhengJuUrls() == null ? other.getZhengJuUrls() == null : this.getZhengJuUrls().equals(other.getZhengJuUrls()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonName() == null) ? 0 : getPersonName().hashCode());
        result = prime * result + ((getPersonNum() == null) ? 0 : getPersonNum().hashCode());
        result = prime * result + ((getSalaryLife() == null) ? 0 : getSalaryLife().hashCode());
        result = prime * result + ((getSalarySum() == null) ? 0 : getSalarySum().hashCode());
        result = prime * result + ((getTimeLife() == null) ? 0 : getTimeLife().hashCode());
        result = prime * result + ((getTimeSum() == null) ? 0 : getTimeSum().hashCode());
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
        sb.append(", personName=").append(personName);
        sb.append(", personNum=").append(personNum);
        sb.append(", salaryLife=").append(salaryLife);
        sb.append(", salarySum=").append(salarySum);
        sb.append(", timeLife=").append(timeLife);
        sb.append(", timeSum=").append(timeSum);
        sb.append(", zhengJuUrls=").append(zhengJuUrls);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}