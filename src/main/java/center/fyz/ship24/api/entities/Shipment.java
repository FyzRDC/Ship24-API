/**
 * The Shipment class represents a shipment and its associated information,
 * such as the shipment ID, status, origin and destination country codes,
 * delivery information, tracking numbers, and recipient information.
 *
 * @author @FyzRDC
 */
package center.fyz.ship24.api.entities;

import java.util.List;

public class Shipment {

	// Declare instance variables for a shipment object
	private String shipmentId, statusCode, statusCategory, statusMilestone, originCountryCode, destinationCountryCode;
	private Delivery delivery;
	private List<TrackingNumber> trackingNumbers;

	/**
	 * Constructor for the Shipment class.
	 *
	 * @param shipmentId            the shipment ID
	 * @param statusCode           the shipment status code
	 * @param statusCategory       the shipment status category
	 * @param statusMilestone      the shipment status milestone
	 * @param originCountryCode    the origin country code
	 * @param destinationCountryCode the destination country code
	 * @param delivery             the delivery information
	 * @param trackingNumbers      a list of tracking numbers
	 * @param recipient            the recipient information
	 */
	public Shipment(String shipmentId, String statusCode, String statusCategory, String statusMilestone,
			String originCountryCode, String destinationCountryCode, Delivery delivery,
			List<TrackingNumber> trackingNumbers, Recipient recipient) {
		this.shipmentId = shipmentId;
		this.statusCode = statusCode;
		this.statusCategory = statusCategory;
		this.statusMilestone = statusMilestone;
		this.originCountryCode = originCountryCode;
		this.destinationCountryCode = destinationCountryCode;
		this.delivery = delivery;
		this.trackingNumbers = trackingNumbers;
	}

	/**
	 * Returns the delivery information for the shipment.
	 *
	 * @return the delivery information
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * Returns the destination country code for the shipment.
	 *
	 * @return the destination country code
	 */
	public String getDestinationCountryCode() {
		return destinationCountryCode;
	}

	/**
	 * Returns the origin country code for the shipment.
	 *
	 * @return the origin country code
	 */
	public String getOriginCountryCode() {
		return originCountryCode;
	}

	/**
	 * Returns the shipment ID for the shipment.
	 *
	 * @return the shipment ID
	 */
	public String getShipmentId() {
		return shipmentId;
	}

	/**
	 * Returns the status category for the shipment.
	 *
	 * @return the status category
	 */
	public String getStatusCategory() {
		return statusCategory;
	}

	/**
	 * Returns the shipment status code for the shipment.
	 *
	 * @return the shipment status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Returns the shipment status milestone for the shipment.
	 *
	 * @return the shipment status milestone
	 */
	public String getStatusMilestone() {
		return statusMilestone;
	}

	/**
	 * Returns a list of tracking numbers for the shipment.
	 *
	 * @return a list of tracking numbers
	 */
	public List<TrackingNumber> getTrackingNumbers() {
		return trackingNumbers;
	}

}
