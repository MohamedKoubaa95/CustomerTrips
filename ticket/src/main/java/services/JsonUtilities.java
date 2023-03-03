package services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import model.Output;
import model.Tap;

public interface JsonUtilities {
	public  List<List<Tap>> readInputFile(String filePath) throws IOException;
	
	public  void writeOutputFile(String filepath, Output output) throws StreamWriteException, DatabindException, IOException;
}
