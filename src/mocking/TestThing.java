package mocking;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

public class TestThing {
	
	@Test
	public void testIsImmediateMaintenanceRequired() {
		PowerBIThingsReportService reportService = mock(PowerBIThingsReportService.class);
		
		when(reportService.getThings()).thenReturn(Arrays.asList(
				new Thing(1, "Smoke Detection", true, "high"),
				new Thing(2, "Temperature Control", true, "low"),
				new Thing(3, "Light control", true, "normal"),
				new Thing(4, "Smart Security", false, "high")));
		
		assertTrue(Thing.isImmediateMaintenanceRequired(reportService));
		verify(reportService).getThings();
	}
	
	@Test
	public void testIsMaintenanceRequired() {
		PowerBIThingsReportService reportService = mock(PowerBIThingsReportService.class);
		
		when(reportService.getThings()).thenReturn(Arrays.asList(
				new Thing(1, "Smoke Detection", true, "high"),
				new Thing(2, "Temperature Control", false, "low"),
				new Thing(3, "Light control", true, "normal"),
				new Thing(4, "Smart Security", true, "high")));
		
		assertTrue(Thing.isMaintenanceRequired(reportService));
		verify(reportService).getThings();
	}
}
