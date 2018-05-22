package cc.ligu.common.exception;

import cc.ligu.common.entity.ResultEntity;

/**
 * Created by zjy on 2018/5/22.
 */
public class ErrcodeException extends cc.ligu.common.exception.CustomException {
    private ResultEntity obj = new ResultEntity();

    public ErrcodeException(String msg) {
        this(ResultEntity.ERR_CODE, msg);
    }

    public ErrcodeException(int code, String msg) {
        super(msg);
        obj.setCode(code);
        obj.setMsg(msg);
    }

    public ErrcodeException(String message, Throwable cause) {
        super(message, cause);
        obj.setCode(ResultEntity.ERR_CODE);
        obj.setMsg(message);
    }

    public ErrcodeException(int errcode,String message, Throwable cause) {
        this(message,cause);
        obj.setCode(errcode);
    }

    public int getErrcode() {
        return obj.getCode();
    }

    public void setErrcode(int errcode) {
        obj.setCode(errcode);
    }

    public Object getData() {
        return obj.getData();
    }

    public void setData(Object data) {
        this.obj.setData(data);
    }

    public ResultEntity getObj() {
        return obj;
    }
}
