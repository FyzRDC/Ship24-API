/**
 * @author FyzRDC
 */

package center.fyz.ship24.api.entities;

public class Recipient {
    
    // Define instance variables
	private String name, adress, postCode, city, subdivision;
	
	// Constructor method to initialize the instance variables
	public Recipient(String name, String adress, String postCode, String city, String subdivision) {
		this.name = name;
		this.adress = adress;
		this.postCode = postCode;
		this.city = city;
		this.subdivision = subdivision;
	}
	
	// Getter method for the 'adress' instance variable
	public String getAdress() {
		return adress;
	}
	
	// Getter method for the 'city' instance variable
	public String getCity() {
		return city;
	}
	
	// Getter method for the 'name' instance variable
	public String getName() {
		return name;
	}
	
	// Getter method for the 'postCode' instance variable
	public String getPostCode() {
		return postCode;
	}
	
	// Getter method for the 'subdivision' instance variable
	public String getSubdivision() {
		return subdivision;
	}
}
