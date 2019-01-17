package by.tc.task01.exception;

/**
 * Created by Vladyka Stas
 * on 17.01.2019 at 14:46
 **/
public class IncorrectPathToFileException extends Exception {
    public IncorrectPathToFileException() {
    }

    public IncorrectPathToFileException(String message) {
        super(message);
    }

    public IncorrectPathToFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPathToFileException(Throwable cause) {
        super(cause);
    }

    public IncorrectPathToFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
