package logic.human;

import lombok.Getter;

public class ID {
	@Getter private IDType type;
	@Getter private String value;
	public ID(IDType type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public String toString() {
		return type + ": " + value;
	}
}
