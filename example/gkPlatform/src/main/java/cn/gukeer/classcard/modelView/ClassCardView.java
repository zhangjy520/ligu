package cn.gukeer.classcard.modelView;


import cn.gukeer.classcard.persistence.entity.ClassCard;

/**
 * Created by alpha on 17-6-27.
 */
public class ClassCardView extends ClassCard {
    private String locationName;
    private String xd;
    private String nj;
    private String xq;
    private Long cardRefAppCreateDate;
    //发出安装/卸载apk指令的时间
    private String appDistributionTime;
    //版本号
    private Integer versionCode;
    //得到安装/卸载指令反馈的时间
    private Long feedBackTime;
    private String feedBackTimeFormat;
    //反馈的状态
    private Integer feedBackStatus;
    //反馈备注
    private String feedBackRemarks;

    private String appStatus;

    public String getFeedBackTimeFormat() {
        return feedBackTimeFormat;
    }

    public void setFeedBackTimeFormat(String feedBackTimeFormat) {
        this.feedBackTimeFormat = feedBackTimeFormat;
    }

    public void setFeedBackStatus(Integer feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public Long getFeedBackTime() {
        return feedBackTime;
    }

    public void setFeedBackTime(Long feedBackTime) {
        this.feedBackTime = feedBackTime;
    }

    public String getAppDistributionTime() {
        return appDistributionTime;
    }

    public void setAppDistributionTime(String appDistributionTime) {
        this.appDistributionTime = appDistributionTime;
    }

    public Integer getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(int feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public String getFeedBackRemarks() {
        return feedBackRemarks;
    }

    public void setFeedBackRemarks(String feedBackRemarks) {
        this.feedBackRemarks = feedBackRemarks;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public Long getCardRefAppCreateDate() {
        return cardRefAppCreateDate;
    }

    public void setCardRefAppCreateDate(Long cardRefAppCreateDate) {
        this.cardRefAppCreateDate = cardRefAppCreateDate;
    }

    private String schoolName;

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getXd() {
        return xd;
    }

    public void setXd(String xd) {
        this.xd = xd;
    }

    public String getNj() {
        return nj;
    }

    public void setNj(String nj) {
        this.nj = nj;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
