package Injectors;

import java.util.List;

import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;
import services.TripService;

public class TripServiceInjector {
	private TripService tripService;
	
	public TripServiceInjector(TripService tripService) {
		this.tripService = tripService;
	}
	
	public  int calculateTotalPrice(List<Trip> trips) {
		return tripService.calculateTotalPrice(trips);
	}
	
	public Trip mapTapsToTrip(List<TripDTO> possibleTrips,Station startStation , Station endStation , Tap startTap, Tap endTap) {
		return tripService.mapTapsToTrip(possibleTrips, startStation, endStation, startTap, endTap);
	}
}
