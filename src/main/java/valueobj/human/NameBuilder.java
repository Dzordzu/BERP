package valueobj.human;

import java.util.Arrays;
import java.util.List;

public class NameBuilder {
	protected static String firstname = null;
	protected static String surname = null;
	protected static List<String> middlenames = null;
	protected static List<String> suffixes = null;
	
	public static void setFirstname(String firstname) {
		NameBuilder.firstname = firstname;
	}
	public static void setSurname(String surname) {
		NameBuilder.surname = surname;
	}
	public static void setMiddlenames(List<String> middlenames) {
		NameBuilder.middlenames = middlenames;
	}
	public static void setMiddlenames(String[] middlenames) {
		NameBuilder.middlenames = Arrays.asList(middlenames);
	}
	public static void setSuffixes(List<String> suffixes) {
		NameBuilder.suffixes = suffixes;
	}
	public static void setSuffixes(String[] suffixes) {
		NameBuilder.suffixes = Arrays.asList(suffixes);
	}
	
	public static void clear() {
		firstname = null;
		surname = null;
		middlenames = null;
		suffixes = null;
	}


	public static Name build() {
		return new Name(firstname, surname, middlenames, suffixes);
	}
	
	public static Name buildAndClear() {
		Name result = build();
		clear();
		return result;
	}
	
	
}
