package com.bootcamp.scrable.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bootcamp.scrable.interfaces.TokenMatcher;

public class MatchWithWildCard implements TokenMatcher {
	
	private final TokenMatcher matcher;
	private final List<String> alpha = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
	
	
	public MatchWithWildCard(TokenMatcher matcherWithoutWildCard) {
		this.matcher = matcherWithoutWildCard;
	}
	
	public List<String> apply(String token, List<String> unfiltered) {
		List<String> allFilteredWords = new ArrayList<String>();
		for(String wildCard: alpha) {
			String wildToken = token + wildCard;
			List<String> filteredWords = removeWildCard(this.matcher.apply(wildToken, unfiltered), wildCard);
			allFilteredWords.addAll(filteredWords);
		}
		return allFilteredWords;
	}
	
	private List<String> removeWildCard(List<String> l, String wildCard) {
		List<String> nn = new ArrayList<String>();
		for (String s: l) {
			StringBuilder sb = new StringBuilder(s);
			sb.setCharAt(s.indexOf(wildCard), wildCard.toLowerCase().charAt(0));
			nn.add(sb.toString());
		}
		return nn;
	}

}
