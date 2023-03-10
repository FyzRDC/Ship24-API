package center.fyz.ship24.api;

public class Delivery {

	private String estimatedDeliveryDate, service, signedBy;

	public Delivery(String estimatedDeliveryDate, String service, String signedBy) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.service = service;
		this.signedBy = signedBy;
	}

	public String getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public String getService() {
		return service;
	}

	public String getSignedBy() {
		return signedBy;
	}

}
