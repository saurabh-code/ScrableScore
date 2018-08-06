package com.bootcamp.scrable.components;

import java.util.ArrayList;
import java.util.List;

public class Match {
    public Boolean matchWord(String word, String token){

        int hash[] = new int[256];

        for( int i = 0; i < token.length(); i++){
            hash[( token.charAt(i) - 'A') ]++;
        }

        for( int i = 0; i < word.length(); i++){
            hash[( word.charAt(i) - 'A') ]--;
            if(hash[( word.charAt(i) - 'A') ] < 0){
                return false;
            }

        }

        return true;
    }
    
    public List<String> filterOnSize(List<String> l, String token) {
    		List<String> validWords = new ArrayList<String>();
    		for (String w : l) {
    			if (matchWord(w, token)) {
    				validWords.add(w);
    			}
    		}
    		return validWords;
    }
}
