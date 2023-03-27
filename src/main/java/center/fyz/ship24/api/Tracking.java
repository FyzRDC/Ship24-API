/**
 * @author @FyzRDC
 * 
 * This class represents a tracking result containing information about the tracking, shipment, events, and statistics.
 */
package center.fyz.ship24.api;

public class Tracking {

	private Tracker tracker;
	private Shipment shipment;
	private Event[] events;
	private Statistics statistics;

	private Tracking(Tracker tracker, Shipment shipment, Event[] events, Statistics statistics) {
		this.tracker = tracker;
		this.shipment = shipment;
		this.events = events;
		this.statistics = statistics;
	}

	/**
	 * Returns the events associated with the tracking.
	 * 
	 * @return an array of Event objects
	 */
	public Event[] getEvents() {
		return events;
	}

	/**
	 * Returns the shipment associated with the tracking.
	 * 
	 * @return a Shipment object
	 */
	public Shipment getShipment() {
		return shipment;
	}

	/**
	 * Returns the statistics associated with the tracking.
	 * 
	 * @return a Statistics object
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * Returns the tracker associated with the tracking.
	 * 
	 * @return a Tracker object
	 */
	public Tracker getTracker() {
		return tracker;
	}

}
