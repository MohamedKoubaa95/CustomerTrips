package configuration;

import java.util.Arrays;
import java.util.List;

import model.TripDTO;

public class TripsCombinations {
	private static TripsCombinations firstInstance = null;

	private TripsCombinations() {
	}

	private List<TripDTO> trips = Arrays.asList(
			new TripDTO(1, 1, 240), new TripDTO(1, 2, 240), new TripDTO(1, 3, 280), new TripDTO(1, 4, 300),

			new TripDTO(2, 1, 240), new TripDTO(2, 2, 240), new TripDTO(2, 3, 280), new TripDTO(2, 4, 300),

			new TripDTO(3, 1, 280), new TripDTO(3, 2, 280), new TripDTO(3, 3, 200), new TripDTO(3, 4, 200),

			new TripDTO(4, 1, 300), new TripDTO(4, 2, 300), new TripDTO(4, 3, 200), new TripDTO(4, 4, 200));
	
	
	public static TripsCombinations getInstance() {
		if(firstInstance == null) {
			firstInstance = new TripsCombinations();
		}
		return firstInstance;
	}
	
	public List<TripDTO> getAllPossibletrips(){
		return trips;
	}
}
