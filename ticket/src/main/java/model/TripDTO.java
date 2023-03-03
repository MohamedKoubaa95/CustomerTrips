package model;

import java.math.BigDecimal;

public class TripDTO {
	private int startZone;
	private int endZone;
	private int price;
	
	public TripDTO(int startZone, int endZone, int price) {
		this.startZone = startZone;
		this.endZone = endZone;
		this.price = price;
	}
	
	
	public int getStartZone() {
		return startZone;
	}




	public int getEndZone() {
		return endZone;
	}




	public int getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "TripDTO [startZone=" + startZone + ", endZone=" + endZone + ", price=" + price + "]";
	}





	
	
}
