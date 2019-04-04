package cn.ideacs.coding.algorithm;

/**
 * 执行器计算异常。
 */
public class CaclException extends RuntimeException{

    public CaclException() {
    }

    public CaclException(String message) {
        super(message);
    }

    public CaclException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaclException(Throwable cause) {
        super(cause);
    }
}
