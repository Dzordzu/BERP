package logic.valueobj.place;

import lombok.Getter;

public class Home {
	@Getter private String number;
	@Getter private String streetNumber;
	@Getter private String postalCode;
	@Getter private String street;
	
	public Home(String number, String streetNumber, String postalCode, String street) {
		this.number = number;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.street = street;
	}
	
	
	public String toString() {
		return street + " " + streetNumber + "/" + number + ", " + postalCode;
	}
}
