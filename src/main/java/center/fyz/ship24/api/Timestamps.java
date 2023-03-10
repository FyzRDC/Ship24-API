package center.fyz.ship24.api;

public class Timestamps {

	private String infoReceivedDatetime, inTransitDatetime, outForDeliveryDatetime, failedAttemptDatetime,
			availableForPickupDatetime, exceptionDatetime, deliveredDatetime;

	public Timestamps(String infoReceivedDatetime, String inTransitDatetime, String outForDeliveryDatetime,
			String failedAttemptDatetime, String availableForPickupDatetime, String exceptionDatetime,
			String deliveredDatetime) {
		this.infoReceivedDatetime = infoReceivedDatetime;
		this.inTransitDatetime = inTransitDatetime;
		this.outForDeliveryDatetime = outForDeliveryDatetime;
		this.failedAttemptDatetime = failedAttemptDatetime;
		this.availableForPickupDatetime = availableForPickupDatetime;
		this.exceptionDatetime = exceptionDatetime;
		this.deliveredDatetime = deliveredDatetime;
	}

	public String getAvailableForPickupDatetime() {
		return availableForPickupDatetime;
	}

	public String getDeliveredDatetime() {
		return deliveredDatetime;
	}

	public String getExceptionDatetime() {
		return exceptionDatetime;
	}

	public String getFailedAttemptDatetime() {
		return failedAttemptDatetime;
	}

	public String getInfoReceivedDatetime() {
		return infoReceivedDatetime;
	}

	public String getInTransitDatetime() {
		return inTransitDatetime;
	}

	public String getOutForDeliveryDatetime() {
		return outForDeliveryDatetime;
	}

}
