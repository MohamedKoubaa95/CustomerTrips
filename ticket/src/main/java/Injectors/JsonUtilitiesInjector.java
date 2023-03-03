package Injectors;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import model.Output;
import model.Tap;
import services.JsonUtilities;

public class JsonUtilitiesInjector {
	private JsonUtilities jsonUtilities;
	
	public JsonUtilitiesInjector(JsonUtilities jsonUtilities) {
		// TODO Auto-generated constructor stub
		this.jsonUtilities = jsonUtilities;
		
	}
	
	public  List<List<Tap>> readInputFile(String filePath) throws IOException {
		return jsonUtilities.readInputFile(filePath);
	}
	
	public  void writeOutputFile(String filepath, Output output) throws StreamWriteException, DatabindException, IOException {
		jsonUtilities.writeOutputFile(filepath, output);
	}
	
	
}
