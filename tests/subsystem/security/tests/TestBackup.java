package subsystem.security.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import subsystem.security.model.Backup;

class TestBackup {
	@Test
	void testStatistics() {
		String expected = "Some nice backup statisitics";
		String actual = new Backup().getStatistics();
		assertEquals(expected, actual);
	}
}
