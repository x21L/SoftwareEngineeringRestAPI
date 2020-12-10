package subsystem.security.impl;

import java.util.ArrayList;
import java.util.List;

import subsystem.security.model.Address;
import subsystem.security.model.Person;

public class Programmer<S extends Object> extends Person {
	private final List<S> subsystems;

	public Programmer(String firstname, String lastname, Address address) {
		super(firstname, lastname, address);
		subsystems = new ArrayList<>();
	}

	public boolean addSubsystem(S system) {
		if (system == null) {
			throw new NullPointerException("The system must not be null;");
		}
		return subsystems.add(system);
	}

	public List<S> getSubsystems() {
		return subsystems;
	}

	@Override
	public String toString() {
		return super.toString() + subsystems;
	}

}
