package logic.place;

import lombok.Getter;

public class City {
	@Getter private String name;
	@Getter private String region;
	
	public City(String name, String region) {
		this.name = name;
		this.region = region;
	}

	
	public String toString() {
		return name + ", " + region;
	}
}
