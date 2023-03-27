package center.fyz.ship24.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @Author: @FyzRDC
 * Class for making HTTP requests using POST, GET and PATCH methods
 */
public class Request {

    /**
     * Sends a POST request with given data and authorization token
     * @param url URL to send the request to
     * @param datas HashMap containing the data to be sent in JSON format
     * @param auth_token Authorization token to be included in the request header
     * @return The response as a string
     * @throws IOException if an I/O exception occurs while sending the request or receiving the response
     */
    public static String post(String url, HashMap<String, Object> datas, String auth_token) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Authorization", "Bearer " + auth_token);
        con.addRequestProperty("Content-Type", "application/" + "JSON");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        Gson gson = new Gson();
        String json = gson.toJson(datas);
        os.write(json.getBytes("UTF-8"));
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    /**
     * Sends a GET request with authorization token
     * @param url URL to send the request to
     * @param auth_token Authorization token to be included in the request header
     * @return The response as a string
     * @throws IOException if an I/O exception occurs while sending the request or receiving the response
     */
    public static String get(String url, String auth_token) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Authorization", "Bearer " + auth_token);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    /**
     * Sends a PATCH request with given data and authorization token
     * @param url URL to send the request to
     * @param datas Map containing the data to be sent in JSON format
     * @param auth_token Authorization token to be included in the request header
     * @return The response as a string
     * @throws IOException if an I/O exception occurs while sending the request or receiving the response
     */
    public static String patch(String url, Map<String, String> datas, String auth_token) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PATCH");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + auth_token);
        Gson gson = new Gson();
        String json = gson.toJson(datas);
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.flush();
        os.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

}
