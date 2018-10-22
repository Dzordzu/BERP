package logic.identity;

import logic.place.Country;
import lombok.Getter;

/**
 * Enum of all supported IDTypes. IDType can be related with a Country
 *
 * @see Country
 */

public enum IDType {
	PESEL(Country.POLAND),
	COMPANYID()
	;
	
	private Country country;
	@Getter boolean national = false;
	
	// General ID for company
	IDType() {}

	IDType(Country country) {
		this.country = country;
		this.national = true;
	}

	public Country getCountry() {
		if(country == null) throw new Error("Type has no assigned country");
		else return country;
	}
}
