package logic.valueobj.place;

public class Home {
	private String number;
	private String streetNumber;
	private String postalCode;
	private String street;
	
	public Home(String number, String streetNumber, String postalCode, String street) {
		this.number = number;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getStreet() {
		return street;
	}
	
	public String toString() {
		return street + " " + streetNumber + "/" + number + ", " + postalCode;
	}
}
