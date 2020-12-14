package subsystem.security.model;

import java.util.ArrayList;
import java.util.List;

import subsystem.security.impl.OnSideTechnician;

public abstract class SecuritySystem {

	private String version = "0.1 alpha";
	private final Backup backup;
	private final List<Person> technicians;
	protected long startScan, stopScan;
	
	public SecuritySystem() {
		technicians = new ArrayList<>();
		backup = new Backup();
		setUp();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public long getScanDuration() {
		return stopScan - startScan;
	}
	
	public Backup getBackup() {
		return backup;
	}
	
	public String securityAlarm() {
		return "Alarm is triggered";
	}
	
	public String getStatistics() {
		return "some nice stats" + backup.getStatistics();
	}
		
	public boolean addTechnician(OnSideTechnician<?> t) {
		if (t == null) {
			throw new NullPointerException("The technician must not be null;");
		}
		return technicians.add(t);
	}
	
	public List<Person> getTechnicians() {
		return technicians;
	}
	
	public abstract String startDetection();
	
	public abstract String stopDetection();
	
	/*
	 * simple setup for the demo
	 */
	private void setUp() {
		Person karl = new OnSideTechnician<Object>("Karl", "Heinz", new Address("a", "b1", 1, "aa"));
		Person alf = new OnSideTechnician<Object>("Alf", "Tenner", new Address("Home planet", "1", Integer.MAX_VALUE, "Melmark"));
		Person susan = new OnSideTechnician<Object>("Susan", "Smith", new Address("S Sunset Ave", "A1", 88202, "Roswell"));
		technicians.add(karl);
		technicians.add(alf);
		technicians.add(susan);
	}
}
