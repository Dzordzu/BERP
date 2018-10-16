package logic.human;

import logic.place.Country;

public enum IDType {
	PESEL(Country.POLAND),
	COMPANYID()
	;
	
	private Country country;
	
	// General ID for company
	IDType() {}

	IDType(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		if(country == null) throw new Error("Type has no assigned country");
		else return country;
	}
}
