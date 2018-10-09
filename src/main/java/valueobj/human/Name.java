package valueobj.human;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Name {
	@Getter protected String firstname = null;
	@Getter protected String surname = null;
	@Getter protected List<String> middlenames = null;
	@Getter protected List<String> suffixes = null;

	
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
		return firstname + " " + surname;
	}
}
