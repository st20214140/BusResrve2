package model;

 

public class Bus_ReserveBean {
    private String flightNumber;
    private String userId;
    private String seatNumber;
    private String priceId;
    
    public Bus_ReserveBean(String flightNumber, String userId, String seatNumber, String priceId) {
        this.flightNumber = flightNumber;
        this.userId = userId;
        this.seatNumber = seatNumber;
        this.priceId = priceId;
    }
    
    public Bus_ReserveBean(String seatNumber) {
    	this.seatNumber = seatNumber;
    }
    
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getPriceId() {
        return priceId;
    }
    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }
}