package configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Station;

public class StationsList {
	private static StationsList firstInstance = null;
	
	private StationsList() { }
	
	private List<Station> stations = Arrays.asList(new Station("A", Arrays.asList(1)),
			new Station("B", Arrays.asList(1)),
			new Station("C", Arrays.asList(3, 2)),
			new Station("D", Arrays.asList(2)),
			new Station("E", Arrays.asList(2, 3)),
			new Station("F", Arrays.asList(3, 4)),
		    new Station("G", Arrays.asList(4)),
			new Station("H", Arrays.asList(4)),
			new Station("I", Arrays.asList(4)));
	
	public static StationsList getInstance() {
		if (firstInstance == null) {
			firstInstance = new StationsList();
		}
		return firstInstance;
	}
	
	public List<Station> getAllStations(){
		return stations;
	}
	
}
