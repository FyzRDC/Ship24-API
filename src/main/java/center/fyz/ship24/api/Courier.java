package center.fyz.ship24.api;

public class Courier {

	private String courierCode, courierName, website, countryCode;
	private String[] requiredFields;
	private boolean isPost;

	public Courier(String courierCode, String courierName, String website, boolean isPost, String countryCode,
			String[] requiredFields) {
		this.courierCode = courierCode;
		this.courierName = courierName;
		this.website = website;
		this.isPost = isPost;
		this.countryCode = countryCode;
		this.requiredFields = requiredFields;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCourierCode() {
		return courierCode;
	}

	public String getCourierName() {
		return courierName;
	}

	public String[] getRequiredFields() {
		return requiredFields;
	}

	public String getWebsite() {
		return website;
	}

	public boolean isPost() {
		return isPost;
	}

}
