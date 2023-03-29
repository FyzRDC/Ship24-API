package center.fyz.ship24.api.entities;

/**
 * The Tracker class represents a tracking object in the Ship24 API.
 * It contains information about a tracking object, including its ID, tracking numbers,
 * shipment reference, creation date, and subscription status.
 *
 * @author @FyzRDC
 */
public class Tracker {

    private String trackerID, shipmentReference, createdAt;
    private String[] trackingNumbers;
    private boolean isSubscribed;

    /**
     * Constructs a new Tracker object with the specified tracker ID, tracking numbers,
     * shipment reference, creation date, and subscription status.
     *
     * @param trackedID          The ID of the tracking object.
     * @param trackingNumbers    The array of tracking numbers associated with the tracking object.
     * @param shipmentReference  The reference ID for the shipment being tracked.
     * @param createdAt          The creation date of the tracking object.
     * @param isSubscribed       Whether or not the tracking object is subscribed to.
     */
    private Tracker(String trackedID, String[] trackingNumbers, String trackingNumber, String shipmentReference, String createdAt,
                    boolean isSubscribed) {
        this.trackerID = trackedID;
        this.trackingNumbers = trackingNumbers;
        this.shipmentReference = shipmentReference;
        this.createdAt = createdAt;
        this.isSubscribed = isSubscribed;
    }

    /**
     * Returns the creation date of the tracking object.
     *
     * @return The creation date of the tracking object.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Returns the shipment reference ID of the tracking object.
     *
     * @return The shipment reference ID of the tracking object.
     */
    public String getShipmentReference() {
        return shipmentReference;
    }

    /**
     * Returns the ID of the tracking object.
     *
     * @return The ID of the tracking object.
     */
    public String getTrackerID() {
        return trackerID;
    }

    /**
     * Returns the array of tracking numbers associated with the tracking object.
     *
     * @return The array of tracking numbers associated with the tracking object.
     */
    public String[] getTrackingNumbers() {
        return trackingNumbers;
    }

    /**
     * Returns whether or not the tracking object is subscribed to.
     *
     * @return Whether or not the tracking object is subscribed to.
     */
    public boolean isSubscribed() {
        return isSubscribed;
    }
}
