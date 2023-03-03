package services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Output;
import model.Tap;
import model.TapList;
import services.JsonUtilities;

public  class JsonUtilitiesImpl implements JsonUtilities {
	ObjectMapper objectMapper = new ObjectMapper();
	
	public  List<List<Tap>> readInputFile(String filePath) throws IOException {
		

		byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
		TapList taps = objectMapper.readValue(jsonData, new TypeReference<TapList>() {
		});

		Map<Integer, List<Tap>> grouped = taps.getTaps().stream()
				.collect(Collectors.groupingBy(Tap::getCustomerId));
		return new ArrayList<>(grouped.values());

	}
	
	public  void writeOutputFile(String filepath, Output output) throws StreamWriteException, DatabindException, IOException {
		File outputFile = new File(filepath);
		objectMapper.writeValue(outputFile, output);
	}
}
