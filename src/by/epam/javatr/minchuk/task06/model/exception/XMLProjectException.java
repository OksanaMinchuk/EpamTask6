package by.epam.javatr.minchuk.task06.model.exception;

public class XMLProjectException extends Exception {
    public XMLProjectException() {
    }

    public XMLProjectException(String message) {
        super(message);
    }

    public XMLProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLProjectException(Throwable cause) {
        super(cause);
    }
}
