package subsystem.security.model;

import java.util.UUID;

/**
 * 
 * @author Lukas Wais
 *
 */
public abstract class Person {
	private final String firstname;
	private final String lastname;
	private final String ID;
	private final Address address;
	
	public Person(String firstname, String lastname, Address address) {
		this.firstname = firstname;
		this.lastname = lastname;
		ID = UUID.randomUUID().toString();
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getID() {
		return ID;
	}

	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return getFirstname() + " " + getLastname() + " " + getID();
	}
}
