package seeder.people;

import business.person.Person;
import business.person.PersonBuilder;
import logic.identity.ID;
import logic.human.Name;
import logic.human.Sex;
import logic.place.Address;
import logic.time.Age;
import seeder.Seeder;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class PeopleSeeder implements Seeder {
    private static PeopleSeeder ourInstance;

    static {
        try {
            ourInstance = new PeopleSeeder();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PeopleSeeder getInstance() {
        return ourInstance;
    }

    List<Person> people;

    private PeopleSeeder() throws Exception {
        Vector<Person> people = new Vector<>();
        List<Age> ages = AgeFileReader.getInstance().getList();
        List<ID> ids = IDFileReader.getInstance().getList();
        List<Name> names = NamesFileReader.getInstance().getList();
        List<Sex> sexes = SexFileReader.getInstance().getList();
        List<Address> addresses = AddressFileReader.getInstance().getList();

        PersonBuilder.getInstance().clear();

        for(int i=0; i<100; i++) {
            PersonBuilder.getInstance().setAge(ages.get(i));
            PersonBuilder.getInstance().setHomeAddress(addresses.get(i));
            PersonBuilder.getInstance().setId(ids.get(i));
            PersonBuilder.getInstance().setName(names.get(i));
            PersonBuilder.getInstance().setSex(sexes.get(i));

            people.addElement(PersonBuilder.getInstance().buildAndClear());
        }

        this.people = people;

    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void seed() {}


}
