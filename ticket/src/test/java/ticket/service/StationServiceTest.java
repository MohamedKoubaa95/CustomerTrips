package ticket.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Injectors.StationServiceInjector;
import Injectors.TripServiceInjector;
import configuration.StationsList;
import configuration.TripsCombinations;
import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;
import services.StationService;
import services.impl.StationServiceImpl;

public class StationServiceTest {
	
	TripsCombinations tripsCombinations = TripsCombinations.getInstance();
	List<TripDTO> possibleTrips = tripsCombinations.getAllPossibletrips();
	
	StationsList stationsList = StationsList.getInstance();
	List<Station> stations = stationsList.getAllStations();


	StationService stationService = new StationServiceImpl();
	StationServiceInjector stationServiceInjector = new StationServiceInjector(stationService);
	
	

	
	@Test
	public void canGetStation() {
		Station station1 = stations.get(0);
		
		Tap tap1 = new Tap();
		tap1.setCustomerId(1);
		tap1.setStation("A");
		tap1.setUnixTimestamp(125);
		
		Station station2 = stationServiceInjector.getStation(stations, tap1);
		
		assertEquals(station1, station2);
	}
	
}
