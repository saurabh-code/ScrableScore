package com.bootcamp.scrable.components;

import java.util.regex.Pattern;

public class RegexMatch {

    public static Boolean apply(String word, String regex) {
        return Pattern.matches(regex, word);
    }

}
