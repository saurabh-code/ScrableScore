package com.bootcamp.scrable.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

	public List<String> fetchLinesFromFile(String pathToFile) throws FileNotFoundException;
}
