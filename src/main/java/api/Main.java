package api;

import business.Employee;
import business.EmployeeBuilder;
import business.jobs.JuniorDev;
import business.jobs.Manager;
import business.person.Person;
import business.person.PersonBuilder;
import seeder.people.*;
import logic.valueobj.human.ID;
import logic.valueobj.human.IDType;
import logic.valueobj.human.NameBuilder;
import logic.valueobj.human.Sex;
import logic.valueobj.money.Money;
import logic.valueobj.place.AddressBuilder;
import logic.valueobj.place.Country;
import logic.valueobj.time.Age;

import java.io.IOException;
import java.util.Currency;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		
		AddressBuilder.clear();
		AddressBuilder.setCountry(Country.POLAND);
		AddressBuilder.setCityName("Wroclaw");
		AddressBuilder.setHomeNumber("2");
		AddressBuilder.setRegion("Dolnoslaskie");
		AddressBuilder.setStreet("HUJA WSIEGO");
		AddressBuilder.setStreetNumber("4");
		AddressBuilder.setPostalCode("58-543");
		
		NameBuilder.clear();
		NameBuilder.setFirstname("Jerzy");
		NameBuilder.setSurname("Pietraszko");
		NameBuilder.setMiddlenames(new String[] {"John", "Pablo"});
		NameBuilder.setSuffixes(new String[] {"mgr.", "inż."});
		
		PersonBuilder.clear();
		PersonBuilder.setId(new ID(IDType.PESEL, "9906"));
		PersonBuilder.setAge(new Age("1954-12-21"));
		PersonBuilder.setSex(new Sex("male"));
		PersonBuilder.setName(NameBuilder.buildAndClear());
		PersonBuilder.setHomeAddress(AddressBuilder.buildAndClear());
		
		EmployeeBuilder.setId(new ID(IDType.COMPANYID, "a01-b5-90199"));
		EmployeeBuilder.setPerson(PersonBuilder.build());
		EmployeeBuilder.setJob(new Manager(new Money(2000, Currency.getInstance("PLN"))));
		
		Employee emp1 = EmployeeBuilder.build();
		
		EmployeeBuilder.setJob(new JuniorDev(new Money(20, Currency.getInstance("PLN"))));
		Employee emp2 = EmployeeBuilder.buildAndClear();
		
		
		Person Pjoter = PersonBuilder.buildAndClear();
		Pjoter.getName().setSuffixes(new String[] {"dr", "mgr.", "inż."});
		
		AddressBuilder.setCountry(Country.UK);
		AddressBuilder.setCityName("Pablowice");
		AddressBuilder.setRegion("Zadupie");
		AddressBuilder.setHomeNumber("12");
		AddressBuilder.setPostalCode("20-876");
		AddressBuilder.setStreet("Dupna");
		AddressBuilder.setStreetNumber("45");
		
		Pjoter.setForwardingAddress(AddressBuilder.build());
		
		
		
//		System.out.println(emp1.getJob());
//		System.out.println(emp2.getJob());
//
//
//		System.out.println(Pjoter.getName().getFullName());
//		System.out.println(Pjoter.getSex());
//		System.out.println(Pjoter.getForwardingAddress());
//		System.out.println(Pjoter.getHomeAddress());
//		System.out.println(Pjoter.getAge().getYears());
//		System.out.println(Pjoter.getId());

		List<Person> people = PeopleSeeder.getInstance().getPeople();

		for(Person p: people) {
			System.out.println(p.getName());
			System.out.println((p.getAge().getBirthDate()));
			System.out.println(p.getHomeAddress());
			System.out.println(p.getId());
			System.out.println(p.getSex());
			System.out.print("\n");
		}

	}
}
