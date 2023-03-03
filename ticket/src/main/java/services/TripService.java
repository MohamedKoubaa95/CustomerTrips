package services;

import java.util.List;

import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;

public interface TripService {
	public int calculateTotalPrice(List<Trip> trips);
	
	public Trip mapTapsToTrip(List<TripDTO> possibleTrips,Station startStation , Station endStation , Tap startTap, Tap endTap);
}
