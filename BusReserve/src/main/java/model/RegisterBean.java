package model;

public class RegisterBean {
	private String place;
	private String date;
	private String HC;
	
	public RegisterBean() {}
	public RegisterBean(String place, String date, String HC) {
		this.place = place;
		this.date = date;
		this.HC = HC;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHC() {
		return HC;
	}
	public void setHC(String hC) {
		HC = hC;
	}

}
