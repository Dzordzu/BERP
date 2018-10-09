package valueobj.human;

public class Sex {
	
	protected String sex;
	
	public Sex(String sex) {
		sex = sex.toLowerCase();
		switch(sex) {
			case "male": 
				this.sex = "male";
				break;
			case "female":
				this.sex = "female";
				break;
			default:
				throw new Error("There is no such a sex");
		}
	}
	
	public boolean isMale() {
		return this.sex == "male";
	}
	public boolean isFemale() {
		return this.sex == "female";
	}
	
	public String toString() {
		return this.sex;
	}
}
