package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;
import java.util.Date;

public class Money implements Serializable {
    /**
     * 
     */
    private String moneyName;

    /**
     * 
     */
    private Date moneyDate;

    /**
     * 
     */
    private String todayDetail;

    /**
     * money
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取
     * @return money_name 
     */
    public String getMoneyName() {
        return moneyName;
    }

    /**
     * 设置
     * @param moneyName 
     */
    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName == null ? null : moneyName.trim();
    }

    /**
     * 获取
     * @return money_date 
     */
    public Date getMoneyDate() {
        return moneyDate;
    }

    /**
     * 设置
     * @param moneyDate 
     */
    public void setMoneyDate(Date moneyDate) {
        this.moneyDate = moneyDate;
    }

    /**
     * 获取
     * @return today_detail 
     */
    public String getTodayDetail() {
        return todayDetail;
    }

    /**
     * 设置
     * @param todayDetail 
     */
    public void setTodayDetail(String todayDetail) {
        this.todayDetail = todayDetail == null ? null : todayDetail.trim();
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
        Money other = (Money) that;
        return (this.getMoneyName() == null ? other.getMoneyName() == null : this.getMoneyName().equals(other.getMoneyName()))
            && (this.getMoneyDate() == null ? other.getMoneyDate() == null : this.getMoneyDate().equals(other.getMoneyDate()))
            && (this.getTodayDetail() == null ? other.getTodayDetail() == null : this.getTodayDetail().equals(other.getTodayDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMoneyName() == null) ? 0 : getMoneyName().hashCode());
        result = prime * result + ((getMoneyDate() == null) ? 0 : getMoneyDate().hashCode());
        result = prime * result + ((getTodayDetail() == null) ? 0 : getTodayDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moneyName=").append(moneyName);
        sb.append(", moneyDate=").append(moneyDate);
        sb.append(", todayDetail=").append(todayDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}