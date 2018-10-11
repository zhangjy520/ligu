package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class LoginLog implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录帐号id
     */
    private Integer sysUserId;

    /**
     * 人员id
     */
    private Integer refPersonId;

    /**
     * 登录帐号
     */
    private String username;

    /**
     * 姓名
     */
    private String name;

    /**
     * 0登录中 1已经退出 2其他
     */
    private Integer loginStatus;

    /**
     * 最近登录日期
     */
    private Long loginDate;

    /**
     * 最近登出日期
     */
    private Long logoutDate;

    /**
     * 0 app  1 pc
     */
    private Integer loginSource;

    /**
     * appClient_id/pcClient_id
     */
    private String loginId;

    /**
     * login_log
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录帐号id
     * @return sys_user_id 登录帐号id
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置登录帐号id
     * @param sysUserId 登录帐号id
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取人员id
     * @return ref_person_id 人员id
     */
    public Integer getRefPersonId() {
        return refPersonId;
    }

    /**
     * 设置人员id
     * @param refPersonId 人员id
     */
    public void setRefPersonId(Integer refPersonId) {
        this.refPersonId = refPersonId;
    }

    /**
     * 获取登录帐号
     * @return username 登录帐号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录帐号
     * @param username 登录帐号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取0登录中 1已经退出 2其他
     * @return login_status 0登录中 1已经退出 2其他
     */
    public Integer getLoginStatus() {
        return loginStatus;
    }

    /**
     * 设置0登录中 1已经退出 2其他
     * @param loginStatus 0登录中 1已经退出 2其他
     */
    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * 获取最近登录日期
     * @return login_date 最近登录日期
     */
    public Long getLoginDate() {
        return loginDate;
    }

    /**
     * 设置最近登录日期
     * @param loginDate 最近登录日期
     */
    public void setLoginDate(Long loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取最近登出日期
     * @return logout_date 最近登出日期
     */
    public Long getLogoutDate() {
        return logoutDate;
    }

    /**
     * 设置最近登出日期
     * @param logoutDate 最近登出日期
     */
    public void setLogoutDate(Long logoutDate) {
        this.logoutDate = logoutDate;
    }

    /**
     * 获取0 app  1 pc
     * @return login_source 0 app  1 pc
     */
    public Integer getLoginSource() {
        return loginSource;
    }

    /**
     * 设置0 app  1 pc
     * @param loginSource 0 app  1 pc
     */
    public void setLoginSource(Integer loginSource) {
        this.loginSource = loginSource;
    }

    /**
     * 获取appClient_id/pcClient_id
     * @return login_id appClient_id/pcClient_id
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * 设置appClient_id/pcClient_id
     * @param loginId appClient_id/pcClient_id
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
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
        LoginLog other = (LoginLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()))
            && (this.getRefPersonId() == null ? other.getRefPersonId() == null : this.getRefPersonId().equals(other.getRefPersonId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLoginStatus() == null ? other.getLoginStatus() == null : this.getLoginStatus().equals(other.getLoginStatus()))
            && (this.getLoginDate() == null ? other.getLoginDate() == null : this.getLoginDate().equals(other.getLoginDate()))
            && (this.getLogoutDate() == null ? other.getLogoutDate() == null : this.getLogoutDate().equals(other.getLogoutDate()))
            && (this.getLoginSource() == null ? other.getLoginSource() == null : this.getLoginSource().equals(other.getLoginSource()))
            && (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        result = prime * result + ((getRefPersonId() == null) ? 0 : getRefPersonId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLoginStatus() == null) ? 0 : getLoginStatus().hashCode());
        result = prime * result + ((getLoginDate() == null) ? 0 : getLoginDate().hashCode());
        result = prime * result + ((getLogoutDate() == null) ? 0 : getLogoutDate().hashCode());
        result = prime * result + ((getLoginSource() == null) ? 0 : getLoginSource().hashCode());
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", refPersonId=").append(refPersonId);
        sb.append(", username=").append(username);
        sb.append(", name=").append(name);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", logoutDate=").append(logoutDate);
        sb.append(", loginSource=").append(loginSource);
        sb.append(", loginId=").append(loginId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}