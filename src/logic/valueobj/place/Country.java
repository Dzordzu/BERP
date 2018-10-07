package logic.valueobj.place;

public enum Country {
	
	POLAND("PL", "Republic of Poland", "Poland", "Rzeczpospolita Polska", "Polska"),
	UK("UK", "United Kingdom", "England", "United Kingdom", "England")
	;
	private String shortand;
	private String fullName;
	private String name;
	private String fullLocalName;
	private String localName;
	
	private Country(String shortand, String fullName, String name, String fullLocalName, String localName) {
		this.shortand = shortand;
		this.fullName = fullName;
		this.name = name;
		this.fullLocalName = fullLocalName;
		this.localName = localName;
	}

	public String getShortand() {
		return shortand;
	}

	public String getFullName() {
		return fullName;
	}

	public String getName() {
		return name;
	}

	public String getFullLocalName() {
		return fullLocalName;
	}

	public String getLocalName() {
		return localName;
	}
	
	public String toString() {
		return name;
	}
	
	
}
