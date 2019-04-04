package cn.ideacs.coding.algorithm;

/**
 * 执行器的参数异常
 */
public class ParamException extends RuntimeException {

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }
}
