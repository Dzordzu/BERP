package valueobj.place;

import lombok.Getter;

public class Address {
	
	public Address(Country country, City city, Home home) {
		this.country = country;
		this.city = city;
		this.home = home;
	}
	
	@Getter private Country country;
	@Getter private City city;
	@Getter private Home home;

	
	public String toString() {
		return home + ", " + city + ", " + country;
	}
}
