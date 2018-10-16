package logic.place;

import lombok.Getter;

/**
 * Each address is immutable (as in the real world - it is impossible to change address, you can redefine it)
 */

public class Address {
	
	public Address(Country country, City city, Home home) {
		this.country = country;
		this.city = city;
		this.home = home;
	}
	
	@Getter private Country country;
	@Getter private City city;
	@Getter private Home home;

	/**
	 * @return address Address in the following form: home, city, country
	 * @see Country
	 * @see City
	 * @see Home
	 */
	public String toString() {
		return home + ", " + city + ", " + country;
	}
}
