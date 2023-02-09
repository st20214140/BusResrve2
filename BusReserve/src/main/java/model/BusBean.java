package model;

public class BusBean {
	private String busId;
	private String startPlace,goalPlace;
	private String startTime,goalTime;
	
	public BusBean(String busId,String startPlace,String goalPlace,String startTime,String goalTime){
		this.busId = busId;
		this.startPlace = startPlace;
		this.goalPlace = goalPlace;
		this.startTime = startTime;
		this.goalTime = goalTime;
	}

	public String getBusId() {
		return busId;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public String getGoalPlace() {
		return goalPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getGoalTime() {
		return goalTime;
	}
}
