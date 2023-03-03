package services.impl;

import java.util.Comparator;
import java.util.List;

import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;
import services.TripService;

public final class TripServiceImpl implements TripService {
	
	public  int calculateTotalPrice(List<Trip> trips) {
		return trips.stream().map(Trip::getCostInCents).reduce(0, Integer::sum);
	}

	@Override
	public Trip mapTapsToTrip(List<TripDTO> possibleTrips, Station startStation , Station endStation ,Tap startTap, Tap endTap) {
		
		TripDTO tripDto = possibleTrips.stream()
				.filter(trip -> startStation.getZones().contains(trip.getStartZone()))
				.filter(trip -> endStation.getZones().contains(trip.getEndZone()))
				.min(Comparator.comparing(TripDTO::getPrice)).orElse(null);
		
		Trip trip = new Trip(startStation.getName(), endStation.getName(),
				startTap.getUnixTimestamp(), tripDto.getPrice(), tripDto.getStartZone(),
				tripDto.getEndZone());
		
		return trip;
	}
}
