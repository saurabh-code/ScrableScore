package com.bootcamp.scrable.components;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordScore {

    public static Map<String, Integer> getScoreForAll(List<String> allWords, int[] letterScore) {
        Map<String, Integer> scoreForAllWords = new HashMap<String, Integer>();
        for(String s : allWords) {
            int score = 0;
            for(int i=0;i<s.length();i++) {
                score += letterScore[(int)s.charAt(i) - (int)'A'];
            }
            scoreForAllWords.put(s, score);
        }
        return scoreForAllWords;
    }

}
