package subsystem.security.impl;

import subsystem.security.model.Address;
import subsystem.security.model.Person;

public class OnSideTechnician<S extends Object> extends Person {

	public OnSideTechnician(String firstname, String lastname, Address address) {
		super(firstname, lastname, address);
	}

	public void switchMode(S system) {
		System.out.println("changed the mode for the system " + system);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
