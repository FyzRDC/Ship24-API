package center.fyz.ship24.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import center.fyz.ship24.exceptions.AuthTokenException;
import center.fyz.ship24.exceptions.InvalidTrackingNumberError;
import center.fyz.ship24.utils.Request;

public class Ship24 {

	private String auth_token;
	private Gson gson = new Gson();
	private String baseURL = "https://api.ship24.com/public/v1"; // Default Ship24's API baseURL

	private List<Courier> couriers = new ArrayList<>();

	public String getBaseURL() {
		return baseURL;
	}

	public Ship24 setBaseURL(String baseURL) {
		this.baseURL = baseURL;
		return this;
	}

	public String getAuthToken() {
		return auth_token;
	}

	protected Ship24() {
	}

	private Ship24 setAuthToken(String auth_token) {
		this.auth_token = auth_token;
		return this;
	}

	public static Ship24 create(String auth_token) throws AuthTokenException {
		Ship24 instance = new Ship24();
		instance.setAuthToken(auth_token);
		if (auth_token == null) {
			throw new AuthTokenException("Auth token cannot be null!");
		}
		try {
			if (instance.getAllCouriers().size() <= 0) { // Test if API is working
				throw new AuthTokenException("Auth token is invalid! (No couriers)");
			}
			System.out.println("[SHIP24-4j] Successfully loaded " + instance.getAllCouriers().size() + " couriers!");
		} catch (Exception e) {
			throw new AuthTokenException("Auth token is invalid!");
		}
		return instance;
	}

	public List<Courier> getAllCouriers() throws IOException, InvalidTrackingNumberError {

		if (couriers.size() > 0) {
			return couriers;
		}
		String requestURL = baseURL + "/couriers";
		String response = Request.get(requestURL, auth_token);
		JSONObject obj = new JSONObject(response);

		JSONArray array = obj.getJSONObject("data").getJSONArray("couriers");
		for (int i = 0; i < array.toList().size(); i++) {
			couriers.add(gson.fromJson(array.getJSONObject(i).toString(), Courier.class));
		}
		return couriers;
	}

	public Tracker createTracking(String trackingNumber) throws JSONException, InvalidTrackingNumberError, IOException {
		return createTracking(trackingNumber, null);
	}

	public Tracker createTracking(String trackingNumber, String[] courierCode)
			throws JSONException, InvalidTrackingNumberError, IOException {
		String requestURL = baseURL + "/trackers";

		HashMap<String, String> values = new HashMap<>();
		values.put("trackingNumber", trackingNumber);
		if (courierCode != null) {
			values.put("courierCode", gson.toJson(courierCode));
		}
		String response = Request.post(requestURL, values, auth_token);
		JSONObject obj = new JSONObject(response);

		if (obj.has("errors") && !obj.getJSONArray("errors").isEmpty()) {
			throw new InvalidTrackingNumberError(obj.getJSONArray("errors").toString());
		}
		return gson.fromJson(obj.getJSONObject("data").getJSONObject("tracker").toString(), Tracker.class);
	}

	public ArrayList<Tracking> getTrackings(String trackingNumber)
			throws JSONException, InvalidTrackingNumberError, IOException {
		String requestURL = baseURL + "/trackers/search/" + trackingNumber + "/results";

		String response = "";

		try {
			response = Request.get(requestURL, auth_token);
		} catch (Exception e) {
			return null;
		}
		JSONObject obj = new JSONObject(response);

		if (obj.has("errors") && !obj.getJSONArray("errors").isEmpty()) {
			throw new InvalidTrackingNumberError(obj.getJSONArray("errors").toString());
		}

		ArrayList<Tracking> trackings = new ArrayList<>();

		JSONArray array = obj.getJSONObject("data").getJSONArray("trackings");
		for (int i = 0; i < array.toList().size(); i++) {
			trackings.add(gson.fromJson(array.getJSONObject(i).toString(), Tracking.class));
		}

		return trackings;
	}

	public Tracking getTracking(String trackingNumber) throws JSONException, InvalidTrackingNumberError, IOException {
		ArrayList<Tracking> trackings = getTrackings(trackingNumber);
		return trackings != null && trackings.size() > 0 ? trackings.get(0) : null;
	}

	public List<Tracker> listExistingTrackers(int page, int limit)
			throws JSONException, InvalidTrackingNumberError, IOException {
		String requestURL = baseURL + "/trackers?page=" + page + "&limit=" + limit;

		String response = Request.get(requestURL, auth_token);
		JSONObject obj = new JSONObject(response);

		if (obj.has("errors") && !obj.getJSONArray("errors").isEmpty()) {
			throw new InvalidTrackingNumberError(obj.getJSONArray("errors").toString());
		}
		ArrayList<Tracker> trackers = new ArrayList<>();

		JSONArray array = obj.getJSONObject("data").getJSONArray("trackers");
		for (int i = 0; i < array.toList().size(); i++) {
			trackers.add(gson.fromJson(array.getJSONObject(i).toString(), Tracker.class));
		}
		return trackers;
	}

}
