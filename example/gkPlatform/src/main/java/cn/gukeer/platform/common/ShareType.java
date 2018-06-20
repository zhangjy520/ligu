package cn.gukeer.platform.common;

/**
 * Created by lx on 2016/11/24.
 */
public enum ShareType {
    //分享
    SHARE(0),

    //被分享
    SHARED(1);

    private final int statenum;

    ShareType(int statenum){
        this.statenum = statenum;
    }

    public int getStatenum() {
        return statenum;
    }
}
