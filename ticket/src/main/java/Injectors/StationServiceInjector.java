package Injectors;

import java.util.List;

import model.Station;
import model.Tap;
import services.StationService;

public class StationServiceInjector {
	private StationService stationService;
	
	public StationServiceInjector(StationService stationService) {
		this.stationService = stationService; 
	}
	
	public  Station getStation(List<Station> stations, Tap tap) {
		return stationService.getStation(stations, tap);
	}
	
}
