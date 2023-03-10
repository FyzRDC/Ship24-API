package center.fyz.ship24;

import java.io.IOException;

import org.json.JSONException;

import center.fyz.ship24.api.Ship24;
import center.fyz.ship24.api.Tracker;
import center.fyz.ship24.api.Tracking;
import center.fyz.ship24.exceptions.AuthTokenException;
import center.fyz.ship24.exceptions.InvalidTrackingNumberError;

public class Main {
	
	public static void main(String args[]) {
		try {
			Ship24 ship = Ship24.create("apik_yoj5kqFKNhshERubSEGImcx2CEzbRo");
			Tracking tracking = ship.getTracking("CH010461205DE");
			
			if(tracking != null) {
				System.out.println(tracking.getTracker().isSubscribed());
			} else {
				System.out.println("Is null");
			}
			
			
			Tracker tracker = ship.createTracking("CH010461205DE", new String[] {"fujie-express"});
				
			System.out.println(tracker.getCreatedAt());
			
			Tracking updated = ship.getTracking("CH010461205DE");
			
			System.out.println(updated.getTracker().isSubscribed());
			
			
			
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
