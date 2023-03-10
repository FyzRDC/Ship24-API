package center.fyz.ship24.api;

import java.util.HashMap;

public class Shipment {

	private String shipmentId, statusCode, statusCategory, statusMilestone, originCountryCode, destinationCountryCode;
	private Delivery delivery;
	private String[] trackingNumbers;

	public Shipment(String shipmentId, String statusCode, String statusCategory, String statusMilestone,
			String originCountryCode, String destinationCountryCode, Delivery delivery,
			String[] trackingNumbers) {
		this.shipmentId = shipmentId;
		this.statusCode = statusCode;
		this.statusCategory = statusCategory;
		this.statusMilestone = statusMilestone;
		this.originCountryCode = originCountryCode;
		this.destinationCountryCode = destinationCountryCode;
		this.delivery = delivery;
		this.trackingNumbers = trackingNumbers;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public String getDestinationCountryCode() {
		return destinationCountryCode;
	}

	public String getOriginCountryCode() {
		return originCountryCode;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public String getStatusCategory() {
		return statusCategory;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusMilestone() {
		return statusMilestone;
	}

	public String[] getTrackingNumbers() {
		return trackingNumbers;
	}

}
