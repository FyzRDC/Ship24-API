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

	public Event[] getEvents() {
		return events;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public Tracker getTracker() {
		return tracker;
	}

}
