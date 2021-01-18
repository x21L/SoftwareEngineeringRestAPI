package subsystem.security.tests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import subsystem.security.impl.SecurityScan;

public class SecurityScanTest {

	@Test
	public void testChangeMode() {
		String actual = SecurityScan.getInstance().changeMode();
		String expected = "===WARNING=== Mode is set to manual, the system will shutdown";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStartDetection() {
		String actual = SecurityScan.getInstance().startDetection();
		String expected = "Some nice scanning";
		assertEquals(expected, actual);
	}

	@Test
	public void testGetInformation() {
		SecurityScan.SecurityInformation actual = SecurityScan.getInstance().getInformation();
		System.out.println("This is a visual test \n" + actual);
	}
}
