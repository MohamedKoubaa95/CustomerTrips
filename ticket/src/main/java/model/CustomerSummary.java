package model;

import java.util.List;

public class CustomerSummary {


	private int customerId;
	private int totalCostInCents;
	private List<Trip> trips;

	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public int getTotalCostInCents() {
		return totalCostInCents;
	}
	
	public void setTotalCostInCents(int totalCostInCents) {
		this.totalCostInCents = totalCostInCents;
	}
	
	public List<Trip> getTrips() {
		return trips;
	}
	
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	@Override
	public String toString() {
		return "{customerId:" + customerId + ", totalCostInCents:" + totalCostInCents + ", trips:"
				+ trips + "}";
	}
	
	
	
	
	
}
