package subsystem.security.impl;

import subsystem.security.model.Address;
import subsystem.security.model.Person;
/**
 * 
 * Technician who is working in a subsystem
 * @author Lukas Wais
 *
 * @param <S> Different subsystem
 */
public class OnSideTechnician<S> extends Person {

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param address
	 */
	public OnSideTechnician(String firstname, String lastname, Address address) {
		super(firstname, lastname, address);
	}

	/**
	 * Changes the mode from normal to manual for the corresponding subsystem
	 * @param system
	 */
	public void switchMode(S system) {
		System.out.println("changed the mode for the system " + system);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
