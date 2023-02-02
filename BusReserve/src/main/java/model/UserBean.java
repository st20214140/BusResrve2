package model;

public class UserBean {
	private String userId;
	private String userName;
	private String callNumber;
	
	public UserBean(String userId) {
		this.setUserId(userId);
	}
	
	public UserBean(String userName, String callNumber) {
		this.setUserName(userName);
		this.setCallNumber(callNumber);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
}
