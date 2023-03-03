package ticket.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Injectors.TripServiceInjector;
import configuration.StationsList;
import configuration.TripsCombinations;
import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;
import services.TripService;
import services.impl.TripServiceImpl;

public class TripServiceTest {
	
	TripsCombinations tripsCombinations = TripsCombinations.getInstance();
	List<TripDTO> possibleTrips = tripsCombinations.getAllPossibletrips();
	
	StationsList stationsList = StationsList.getInstance();
	List<Station> stations = stationsList.getAllStations();


	TripService tripService = new TripServiceImpl();
	TripServiceInjector tripServiceInjector = new TripServiceInjector(tripService);
	
	
	
	@Test
	public void testTotalCalculation() {
		List<Trip> trips = new ArrayList<>();
		
		Trip trip1 = new Trip();
		trip1.setCostInCents(250);
		
		Trip trip2 = new Trip();
		trip2.setCostInCents(300);
		
		trips.add(trip1);
		trips.add(trip2);
		
		int totalCost = tripServiceInjector.calculateTotalPrice(trips);
		
		assertEquals(550, totalCost);
		
		
	}
	
	
	@Test
	public void testTripMapper() {
		Station stationA = stations.get(0);
		Station stationB = stations.get(1);
		
		Tap tap1 = new Tap();
		tap1.setCustomerId(1);
		tap1.setStation("A");
		tap1.setUnixTimestamp(125);
		
		Tap tap2 = new Tap();
		tap2.setCustomerId(1);
		tap2.setStation("B");
		tap2.setUnixTimestamp(150);
		
		Trip createdTrip = new Trip("A","B",125,240,1,1);
		Trip mappedTrip = tripServiceInjector.mapTapsToTrip(possibleTrips, stationA, stationB, tap1, tap2);
		
		assertEquals(createdTrip, mappedTrip);
	}
	
}
