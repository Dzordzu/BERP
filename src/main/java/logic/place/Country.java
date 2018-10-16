package logic.place;

import lombok.Getter;

public enum Country {
	
	POLAND("PL", "Republic of Poland", "Poland", "Rzeczpospolita Polska", "Polska"),
	UK("UK", "United Kingdom", "England", "United Kingdom", "England")
	;
	@Getter private String shortand;
	@Getter private String fullName;
	@Getter private String name;
	@Getter private String fullLocalName;
	@Getter private String localName;
	
	private Country(String shortand, String fullName, String name, String fullLocalName, String localName) {
		this.shortand = shortand;
		this.fullName = fullName;
		this.name = name;
		this.fullLocalName = fullLocalName;
		this.localName = localName;
	}

	
	public String toString() {
		return name;
	}
	
	
}
