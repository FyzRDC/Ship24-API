package center.fyz.ship24.api;

public class Tracker {

	private String trackerID, shipmentReference, createdAt;
	private String[] trackingNumbers;
	private boolean isSubscribed;

	private Tracker(String trackedID, String[] trackingNumbers, String trackingNumber, String shipmentReference, String createdAt,
			boolean isSubscribed) {
		this.trackerID = trackedID;
		this.trackingNumbers = trackingNumbers;
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

	public String[] getTrackingNumbers() {
		return trackingNumbers;
	}

	public boolean isSubscribed() {
		return isSubscribed;
	}

}
