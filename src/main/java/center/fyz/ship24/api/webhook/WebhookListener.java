package center.fyz.ship24.api.webhook;

import center.fyz.ship24.exceptions.WebhookListenerError;
import center.fyz.ship24.utils.Logger;

public class WebhookListener {

	private int port;
	private WebhookReceived onReceive;
	private String path = "/";
	private String secret;

	protected int getPort() {
		return port;
	}

	protected WebhookReceived onWebhookReceived() {
		return onReceive;
	}

	protected String getSecret() {
		return secret;
	}

	protected String getPath() {
		return path;
	}

	private WebhookListener(int port) {
		this.port = port;
	}

	public WebhookListener secret(String secret) {
		this.secret = secret;
		return this;
	}
	
	public WebhookListener path(String path) {
		this.path = path;
		return this;
	}

	public static WebhookListener listen(int port) {
		return new WebhookListener(port);
	}

	public WebhookListener onWebhookReceived(WebhookReceived onWebhookReceive) {
		this.onReceive = onWebhookReceive;
		return this;
	}

	public void start() throws Exception {
		if (WebhookManager.getWebhookListenerByPort(port) != null) {
			throw new WebhookListenerError("Port is already used by another webhook!");
		}
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		if (secret == null) {
			Logger.info("No secret have been set for webhook on port " + port
					+ ", this is not an issue but could cause false positive from external source of request.");
		}
		if (onWebhookReceived() == null) {
			throw new WebhookListenerError("var onReceive setted with onWebhookReceived need to be not null!");
		}
		WebhookManager.initListen(this);
	}

}
