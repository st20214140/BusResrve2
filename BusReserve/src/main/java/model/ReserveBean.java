package model;

public class ReserveBean {
	private String reserveId,name,userId;
	private int peopleNum;
	
	public ReserveBean(String reserveId,String name,String userId,int peopleNum){
		this.reserveId = reserveId;
		this.name = name;
		this.userId = userId;
		this.peopleNum = peopleNum;
	}
	public String getReserveId() {
		return reserveId;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public int getPeopleNum() {
		return peopleNum;
	}
	
}
