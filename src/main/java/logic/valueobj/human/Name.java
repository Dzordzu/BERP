package logic.valueobj.human;

import java.util.Arrays;
import java.util.List;

public class Name {
	protected String firstname = null;
	protected String surname = null;
	protected List<String> middlenames = null;
	protected List<String> suffixes = null;

	
	public Name(String firstname, String surname, List<String> middlenames, List<String> suffixes) {
		this.firstname = firstname;
		this.surname = surname;
		this.middlenames = middlenames;
		this.suffixes = suffixes;
	}
	
	public Name(String firstname, String surname, List<String> middlenames, String[] suffixes) {
		this.firstname = firstname;
		this.surname = surname;
		this.middlenames = middlenames;
		this.suffixes = Arrays.asList(suffixes);
	}

	public Name setSuffixes(List<String> suffixes) {
		this.suffixes = suffixes;
		return this;
	}
	
	public Name setSuffixes(String[] suffixes) {
		this.suffixes = Arrays.asList(suffixes);
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public List<String> getMiddlenames() {
		return middlenames;
	}

	public List<String> getSuffixes() {
		return suffixes;
	}
	
	public String getFullName() {
		String fullName = "";
		if(this.suffixes != null)
			for(String suffix : this.suffixes) {
				fullName += suffix + " ";
			}
		fullName += this.firstname + " ";
		if(this.middlenames != null)
			for(String name : this.middlenames) {
				fullName += name + " ";
			}
		fullName += this.surname;
		
		return fullName;
	}
	
	public String toString() {
		//return firstname + " " + surname;
		return this.getFullName() + "\n";
	}
}
