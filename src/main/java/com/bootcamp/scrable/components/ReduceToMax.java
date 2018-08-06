package com.bootcamp.scrable.components;

import java.util.Map;
import java.util.Map.Entry;

import com.bootcamp.scrable.interfaces.ReduceScore;

public class ReduceToMax implements ReduceScore {

	public String apply(Map<String, Integer> m) {
		int max = -1;
		String word = "";
		for (Entry<String, Integer> e: m.entrySet()) {
			if (e.getValue() > max) {
				max = e.getValue();
				word = e.getKey();
			}
		}
		
		return word;
	}

}
