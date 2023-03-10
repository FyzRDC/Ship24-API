package center.fyz.ship24.api;

public class Event {

	private String eventId, trackingNumber, eventTrackingNumber, status, occurrenceDatetime, order, datetime, utcOffset,
			location, sourceCode, courierCode, statusCode, statusCategory, statusMilestone;
	private boolean hasNoTime;

	private Event(String eventId, String trackingNumber, String eventTrackingNumber, String status,
			String occurrenceDatetime, String order, String datetime, boolean hasNoTime, String utcOffset,
			String location, String sourceCode, String courierCode, String statusCode, String statusCategory,
			String statusMilestone) {
		this.eventId = eventId;
		this.trackingNumber = trackingNumber;
		this.eventTrackingNumber = eventTrackingNumber;
		this.status = status;
		this.occurrenceDatetime = occurrenceDatetime;
		this.order = order;
		this.datetime = datetime;
		this.utcOffset = utcOffset;
		this.location = location;
		this.sourceCode = sourceCode;
		this.courierCode = courierCode;
		this.statusCode = statusCode;
		this.statusCategory = statusCategory;
		this.statusMilestone = statusMilestone;
		this.hasNoTime = hasNoTime;
	}

	public String getCourierCode() {
		return courierCode;
	}

	public String getDatetime() {
		return datetime;
	}

	public String getEventId() {
		return eventId;
	}

	public String getEventTrackingNumber() {
		return eventTrackingNumber;
	}

	public String getLocation() {
		return location;
	}

	public String getOccurrenceDatetime() {
		return occurrenceDatetime;
	}

	public String getOrder() {
		return order;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public String getStatus() {
		return status;
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

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getUtcOffset() {
		return utcOffset;
	}

	public boolean hasNoTime() {
		return hasNoTime;
	}

}
