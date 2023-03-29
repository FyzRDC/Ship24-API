package center.fyz.ship24.api.entities;

/**
 * @Author: @FyzRDC A class representing a courier.
 */
public class Courier {

	private String courierCode, courierName, website, countryCode;
	private String[] requiredFields;
	private boolean isPost;

	/**
	 * 
	 * Constructor for Courier class.
	 * 
	 * @param courierCode    The code of the courier.
	 * @param courierName    The name of the courier.
	 * @param website        The website of the courier.
	 * @param isPost         Whether the courier is a postal service or not.
	 * @param countryCode    The country code of the courier.
	 * @param requiredFields An array of required fields for the courier.
	 */
	public Courier(String courierCode, String courierName, String website, boolean isPost, String countryCode,
			String[] requiredFields) {
		this.courierCode = courierCode;
		this.courierName = courierName;
		this.website = website;
		this.isPost = isPost;
		this.countryCode = countryCode;
		this.requiredFields = requiredFields;
	}

	/**
	 * 
	 * Getter for the country code of the courier.
	 * 
	 * @return The country code of the courier.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 
	 * Getter for the code of the courier.
	 * 
	 * @return The code of the courier.
	 */
	public String getCourierCode() {
		return courierCode;
	}

	/**
	 * 
	 * Getter for the name of the courier.
	 * 
	 * @return The name of the courier.
	 */
	public String getCourierName() {
		return courierName;
	}

	/**
	 * 
	 * Getter for the required fields of the courier.
	 * 
	 * @return An array of required fields for the courier.
	 */
	public String[] getRequiredFields() {
		return requiredFields;
	}

	/**
	 * 
	 * Getter for the website of the courier.
	 * 
	 * @return The website of the courier.
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * 
	 * Getter for whether the courier is a postal service or not.
	 * 
	 * @return True if the courier is a postal service, false otherwise.
	 */
	public boolean isPost() {
		return isPost;
	}
}