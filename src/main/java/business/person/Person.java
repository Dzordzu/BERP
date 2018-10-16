package business.person;
import logic.identity.ID;
import logic.human.Name;
import logic.human.Sex;
import logic.place.Address;
import logic.time.Age;
import lombok.Getter;

public class Person {

	@Getter private ID id;
	@Getter private Sex sex;
	@Getter private Age age;
	@Getter private Name name;
	@Getter private Address homeAddress;
	private Address forwardingAddress;
	@Getter private boolean usingForwardingAddress = true;

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

	
	public Address getForwardingAddress() {
		if(this.usingForwardingAddress) return forwardingAddress;
		else return this.homeAddress;
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
