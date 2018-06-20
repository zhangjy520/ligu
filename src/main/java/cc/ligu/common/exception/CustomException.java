package cc.ligu.common.exception;

/**
 * Created by zjy on 2018/5/22.
 */
public class CustomException extends RuntimeException{
    private boolean checkErrHandle = true;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public boolean isCheckErrHandle() {
        return checkErrHandle;
    }

    public void setCheckErrHandle(boolean checkErrHandle) {
        this.checkErrHandle = checkErrHandle;
    }
}
