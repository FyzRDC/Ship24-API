package center.fyz.ship24.exceptions;

@SuppressWarnings("serial")
public class InvalidTrackingNumberError extends Exception {

    public InvalidTrackingNumberError(final Throwable cause) {
        super(cause);
    }

    public InvalidTrackingNumberError(final String message) {
        super(message);
    }
}