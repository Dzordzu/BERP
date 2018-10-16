package logic.place;

import lombok.Getter;

/**
 * Home object is immutable (as the physical home address). If you want to have a new one you have to redefine it
 */

public class Home {
	@Getter private String homeNumber;
	@Getter private String streetNumber;
	@Getter private String postalCode;
	@Getter private String street;
	
	public Home(String number, String streetNumber, String postalCode, String street) {
		this.homeNumber = number;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.street = street;
	}

	/**
	 * @return home In the following form: street, streetNumber/homeNumber, postalCode
	 */
	public String toString() {
		return street + " " + streetNumber + "/" + homeNumber + ", " + postalCode;
	}
}
