package com.bootcamp.scrable.interfaces;

import java.util.List;

public interface TokenMatcher {

	public List<String> apply(String token, List<String> unfiltered);
}
