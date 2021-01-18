package subsystem.security.impl;

import java.time.LocalDateTime;
import java.util.List;

import subsystem.security.model.Person;
import subsystem.security.model.SecuritySystem;

/**
 * Security scan of the system. Singleton pattern.
 * @author Lukas Wais
 *
 */
public class SecurityScan extends SecuritySystem {

	private final LocalDateTime startTime;
	private boolean manualMode = false;
	private static final SecurityScan instance = new SecurityScan();

	private SecurityScan() {
		startTime = LocalDateTime.now();
		checkForShutdown();
	}

	/**
	 * 
	 * @return an instance of the scan
	 */
	public static SecurityScan getInstance() {
		return instance;
	}

	/**
	 * starts the detection
	 */
	@Override
	public String startDetection() {
		startScan = System.nanoTime();
		return "Some nice scanning";

	}

	/**
	 * stops the scan
	 * 
	 * @return scan duration in seconds
	 */
	@Override
	public String stopDetection() {
		stopScan = System.nanoTime();
		return "Scan stoped it took " + (getScanDuration() * 0.001) + " s";

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

	public final class SecurityInformation {
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

		@Override
		public String toString() {
			return "SecurityInformation [mode=" + mode + ", status=" + status + ", technicians=" + technicians
					+ ", statistics=" + statistics + ", version=" + version + "]";
		}
	}
}
