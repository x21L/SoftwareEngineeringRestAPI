package subsystem.security.impl;

import java.time.LocalDateTime;
import java.util.List;

import subsystem.security.model.Person;
import subsystem.security.model.SecuritySystem;

public class SecurityScan extends SecuritySystem {

	private final LocalDateTime startTime;
	private boolean manualMode = false;
	private static final SecurityScan instance = new SecurityScan();

	private SecurityScan() {
		startTime = LocalDateTime.now();
		checkForShutdown();
	}

	public static SecurityScan getInstance() {
		return instance;
	}

	@Override
	public void startDetection() {
		startScan = System.nanoTime();
		System.out.println("Some nice scanning");

	}

	@Override
	public long stopDetection() {
		stopScan = System.nanoTime();
		return getScanDuration();

	}

	public String changeMode() {
		manualMode = true;
		return "===WARNING=== Mode is set to manual, the system will shutdown";
	}

	public SecurityInformation getInformation() {
		String mode = manualMode ? "System in manual mode" : "System is running";
		String status = "The system is running since " + startTime;
		return new SecurityInformation(mode, status, super.getTechnicians(), super.getStatistics(), super.getVersion());
	}

	private void checkForShutdown() {
		new Thread(() -> {
			if (manualMode) {
				System.out.println("System shutdown at " + LocalDateTime.now());
				System.exit(-1);
			}
		});
	}

	private final class SecurityInformation {
		private final String mode;
		private final String status;
		private final List<Person> technicians;
		private final String statistics;
		private final String version;
		
		public SecurityInformation(String mode, String status, List<Person> technicians, String statistics, String version) {
			this.mode = mode;
			this.status = status;
			this.technicians = technicians;
			this.statistics = statistics;
			this.version = version;
		}

	}
}
