package com.bootcamp.scrable;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.bootcamp.scrable.components.Match;
import com.bootcamp.scrable.components.ReduceToMax;
import com.bootcamp.scrable.components.SowPodsReader;
import com.bootcamp.scrable.components.WordScore;
import com.bootcamp.scrable.interfaces.FileReader;
import com.bootcamp.scrable.interfaces.ReduceScore;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String SOW_PODS = "src/resources/sowpods.txt";
	
	public static final int[] score_of_letter = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	
    public static void main( String[] args ) throws FileNotFoundException
    {
    		FileReader fileReader = new SowPodsReader();
    		List<String> sowPods = fileReader.fetchLinesFromFile(SOW_PODS);
    		
    		Match matcher = new Match();
    		List<String> s2 = matcher.filterOnSize(sowPods, "SIMPLE");
    		
    		Map<String, Integer> scores = WordScore.getScoreForAll(s2, score_of_letter);
    		
    		ReduceScore reducer = new ReduceToMax();
    		
    		String bestWord = reducer.apply(scores);
    		
    		System.out.println(scores);
    		System.out.println(bestWord);
    }
}
