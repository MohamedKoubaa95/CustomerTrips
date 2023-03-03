package applicationStarter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Injectors.JsonUtilitiesInjector;
import Injectors.StationServiceInjector;
import Injectors.TripServiceInjector;
import configuration.StationsList;
import configuration.TripsCombinations;
import model.CustomerSummary;
import model.Output;
import model.Station;
import model.Tap;
import model.Trip;
import model.TripDTO;
import services.JsonUtilities;
import services.StationService;
import services.TripService;
import services.impl.JsonUtilitiesImpl;
import services.impl.StationServiceImpl;
import services.impl.TripServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		StationsList stationsList = StationsList.getInstance();
		
		List<Station> stations = stationsList.getAllStations();

		TripsCombinations tripsCombinations = TripsCombinations.getInstance();
		
		List<TripDTO> possibleTrips = tripsCombinations.getAllPossibletrips();


		JsonUtilities jsonUtilities = new JsonUtilitiesImpl();
		JsonUtilitiesInjector jsonUtilitiesInjector = new JsonUtilitiesInjector(jsonUtilities);
		
		TripService tripService = new TripServiceImpl();
		TripServiceInjector tripServiceInjector = new TripServiceInjector(tripService);
		
		StationService stationService = new StationServiceImpl();
		StationServiceInjector stationServiceInjector = new StationServiceInjector(stationService);
		
		if (args.length>1) {
			{
				String inputPath  = args[0];
				String outputPath = args[1];
			
			try {
				List<CustomerSummary> customers = new ArrayList<>();
				
				List<List<Tap>> result = jsonUtilitiesInjector.readInputFile(inputPath);

				result.forEach(customerTaps -> {
					
					List<Trip> takenTrips = new ArrayList<>();
					Collections.sort(customerTaps, Comparator.comparing(Tap::getUnixTimestamp));
					for (int i = 0; i < customerTaps.size() - 1; i = i + 2) {

						Tap startTap = customerTaps.get(i);
						Tap endTap = customerTaps.get(i + 1);
						
						Station startStation = stationServiceInjector.getStation(stations, startTap);
						Station endStation = stationServiceInjector.getStation(stations, endTap);
						
						Trip trip = tripServiceInjector.mapTapsToTrip(possibleTrips, startStation, endStation, startTap, endTap);
						
						takenTrips.add(trip);

					}
					int totalCost = tripServiceInjector.calculateTotalPrice(takenTrips);
					
					CustomerSummary customer = new CustomerSummary();
					customer.setCustomerId(customerTaps.get(0).getCustomerId());
					customer.setTrips(takenTrips);
					customer.setTotalCostInCents(totalCost);
					customers.add(customer);

				}); 

				Output outputObj = new Output();
				outputObj.setCustomerSummaries(customers);
				jsonUtilitiesInjector.writeOutputFile(outputPath, outputObj);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		else {
			System.out.println("Please provide the paths for the input and output files ");
		}

	}

}
