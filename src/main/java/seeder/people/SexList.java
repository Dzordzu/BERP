package seeder.people;

public class SexList {
    private static SexList ourInstance = new SexList();

    public static SexList getInstance() {
        return ourInstance;
    }

    private SexList() {
        super("/seeders/sexlist.json");
    }
}
