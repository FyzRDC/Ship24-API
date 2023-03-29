package center.fyz.ship24.exceptions;

@SuppressWarnings("serial")
public class WebhookListenerError extends Exception {

    public WebhookListenerError(final Throwable cause) {
        super(cause);
    }

    public WebhookListenerError(final String message) {
        super(message);
    }
}