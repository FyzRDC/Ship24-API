package center.fyz.ship24.exceptions;

@SuppressWarnings("serial")
public class AuthTokenException extends Exception {

    public AuthTokenException(final Throwable cause) {
        super(cause);
    }

    public AuthTokenException(final String message) {
        super(message);
    }
}