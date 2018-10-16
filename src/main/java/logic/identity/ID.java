package logic.identity;

import lombok.Getter;

/**
 * <p> Representation of an ID. Can be bounded with any entity</p>
 * Immutable
 */

public class ID {
	@Getter private IDType type;
	@Getter private String value;
	public ID(IDType type, String value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public String toString() {
		return type + ": " + value;
	}
}
