package business.person;

import valueobj.human.ID;
import valueobj.human.Name;
import valueobj.human.Sex;
import valueobj.place.Address;
import valueobj.time.Age;

public class PersonBuilder {
	private static ID id;
	private static Sex sex;
	private static Age age;
	private static Name name;
	private static Address homeAddress;
	private static Address forwardingAddress;
	
	
	
	public static void setId(ID id) {
		PersonBuilder.id = id;
	}


	public static void setSex(Sex sex) {
		PersonBuilder.sex = sex;
	}


	public static void setAge(Age age) {
		PersonBuilder.age = age;
	}


	public static void setName(Name name) {
		PersonBuilder.name = name;
	}


	public static void setHomeAddress(Address homeAddress) {
		PersonBuilder.homeAddress = homeAddress;
	}


	public static void setForwardingAddress(Address forwardingAddress) {
		PersonBuilder.forwardingAddress = forwardingAddress;
	}


	public static void clear() {
		id = null;
		sex = null;
		age = null;
		name = null;
		homeAddress = null;
		forwardingAddress = null;
	}


	public static Person build() {
		return new Person(id, sex, age, name, homeAddress, forwardingAddress);
	}
	
	public static Person buildAndClear() {
		Person result = build();
		clear();
		return result;
	}
}
