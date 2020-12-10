package subsystem.security.model;

import java.util.ArrayList;
import java.util.List;

import subsystem.security.impl.OnSideTechnician;

public abstract class SecuritySystem {

	private String version;
	private final Backup backup;
	private final List<Person> technicians;
	protected long startScan, stopScan;
	
	public SecuritySystem() {
		technicians = new ArrayList<>();
		backup = new Backup();
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
		
	public boolean addTechnician(OnSideTechnician<Object> t) {
		if (t == null) {
			throw new NullPointerException("The technician must not be null;");
		}
		return technicians.add(t);
	}
	
	public List<Person> getTechnicians() {
		return technicians;
	}
	
	public abstract void startDetection();
	
	public abstract long stopDetection();
}
