package com.bootcamp.scrable.components;

public class Match {
    public Boolean matchWord( String word, String token){

        int hash[] = new int[26];

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
}
