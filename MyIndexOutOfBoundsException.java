/**
 * Custom {@code IndexOutOfBoundsException} implementation.
 */
public final class MyIndexOutOfBoundsException extends RuntimeException {
    /**
     * Constructs a newly allocated {@code MyIndexOutOfBoundsException} object.
     *
     * @param message the message to be displayed when the exception is thrown
     */
    public MyIndexOutOfBoundsException(String message) {
        super(message);
    } //MyIndexOutOfBoundsException
}