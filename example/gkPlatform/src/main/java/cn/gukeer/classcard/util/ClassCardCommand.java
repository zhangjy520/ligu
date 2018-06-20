package cn.gukeer.classcard.util;

/**
 * Created by alpha on 17-11-29.
 */
public enum ClassCardCommand {

    /**
     * 给班牌的指令：
     * APK_INSTALL              //安装apk
     * APK_UNINSTALL            //卸载apk
     * APK_GET_LIST             //获取班牌当前apk列表
     * CONFIG_UPDATE            //配置修改或增加
     * CONFIG_REMOVE            //删除配置
     * CONFIG_RESET             //设备重置，清空开关机配置列表（若没有配置一直开机？）
     * CLASSCARD_ATTENDANCE     //考勤
     * CUSTOM_PUBLISH           //发布自定义界面
     * CUSTOM_UNPUBLISH         //取消发布自定义界面
     */
    UNKNOW("UNKNOW", -1),
    APK_INSTALL("APK_INSTALL", 0),
    APK_UNINSTALL("APK_UNINSTALL", 1),
    APK_GET_LIST("APK_GET_LIST", 2),
    CONFIG_UPDATE("CONFIG_UPDATE", 3),
    CONFIG_REMOVE("CONFIG_REMOVE",4),
    CONFIG_RESET("CONFIG_RESET",5),
    CLASSCARD_ATTENDANCE("CLASSCARD_ATTENDANCE",6),
    CUSTOM_PUBLISH("CUSTOM_PUBLISH",7),
    CUSTOM_UNPUBLISH("CUSTOM_UNPUBLISH",8),
    NOTIFY_PUBLISH("NOTIFY_PUBLISH",9),
    NOTIFY_UNPUBLISH("NOTIFY_UNPUBLISH",10),
    CUSTOM_DELETE_GARBAGE("CUSTOM_DELETE_GARBAGE",11),
    NOTIFY_MODIFY("NOTIFY_PUBLISH",12);


    private String classCardCommand;
    private int index;

    // 定义一个带参数的构造器，枚举类的构造器只能使用 private 修饰
    private ClassCardCommand(String t, int i) {
        this.classCardCommand = t;
        this.index = i;
    }

    public String getClassCardCommand() {
        return classCardCommand;
    }

    public void setClassCardCommand(String classCardCommand) {
        this.classCardCommand = classCardCommand;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ClassCardCommand toclassCardCommand(int index) {

        ClassCardCommand classCardCommand = UNKNOW;

        ClassCardCommand[] classCardCommands = ClassCardCommand.values();
        for (ClassCardCommand item : classCardCommands) {
            if (item.index == index) {
                classCardCommand = item;
                break;
            }
        }
        return classCardCommand;
    }

    public static String getValue(ClassCardCommand classCardCommand) {
        if (null == classCardCommand) {
            return null;
        }
        return classCardCommand.getClassCardCommand();
    }

    public static String getValue(int index) {

        String classCardCommand = UNKNOW.getClassCardCommand();

        ClassCardCommand[] classCardCommands = ClassCardCommand.values();
        for (ClassCardCommand item : classCardCommands) {
            if (item.index == index) {
                classCardCommand = item.getClassCardCommand();
                break;
            }
        }

        return classCardCommand;
    }


}
