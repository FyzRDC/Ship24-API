/**
 * @Author: @FyzRDC
 * 
 * This class represents a tracking number and provides a method to retrieve it as a string.
 */
package center.fyz.ship24.api.entities;

public class TrackingNumber {
	
	private String tn;
	
	/**
	 * Private constructor to prevent creating objects from outside the class.
	 * @param tn The tracking number.
	 */
	private TrackingNumber(String tn) {
		this.tn = tn;
	}
	
	/**
	 * Returns the tracking number as a string.
	 */
	public String toString() {
		return tn;
	}

}
