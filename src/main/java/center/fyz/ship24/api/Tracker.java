package center.fyz.ship24.api;

public class Tracker {

	private String trackerID, trackingNumber, shipmentReference, createdAt;
	private boolean isSubscribed;

	private Tracker(String trackedID, String trackingNumber, String shipmentReference, String createdAt,
			boolean isSubscribed) {
		this.trackerID = trackedID;
		this.trackingNumber = trackingNumber;
		this.shipmentReference = shipmentReference;
		this.createdAt = createdAt;
		this.isSubscribed = isSubscribed;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getShipmentReference() {
		return shipmentReference;
	}

	public String getTrackerID() {
		return trackerID;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

}
