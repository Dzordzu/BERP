package logic.place;

import lombok.Getter;

/**
 * Immutable. As the normal City. Is it normal to frequently rename cities? If so everything that contained
 * city name has to changed.
 */

public class City {
	@Getter private String name;
	@Getter private String region;
	
	public City(String name, String region) {
		this.name = name;
		this.region = region;
	}

	/**
	 * @return city In the following form: name, region
	 */
	public String toString() {
		return name + ", " + region;
	}
}
