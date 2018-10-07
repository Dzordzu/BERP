package logic.valueobj.place;

public class City {
	private String name;
	private String region;
	
	public City(String name, String region) {
		this.name = name;
		this.region = region;
	}
	
	public String getName() {
		return name;
	}
	public String getRegion() {
		return region;
	}
	
	public String toString() {
		return name + ", " + region;
	}
}
