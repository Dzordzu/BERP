package logic.valueobj.place;

public class Address {
	
	public Address(Country country, City city, Home home) {
		this.country = country;
		this.city = city;
		this.home = home;
	}
	
	private Country country;
	private City city;
	private Home home;
	
	public Country getCountry() {
		return country;
	}
	public City getCity() {
		return city;
	}
	public Home getHome() {
		return home;
	}
	
	public String toString() {
		return home + ", " + city + ", " + country;
	}
}
