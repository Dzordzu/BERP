package logic.identity;

import logic.DataValidator;
import logic.DataValidatorException;
import logic.place.Country;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enum of all supported IDTypes. IDType can be related with a Country
 *
 * @see Country
 */

public enum IDType implements DataValidator<String> {
	PESEL(Country.POLAND, Pattern.compile("\\d{9}")),
	COMPANYID(Pattern.compile("^\\d{2}[a-z]\\-\\d{4}$"))
	;
	
	private Country country;
	private Pattern pattern;
	@Getter boolean national = false;
	
	// General ID for company
	IDType(Pattern pattern) {
		this.pattern = pattern;
	}

	IDType(Country country, Pattern pattern) {
		this.country = country;
		this.national = true;
		this.pattern = pattern;
	}

	public Country getCountry() {
		if(country == null) throw new Error("Type has no assigned country");
		else return country;
	}

	@Override
	public void validate(String value) throws DataValidatorException {
		Matcher m = this.pattern.matcher(value);
		if(!m.matches()) throw new DataValidatorException(this.name() + " has got improper form");
	}
}
