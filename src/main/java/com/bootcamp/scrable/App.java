package com.bootcamp.scrable;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bootcamp.scrable.components.SowPodsReader;
import com.bootcamp.scrable.interfaces.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String SOW_PODS = "src/resources/sowpods.txt";
	
    public static void main( String[] args ) throws FileNotFoundException
    {
    		FileReader fileReader = new SowPodsReader();
    		List<String> sowPods = fileReader.fetchLinesFromFile(SOW_PODS);
    		
    		System.out.println(sowPods);
    }
}
