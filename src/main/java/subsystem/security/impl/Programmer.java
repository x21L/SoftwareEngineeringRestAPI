package subsystem.security.impl;

import java.util.ArrayList;
import java.util.List;

import subsystem.security.model.Address;
import subsystem.security.model.Person;
/**
 * 
 * Subsystem of the subsystems
 * @author Lukas Wais
 *
 * @param <S> different subsystems
 */
public class Programmer<S> extends Person {
	private final List<S> subsystems;

	public Programmer(String firstname, String lastname, Address address) {
		super(firstname, lastname, address);
		subsystems = new ArrayList<>();
	}

	/**
	 * 
	 * Insert a new subsystem for the programmer to get access to.
	 * 
	 * @param New subsystem
	 * @return true if insert was successful
	 */
	public boolean addSubsystem(S system) {
		if (system == null) {
			throw new NullPointerException("The system must not be null;");
		}
		return subsystems.add(system);
	}

	/**
	 * 
	 * @return all subsystems of the programmer
	 */
	public List<S> getSubsystems() {
		return subsystems;
	}

	@Override
	public String toString() {
		return super.toString() + subsystems;
	}

}
