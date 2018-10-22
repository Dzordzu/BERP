package logic.human;

import lombok.Getter;

import java.util.List;

/**
 * Represents name of the person<br />
 * Has own builder (NameBuilder)
 * @see NameBuilder
 */

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

	/**
	 * Chainable setter of the suffixes
	 * @param suffixes
	 * @return
	 */
	public Name setSuffixes(List<String> suffixes) {
		this.suffixes = suffixes;
		return this;
	}

	/**
	 * @return fullName String that contains all the data of the name. Includes:
	 * <ol>
     *   <li>suffixes</li>
     *   <li>firstname</li>
     *   <li>middlenames</li>
     *   <li>surname</li>
	 * </ol>
	 */
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

    /**
     * @return name String consisted of name and surname
     */
	@Override
	public String toString() {
		return firstname + " " + surname;
	}
}
