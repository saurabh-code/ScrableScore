package com.bootcamp.scrable;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.bootcamp.scrable.components.MatchWithWildCard;
import com.bootcamp.scrable.components.MatchWithoutWildCard;
import com.bootcamp.scrable.components.ReduceToMax;
import com.bootcamp.scrable.components.SowPodsReader;
import com.bootcamp.scrable.components.TokenMatcherFactory;
import com.bootcamp.scrable.components.WordScore;
import com.bootcamp.scrable.interfaces.FileReader;
import com.bootcamp.scrable.interfaces.ReduceScore;
import com.bootcamp.scrable.interfaces.TokenMatcher;

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
    		
    		MatchWithoutWildCard withoutWildCard = new MatchWithoutWildCard();
    		TokenMatcher withWildCard = new MatchWithWildCard(withoutWildCard);
    		
    		TokenMatcherFactory factory = new TokenMatcherFactory(withoutWildCard);
    		
    		
    		ReduceScore reducer = new ReduceToMax();
    		
    		System.out.println(getBestWord("AAB#", sowPods, factory, reducer).toUpperCase());
    }
    
    public static String getBestWord (String token, List<String> l, TokenMatcherFactory matcher, ReduceScore reduceScore) {
    		List<String> filterd = matcher.getMatcher(token).apply(token.replace("#", ""), l);
    		System.out.println(filterd);
    		Map<String, Integer> scores = WordScore.getScoreForAll(filterd, score_of_letter);
    		String bestWord = reduceScore.apply(scores);
    		return bestWord;
    }
}
