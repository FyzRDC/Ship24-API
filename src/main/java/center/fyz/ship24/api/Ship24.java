/**
 * Ship24 API Client - Java Implementation
 * 
 * @author FyzRDC
 */

package center.fyz.ship24.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import center.fyz.ship24.api.entities.Courier;
import center.fyz.ship24.api.entities.Tracker;
import center.fyz.ship24.api.entities.Tracking;
import center.fyz.ship24.exceptions.AuthTokenException;
import center.fyz.ship24.exceptions.InvalidTrackingNumberError;
import center.fyz.ship24.utils.Logger;
import center.fyz.ship24.utils.Request;

public class Ship24 {

	private String auth_token;
	private Gson gson = new Gson();
	private String baseURL = "https://api.ship24.com/public/v1"; // Default Ship24's API baseURL

	private List<Courier> couriers = new ArrayList<>();

	/**
	 * Getter for the base URL of the Ship24 API.
	 * 
	 * @return The current base URL.
	 */
	public String getBaseURL() {
		return baseURL;
	}

	/**
	 * Setter for the base URL of the Ship24 API.
	 * 
	 * @param baseURL The new base URL.
	 * @return This Ship24 object, for method chaining.
	 */
	public Ship24 setBaseURL(String baseURL) {
		this.baseURL = baseURL;
		return this;
	}

	/**
	 * Getter for the authorization token used to access the Ship24 API.
	 * 
	 * @return The current authorization token.
	 */
	public String getAuthToken() {
		return auth_token;
	}

	/**
	 * Constructor for the Ship24 object. Protected so that instances of this class
	 * can only be created through the create() method.
	 */
	protected Ship24() {
	}

	/**
	 * Setter for the authorization token used to access the Ship24 API.
	 * 
	 * @param auth_token The new authorization token.
	 * @return This Ship24 object, for method chaining.
	 */
	private Ship24 setAuthToken(String auth_token) {
		this.auth_token = auth_token;
		return this;
	}

	/**
	 * Factory method to create a new Ship24 object.
	 * 
	 * @param auth_token The authorization token to use when accessing the Ship24
	 *                   API.
	 * @return A new Ship24 object.
	 * @throws AuthTokenException If the provided authorization token is null or
	 *                            invalid.
	 */
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
			Logger.info("[SHIP24-4j] Successfully loaded " + instance.getAllCouriers().size() + " couriers!");
		} catch (Exception e) {
			throw new AuthTokenException("Auth token is invalid!");
		}
		return instance;
	}

	/**
	 * Retrieves a list of all available courier services from the Ship24 API.
	 * 
	 * @return A list of all available couriers.
	 * @throws IOException                If there is a problem with the HTTP
	 *                                    request.
	 * @throws InvalidTrackingNumberError If the tracking number is invalid.
	 */
	public List<Courier> getAllCouriers() throws IOException, InvalidTrackingNumberError {

		if (couriers.size() > 0) {
			return couriers; // If couriers list has already been fetched, return it
		}
		String requestURL = baseURL + "/couriers"; // Construct the URL for the API call
		String response = Request.get(requestURL, auth_token); // Send GET request to the API with auth_token
		JSONObject obj = new JSONObject(response); // Parse the response into a JSONObject

		JSONArray array = obj.getJSONObject("data").getJSONArray("couriers"); // Get the "couriers" array from the
																				// response
		for (int i = 0; i < array.toList().size(); i++) {
			couriers.add(gson.fromJson(array.getJSONObject(i).toString(), Courier.class)); // Deserialize each courier
																							// JSON object in the array
																							// and add it to the
																							// couriers list
		}
		return couriers; // Return the updated couriers list
	}

	/**
	 * Creates a new tracking with the provided tracking number and courier code, if
	 * any.
	 * 
	 * @param trackingNumber the tracking number of the package to be tracked
	 * @return the Tracker object containing information about the created tracking
	 * @throws JSONException              if there is an error with the JSON
	 *                                    response
	 * @throws InvalidTrackingNumberError if the tracking number is invalid or the
	 *                                    response contains errors
	 * @throws IOException                if there is an error with the HTTP request
	 */
	public Tracker createTracking(String trackingNumber) throws JSONException, InvalidTrackingNumberError, IOException {
		return createTracking(trackingNumber, null);
	}

	/**
	 * Creates a new tracking with the provided tracking number and courier code, if
	 * any.
	 * 
	 * @param trackingNumber the tracking number of the package to be tracked
	 * @param courierCode    the courier code of the package to be tracked
	 * @return the Tracker object containing information about the created tracking
	 * @throws JSONException              if there is an error with the JSON
	 *                                    response
	 * @throws InvalidTrackingNumberError if the tracking number is invalid or the
	 *                                    response contains errors
	 * @throws IOException                if there is an error with the HTTP request
	 */
	public Tracker createTracking(String trackingNumber, String[] courierCode)
			throws JSONException, InvalidTrackingNumberError, IOException {
		String requestURL = baseURL + "/trackers";

		HashMap<String, Object> values = new HashMap<>();
		values.put("trackingNumber", trackingNumber);
		if (courierCode != null) {
			values.put("courierCode", courierCode);
		}
		String response = Request.post(requestURL, values, auth_token);
		JSONObject obj = new JSONObject(response);

		if (obj.has("errors") && !obj.getJSONArray("errors").isEmpty()) {
			throw new InvalidTrackingNumberError(obj.getJSONArray("errors").toString());
		}
		return gson.fromJson(obj.getJSONObject("data").getJSONObject("tracker").toString(), Tracker.class);
	}

	/**
	 * Gets a list of Trackings with the provided tracking number.
	 * 
	 * @param trackingNumber the tracking number of the package to be tracked
	 * @return an ArrayList of Tracking objects containing information about the
	 *         package
	 * @throws JSONException              if there is an error with the JSON
	 *                                    response
	 * @throws InvalidTrackingNumberError if the tracking number is invalid or the
	 *                                    response contains errors
	 * @throws IOException                if there is an error with the HTTP request
	 */
	public ArrayList<Tracking> getTrackings(String trackingNumber)
			throws JSONException, InvalidTrackingNumberError, IOException {
		String requestURL = baseURL + "/trackers/search/" + trackingNumber + "/results";

		String response = "";

		response = Request.get(requestURL, auth_token);
		if (response == null) {
			throw new InvalidTrackingNumberError("Response sent en error ! The tracking need to be created first.");
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

	/**
	 * Gets a tracking with the provided tracking number.
	 * 
	 * @param trackingNumber the tracking number of the package to be tracked
	 * @return a Tracking objects containing information about the package
	 * @throws JSONException              if there is an error with the JSON
	 *                                    response
	 * @throws InvalidTrackingNumberError if the tracking number is invalid or the
	 *                                    response contains errors
	 * @throws IOException                if there is an error with the HTTP request
	 */
	public Tracking getTracking(String trackingNumber) throws JSONException, InvalidTrackingNumberError, IOException {
		ArrayList<Tracking> trackings = getTrackings(trackingNumber);
		return trackings != null && trackings.size() > 0 ? trackings.get(0) : null;
	}

	/**
	 * List all the trackers that have been created by this account.
	 *
	 * @param page  the page number to retrieve (default 1).
	 * @param limit the number of trackers to retrieve per page (default 50).
	 * @return a list of trackers.
	 * @throws InvalidTrackingNumberError if there is an error communicating with
	 *                                    the API.
	 * @throws IOException                if there is an error communicating with
	 *                                    the API.
	 * @throws JSONException              if there is an error parsing the JSON
	 *                                    response from the API.
	 */
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
