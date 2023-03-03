package services.impl;

import java.util.List;

import model.Station;
import model.Tap;
import services.StationService;

public class StationServiceImpl implements StationService {

	@Override
	public Station getStation(List<Station> stations, Tap tap) {
		return stations.stream()
				.filter(station -> station.getName().equals(tap.getStation())).findFirst()
				.orElse(null);
	}
	

}
