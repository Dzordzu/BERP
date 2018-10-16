package logic.human;


import logic.Builder;

import java.util.Arrays;
import java.util.List;

public class NameBuilder implements Builder<Name> {
	private static NameBuilder ourInstance = new NameBuilder();
	public static NameBuilder getInstance() {
		return ourInstance;
	}
	private NameBuilder() {}

	protected String firstname = null;
	protected String surname = null;
	protected List<String> middlenames = null;
	protected List<String> suffixes = null;

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setMiddlenames(List<String> middlenames) {
		this.middlenames = middlenames;
	}
	public void setMiddlenames(String[] middlenames) {
		this.middlenames = Arrays.asList(middlenames);
	}
	public void setSuffixes(List<String> suffixes) {
		this.suffixes = suffixes;
	}
	public void setSuffixes(String[] suffixes) {
		this.suffixes = Arrays.asList(suffixes);
	}

	public void clear() {
		firstname = null;
		surname = null;
		middlenames = null;
		suffixes = null;
	}


	public Name build() {
		return new Name(firstname, surname, middlenames, suffixes);
	}

	public Name buildAndClear() {
		Name result = build();
		clear();
		return result;
	}


}
