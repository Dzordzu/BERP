package logic.human;


import logic.Builder;
import lombok.Setter;

import java.util.List;

public class NameBuilder implements Builder<Name> {
	private static NameBuilder ourInstance = new NameBuilder();
	public static NameBuilder getInstance() {
		return ourInstance;
	}
	private NameBuilder() {}

	@Setter protected String firstname = null;
	@Setter protected String surname = null;
	@Setter protected List<String> middlenames = null;
	@Setter protected List<String> suffixes = null;

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
