package logic.valueobj.place;

public class AddressBuilder {
	
	private static String homeNumber = null;
	private static String streetNumber = null;
	private static String postalCode = null;
	private static String street = null;
	private static String cityName = null;
	private static String region = null;
	private static Country country = null;
	
	
	public static void setHomeNumber(String homeNumber) {
		AddressBuilder.homeNumber = homeNumber;
	}


	public static void setStreetNumber(String streetNumber) {
		AddressBuilder.streetNumber = streetNumber;
	}


	public static void setPostalCode(String postalCode) {
		AddressBuilder.postalCode = postalCode;
	}


	public static void setStreet(String street) {
		AddressBuilder.street = street;
	}


	public static void setCityName(String cityName) {
		AddressBuilder.cityName = cityName;
	}


	public static void setRegion(String region) {
		AddressBuilder.region = region;
	}


	public static void setCountry(Country country) {
		AddressBuilder.country = country;
	}


	public static void clear() {
		homeNumber = null;
		streetNumber = null;
		postalCode = null;
		street = null;
		cityName = null;
		region = null;
		country = null;
	}
	
	public static boolean isComplete() {
		return (streetNumber != null 
				&& postalCode != null 
				&& street != null 
				&& cityName != null 
				&& region != null 
				&& country != null);
	}


	public static Address build() {
		Home home = new Home(homeNumber, streetNumber, postalCode, street);
		City city = new City(cityName, region);
		
		if(isComplete()) return new Address(country, city, home);
		else {
			throw new Error("Address is not complete");
		}
	}
	
	
	public static Address buildAndClear() {
		Address result = build();
		clear();
		return result;
	}
}
