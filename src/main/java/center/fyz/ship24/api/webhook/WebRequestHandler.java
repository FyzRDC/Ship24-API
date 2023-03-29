package center.fyz.ship24.api.webhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import center.fyz.ship24.api.entities.Tracking;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebRequestHandler extends HttpServlet {

	private static Gson gson = new Gson();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebhookListener webhook_listener = WebhookManager.getWebhookListenerByPort(req.getServerPort());
		if (webhook_listener == null)
			return;
		String data = "";
		if (webhook_listener.getSecret() != null) {
			String auth = req.getHeader("authorization");
			if (auth == null)
				return;
			if (auth.contains("Bearer "))
				auth = auth.split(" ")[1];
			if (!auth.equals(webhook_listener.getSecret()))
				return;
		}
		try {
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			data = builder.toString();
			JSONObject obj = new JSONObject(data);

			ArrayList<Tracking> trackings = new ArrayList<>();

			JSONArray array = obj.getJSONArray("trackings");
			for (int i = 0; i < array.toList().size(); i++) {
				trackings.add(gson.fromJson(array.getJSONObject(i).toString(), Tracking.class));
			}
			
			webhook_listener.onWebhookReceived().execute(trackings);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
