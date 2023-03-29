package center.fyz.ship24.api.webhook;

import java.util.ArrayList;

import center.fyz.ship24.api.entities.Tracking;

public interface WebhookReceived {

	void execute(ArrayList<Tracking> trackingsFromWebhook);
	
}
