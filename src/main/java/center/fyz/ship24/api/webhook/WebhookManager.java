package center.fyz.ship24.api.webhook;

import java.util.HashMap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import center.fyz.ship24.exceptions.WebhookListenerError;
import center.fyz.ship24.utils.Logger;

public class WebhookManager {

	private static HashMap<Server, WebhookListener> webhooks = new HashMap<>();

	protected static WebhookListener getWebhookListenerByPort(int port) {
		return webhooks.values().stream().filter(webhook -> webhook.getPort() == port).findAny().orElse(null);
	}

	private static void createServer(WebhookListener wh) {
		Server server = new Server(wh.getPort());

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(WebRequestHandler.class, wh.getPath());
		server.setHandler(handler);
		webhooks.put(server, wh);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			new WebhookListenerError(e.getCause()).printStackTrace();
		}
	}

	protected static void initListen(WebhookListener wh) throws Exception {
		new Thread(new Runnable() {
			public void run() {
				createServer(wh);
			}
		}).start();
		Logger.info("Port " + wh.getPort() + " is now used by a webhook! Path : " + wh.getPath());
	}

}
