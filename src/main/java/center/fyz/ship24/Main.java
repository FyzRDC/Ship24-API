package center.fyz.ship24;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import center.fyz.ship24.api.Courier;
import center.fyz.ship24.api.Ship24;
import center.fyz.ship24.api.Tracking;
import center.fyz.ship24.exceptions.AuthTokenException;
import center.fyz.ship24.exceptions.InvalidTrackingNumberError;

public class Main {
	
	public static void main(String args[]) {
		try {
			Ship24 ship = Ship24.create("apik_yoj5kqFKNhshERubSEGImcx2CEzbRo");
			Tracking updated = ship.getTracking("6G59355834327");
		
			List<Courier> carriers = ship.getAllCouriers();
			for (Courier carrier : carriers) {
			    System.out.println(carrier.getCourierCode());
			}
			
			
			
		} catch (AuthTokenException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InvalidTrackingNumberError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
