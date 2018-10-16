package business.person;

import logic.Builder;
import logic.identity.ID;
import logic.human.Name;
import logic.human.Sex;
import logic.place.Address;
import logic.time.Age;
import lombok.Setter;

public class PersonBuilder implements Builder<Person> {

	private static PersonBuilder ourInstance = new PersonBuilder();
	public static PersonBuilder getInstance() {
		return ourInstance;
	}
	private PersonBuilder() {}
	
	@Setter private ID id;
	@Setter private Sex sex;
	@Setter private Age age;
	@Setter private Name name;
	@Setter private Address homeAddress;
	@Setter private Address forwardingAddress;


	public void setForwardingAddress(Address forwardingAddress) {
		this.forwardingAddress = forwardingAddress;
	}
	
	public void clear() {
		id = null;
		sex = null;
		age = null;
		name = null;
		homeAddress = null;
		forwardingAddress = null;
	}


	public Person build() {
		return new Person(id, sex, age, name, homeAddress, forwardingAddress);
	}
	
	public Person buildAndClear() {
		Person result = build();
		clear();
		return result;
	}
}
