package java.org.hoteljuliet.common.exception;

public class CoRException extends Exception {

    private CoRExceptionType type;

    private CoRException() {
        super();
    }

    public CoRException(String message, CoRExceptionType type) {
        super(message);
        this.type = type;
    }

    public CoRException(String message, CoRExceptionType type, Exception cause) {
        super(message, cause);
        this.type = type;
    }

    public CoRException(CoRExceptionType type, Exception cause) {
        super(cause);
        this.type = type;
    }

    public CoRExceptionType getType() {
        return type;
    }
}
