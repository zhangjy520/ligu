package cc.ligu.mvc.common;

/**
 * Created by zjy on 2018/5/22.
 */
public enum UserRoleType {


    ROOT(0, "超级管理员"), ADMIN(1, "区级管理员"), TEACHER(2, "老师"), STUDENT(3, "学生"), PATRIARCH(4, "家长");

    /**
     * root
     */
    public static final String ROLE_ROOT = "root";

    /**
     * admin
     */
    public static final String ROLE_ADMIN = "admin";

    /**
     * teacher
     */
    public static final String ROLE_TEACHER = "teacher";

    /**
     * student
     */
    public static final String ROLE_STUDENT = "student";

    /**
     * 家长
     */
    public static final String ROLE_PATRIARCH = "patriarch";

    /**
     * 班牌绑定操作员
     */
    public static final String ROLE_BOARD_USER = "board_user";


    private int index;
    private String name;

    UserRoleType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static String getName(int index) {
        for (UserRoleType c : UserRoleType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}
