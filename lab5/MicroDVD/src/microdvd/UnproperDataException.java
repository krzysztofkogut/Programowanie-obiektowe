package microdvd;

public class UnproperDataException extends Exception {

    public UnproperDataException() {
            super();
    }

    public UnproperDataException(String message) {
            super(message);
    }

    public UnproperDataException(Throwable cause) {
            super(cause);
    }

    public UnproperDataException(String message, Throwable cause) {
            super(message, cause);
    }

    public UnproperDataException(String message, Throwable cause,
                    boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
    }

}