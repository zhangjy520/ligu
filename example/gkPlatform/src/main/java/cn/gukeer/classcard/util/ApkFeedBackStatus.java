package cn.gukeer.classcard.util;

/**
 * Created by alpha on 17-11-29.
 */
public enum ApkFeedBackStatus {


    UNKNOW("UNKNOW", -2),
    /**
     * 安装成功
     */
    APK_FEED_BACK_STATUS_SUCCESS("安装成功", 0),
    /**
     * 安装失败
     */
    APK_FEED_BACK_STATUS_FAIL("安装失败,请检查网络状况或重新安装\"后台管理\"apk再推送应用", -1),
    /**
     * 已安装
     */
    APK_FEED_BACK_STATUS_INSTALLED("已安装", 1),
    /**
     * 卸载失败
     */
    APK_FEED_BACK_STATUS_UNINSTALL_FAIL("卸载失败,请检查网络状况或重新安\"后台管理\"apk再推送应用", 2);

    private String status;
    private int index;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private 修饰
    private ApkFeedBackStatus(String t, int i) {
        this.status = t;
        this.index = i;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ApkFeedBackStatus toApkFeedBackStatus(int index) {
        ApkFeedBackStatus apkFeedBackStatus = UNKNOW;
        ApkFeedBackStatus[] apkFeedBackStatuses = ApkFeedBackStatus.values();
        for (ApkFeedBackStatus item : apkFeedBackStatuses) {
            if (item.index == index) {
                apkFeedBackStatus = item;
                break;
            }
        }
        return apkFeedBackStatus;
    }

    public static String getValue(ApkFeedBackStatus apkFeedBackStatus) {
        if (null == apkFeedBackStatus) {
            return null;
        }
        return apkFeedBackStatus.getStatus();
    }

    public static String getValue(int index) {
        String status = UNKNOW.getStatus();
        ApkFeedBackStatus[] apkFeedBackStatuses = ApkFeedBackStatus.values();
        for (ApkFeedBackStatus item : apkFeedBackStatuses) {
            if (item.index == index) {
                status = item.getStatus();
                break;
            }
        }
        return status;
    }


}
