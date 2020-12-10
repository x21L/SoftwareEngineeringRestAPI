package subsystem.security.impl;

import subsystem.security.model.SecuritySystem;

public class SecurityScan extends SecuritySystem {

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
}
