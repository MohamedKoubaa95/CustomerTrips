package services;

import java.util.List;

import model.Station;
import model.Tap;

public interface StationService {
	public Station getStation(List<Station> stations, Tap tap);
}
