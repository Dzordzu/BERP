package logic.valueobj.human;

public class ID {
	private IDType type;
	private String value;
	public ID(IDType type, String value) {
		this.type = type;
		this.value = value;
	}
	public IDType getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return type + ": " + value;
	}
}
