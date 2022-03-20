package mocking;

public class Thing {
	
	private int thingId;
	private String name;
	private boolean active;
	private String priority;
	
	
	public Thing(int thingId, String name, boolean active, String priority) {
		this.thingId = thingId;
		this.name = name;
		this.active = active;
		this.priority = priority;
	}

	public int getThingId() {
		return thingId;
	}
	
	public void setThingId(int machineId) {
		this.thingId = thingId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public static boolean isImmediateMaintenanceRequired(PowerBIThingsReportService reportService) {
		for(Thing eachThing: reportService.getThings()) {
			if(!eachThing.isActive() && eachThing.getPriority().equalsIgnoreCase("high"))
				return true;
		}
		return false;
	}
	
	public static boolean isMaintenanceRequired(PowerBIThingsReportService reportService) {
		for(Thing eachThing: reportService.getThings()) {
			if(!eachThing.isActive())
				return true;
		}
		return false;
	}
	
	
}
