package com.bootcamp.scrable.components;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordScore {

    public static Map<String, Integer> getScoreForAll(List<String> allWords, Map<Character, Integer> letterScore) {
        Map<String, Integer> scoreForAllWords = new HashMap<String, Integer>();
        for(String s : allWords) {
            int score = 0;
            for(int i=0;i<s.length();i++) {
                score += letterScore.get(s.charAt(i));
            }
            scoreForAllWords.put(s, score);
        }
        return scoreForAllWords;
    }

}
