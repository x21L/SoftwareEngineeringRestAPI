package subsystem.security.model;

public class Address {
	private final String street;
	private final String housenumber;
	private final String city;
	private final int zipcode;

	public Address(String street, String housenumber, int zipcode, String city) {
		this.street = street;
		this.housenumber = housenumber;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public String getCity() {
		return city;
	}
	
	public int getZipcode() {
		return zipcode;
	}
}
