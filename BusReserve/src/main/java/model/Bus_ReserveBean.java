package model;

public class Bus_ReserveBean {
	private int flight_number;
	private String user_id;
	private String seat_number;
	private int reserved_flag;
	private String price_id;
	
	public Bus_ReserveBean(int flight_number, String user_id, String seat_number, int reserved_flag, String price_id) {
		this.flight_number = flight_number;
		this.user_id = user_id;
		this.seat_number = seat_number;
		this.reserved_flag = reserved_flag;
		this.price_id = price_id;
	}
	
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public int getReserved_flag() {
		return reserved_flag;
	}
	public void setReserved_flag(int reserved_flag) {
		this.reserved_flag = reserved_flag;
	}
	public String getPrice_id() {
		return price_id;
	}
	public void setPrice_id(String price_id) {
		this.price_id = price_id;
	}


}
