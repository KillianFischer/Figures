package Error;

public class TriangleException extends Exception{
    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }
}
