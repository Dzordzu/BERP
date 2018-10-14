package api;

import business.Employee;
import business.EmployeeBuilder;
import business.jobs.JuniorDev;
import business.jobs.Manager;
import business.payment.PaymentStrategy;
import business.payment.StandardPayment;
import business.person.Person;
import business.person.PersonBuilder;
import seeder.job.EmployeeSeeder;
import valueobj.human.ID;
import valueobj.human.IDType;
import valueobj.human.NameBuilder;
import valueobj.human.Sex;
import valueobj.money.Money;
import valueobj.place.AddressBuilder;
import valueobj.place.Country;
import valueobj.time.Age;

import java.io.IOException;
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

		PaymentStrategy payment = new StandardPayment();
		payment.setGrossEmployeeSalary(new Money(2000, "PLN"));
		
		EmployeeBuilder.setId(new ID(IDType.COMPANYID, "a01-b5-90199"));
		EmployeeBuilder.setPerson(PersonBuilder.build());
		EmployeeBuilder.setJob(new Manager(payment));
		
		Employee emp1 = EmployeeBuilder.build();
		
		EmployeeBuilder.setJob(new JuniorDev(payment));
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
		
		
		
		System.out.println(emp1.getJob().getSalary().getPaymentName());
		System.out.println(emp2.getJob().getSalary().getNetEmploymentCost());
//
//
//		System.out.println(Pjoter.getName().getFullName());
//		System.out.println(Pjoter.getSex());
//		System.out.println(Pjoter.getForwardingAddress());
//		System.out.println(Pjoter.getHomeAddress());
//		System.out.println(Pjoter.getAge().getYears());
//		System.out.println(Pjoter.getId());

		List<Employee> employees = EmployeeSeeder.getInstance().getEmployees();

		for(Employee p: employees) {
			System.out.println(p.getPerson().getName().getFullName());
			System.out.println(p.getJob().getSalary().getPaymentName());
			System.out.println(p.getJob().getJobTitle());
			System.out.println((p.getPerson().getAge().getBirthDate()));
			System.out.println(p.getPerson().getHomeAddress());
			System.out.println(p.getId());
			System.out.println(p.getPerson().getSex());
			System.out.print("\n");
		}

	}
}
