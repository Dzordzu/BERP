package business.person;
import logic.valueobj.human.ID;
import logic.valueobj.human.Name;
import logic.valueobj.human.Sex;
import logic.valueobj.place.Address;
import logic.valueobj.time.Age;

public class Person {

	private ID id;
	private Sex sex;
	private Age age;
	private Name name;
	private Address homeAddress;
	private Address forwardingAddress;
	private boolean usingForwardingAddress = true;

	public Person(ID id, Sex sex, Age age, Name name, Address homeAddress, Address forwardingAddress) {
		this.id = id;
		this.sex = sex;
		this.age = age;
		this.name = name;
		this.homeAddress = homeAddress;
		this.setForwardingAddress(forwardingAddress);
	}
	
	

	public Person(ID id, Sex sex, Age age, Name name, Address homeAddress) {
		this.id = id;
		this.sex = sex;
		this.age = age;
		this.name = name;
		this.homeAddress = homeAddress;
		this.setForwardingAddress(null);
	}



	public ID getId() {
		return id;
	}

	public Sex getSex() {
		return sex;
	}

	public Age getAge() {
		return age;
	}
	
	public Address getForwardingAddress() {
		if(this.usingForwardingAddress) return forwardingAddress;
		else return this.homeAddress;
	}

	public Name getName() {
		return name;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public boolean isUsingForwardingAddress() {
		return usingForwardingAddress;
	}
	
	public void setForwardingAddress(Address forwardingAddress) {
		this.forwardingAddress = forwardingAddress;
		if(forwardingAddress != null) {
			this.usingForwardingAddress = true;
		}
		else {
			this.usingForwardingAddress = false;
		}
	}
}
