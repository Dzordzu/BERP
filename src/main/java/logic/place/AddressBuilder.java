package logic.place;

import logic.Builder;
import lombok.Setter;

public class AddressBuilder implements Builder<Address> {
	private static AddressBuilder ourInstance = new AddressBuilder();
	public static AddressBuilder getInstance() {
		return ourInstance;
	}
	private AddressBuilder() {}
	
	@Setter private String homeNumber;
	@Setter private String streetNumber;
	@Setter private String postalCode;
	@Setter private String street;
	@Setter private String cityName;
	@Setter private String region;
	@Setter private Country country;

	public void clear() {
		homeNumber = null;
		streetNumber = null;
		postalCode = null;
		street = null;
		cityName = null;
		region = null;
		country = null;
		System.out.println("CLEAR");
	}
	
	public boolean isComplete() {
		return (streetNumber != null 
				&& postalCode != null 
				&& street != null 
				&& cityName != null 
				&& region != null 
				&& country != null);
	}


	public Address build() {
		Home home = new Home(homeNumber, streetNumber, postalCode, street);
		City city = new City(cityName, region);
		
		if(isComplete()) return new Address(country, city, home);
		else {
			throw new Error("Address is not complete");
		}
	}
	
	
	public Address buildAndClear() {
		Address result = build();
		clear();
		return result;
	}
}
