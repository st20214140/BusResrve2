package model;

public class PriceBean {
	private String price_id;
	private int price;
	
	public PriceBean(String price_id,int price) {
		setPrice_id(price_id);
		setPrice(price);
	}
	public String getPrice_id() {
		return price_id;
	}
	public void setPrice_id(String price_id) {
		this.price_id = price_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
