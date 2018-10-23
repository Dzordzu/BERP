package logic.human;

import logic.DataValidatorException;

/**
 * TODO - change to enum
 */


public enum Sex {
	Male("male"),
	Female("female")
	;
	
	protected String sex;
	
	Sex(String sex) {
		this.sex = sex.toLowerCase();
	}
	
	public boolean isMale() {
		return this.sex == "male";
	}
	public boolean isFemale() {
		return this.sex == "female";
	}

	public static Sex get(String sex) throws DataValidatorException {
		sex = sex.toLowerCase();

		for(Sex s: Sex.values()) {
			if(s.toString().equals(sex)) return s;
		}

		throw new DataValidatorException("There is no such a sex: " + sex);
	}
	
	public String toString() {
		return this.sex;
	}
}
