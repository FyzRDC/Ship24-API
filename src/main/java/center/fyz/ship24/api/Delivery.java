/**
 * @author FyzRDC
 */

package center.fyz.ship24.api;

public class Delivery {

	// Class attributes
	private String estimatedDeliveryDate, service, signedBy;

	// Constructor
	public Delivery(String estimatedDeliveryDate, String service, String signedBy) {
		// Assign the values passed to the constructor to the class attributes
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.service = service;
		this.signedBy = signedBy;
	}

	// Getter method for the estimatedDeliveryDate attribute
	public String getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	// Getter method for the service attribute
	public String getService() {
		return service;
	}

	// Getter method for the signedBy attribute
	public String getSignedBy() {
		return signedBy;
	}

}
