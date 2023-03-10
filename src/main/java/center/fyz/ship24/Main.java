package center.fyz.ship24;

import org.json.JSONException;

import center.fyz.ship24.api.Ship24;
import center.fyz.ship24.api.Tracking;
import center.fyz.ship24.exceptions.AuthTokenException;
import center.fyz.ship24.exceptions.InvalidTrackingNumberError;

public class Main {
	
	public static void main(String args[]) {
		try {
			Ship24 ship = Ship24.create("");
			System.out.println("Successfully loaded "+ship.getAllCouriers().size()+" couriers!");
			
			Tracking tracking = ship.getTracking("S24DEMO456393");
			
			System.out.println(tracking.getShipment().getStatusCode());
			
		} catch (AuthTokenException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTrackingNumberError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
