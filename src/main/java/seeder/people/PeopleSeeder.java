package seeder.people;

import business.person.Person;
import business.person.PersonBuilder;
import logic.valueobj.human.ID;
import logic.valueobj.human.Name;
import logic.valueobj.human.Sex;
import logic.valueobj.place.Address;
import logic.valueobj.time.Age;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class PeopleSeeder {
    private static PeopleSeeder ourInstance;

    static {
        try {
            ourInstance = new PeopleSeeder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PeopleSeeder getInstance() {
        return ourInstance;
    }

    List<Person> people;

    private PeopleSeeder() throws IOException {
        Vector<Person> people = new Vector<>();
        List<Age> ages = AgeFileReader.getInstance().getList();
        List<ID> ids = IDFileReader.getInstance().getList();
        List<Name> names = NamesFileReader.getInstance().getList();
        List<Sex> sexes = SexFileReader.getInstance().getList();
        List<Address> addresses = AddressFileReader.getInstance().getList();

        PersonBuilder.clear();

        for(int i=0; i<100; i++) {
            PersonBuilder.setAge(ages.get(i));
            PersonBuilder.setHomeAddress(addresses.get(i));
            PersonBuilder.setId(ids.get(i));
            PersonBuilder.setName(names.get(i));
            PersonBuilder.setSex(sexes.get(i));

            people.addElement(PersonBuilder.buildAndClear());
        }

        this.people = (List<Person>) people;

    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void seed() {}


}
