package by.tc.task01.exception;

/**
 * Created by Vladyka Stas
 * on 24.12.2018 at 15:30
 **/
public class AnalogIOException extends Exception{
    public AnalogIOException() {
    }

    public AnalogIOException(String message) {
        super(message);
    }

    public AnalogIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalogIOException(Throwable cause) {
        super(cause);
    }

    public AnalogIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
