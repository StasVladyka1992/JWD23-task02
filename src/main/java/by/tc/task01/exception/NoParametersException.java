package by.tc.task01.exception;

/**
 * Created by Vladyka Stas
 * on 21.12.2018 at 21:38
 **/
public class NoParametersException extends Exception {
    public NoParametersException() {
    }

    public NoParametersException(String message) {
        super(message);
    }

    public NoParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoParametersException(Throwable cause) {
        super(cause);
    }

    public NoParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
