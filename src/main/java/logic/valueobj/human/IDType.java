package logic.valueobj.human;

import logic.valueobj.place.Country;

public enum IDType {
	PESEL(Country.POLAND),
	COMPANYID()
	;
	
	private Country country;
	
	// General ID for company
	private IDType() {
		
	}

	private IDType(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		if(country == null) throw new Error("Type has no assigned country");
		else return country;
	}
}
