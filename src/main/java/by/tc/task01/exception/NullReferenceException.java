package by.tc.task01.exception;

/**
 * Created by Vladyka Stas
 * on 24.12.2018 at 15:25
 **/
public class NullReferenceException extends Exception {
    public NullReferenceException() {
    }

    public NullReferenceException(String message) {
        super(message);
    }

    public NullReferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullReferenceException(Throwable cause) {
        super(cause);
    }

    public NullReferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
