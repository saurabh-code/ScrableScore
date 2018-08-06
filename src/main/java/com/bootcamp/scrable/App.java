package com.bootcamp.scrable;

import java.io.FileNotFoundException;
import java.util.List;

import com.bootcamp.scrable.components.Match;
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
    		
    		Match matcher = new Match();
    		List<String> s2 = matcher.filterOnSize(sowPods, "APPLE");
    		
    		
    		System.out.println(s2);
    }
}
