package subsystem.security.model;

public class Address {
	private final String street;
	private final String housenumber;
	private final String city;

	public Address(String street, String housenumber, String city) {
		this.street = street;
		this.housenumber = housenumber;
		this.city = city;
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
}
