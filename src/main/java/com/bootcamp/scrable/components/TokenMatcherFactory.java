package com.bootcamp.scrable.components;

import com.bootcamp.scrable.interfaces.TokenMatcher;

public class TokenMatcherFactory {

	private MatchWithoutWildCard withoutWildCard;
	private MatchWithWildCard withWildCard;
	
	public TokenMatcherFactory(MatchWithoutWildCard withoutWildCard) {
		super();
		this.withoutWildCard = withoutWildCard;
		this.withWildCard = new MatchWithWildCard(withoutWildCard);
	}

	public TokenMatcher getMatcher(String token) {
		if (token.contains("#")) {
			System.out.println("Using With wild card");
			return this.withWildCard;
		} else {
			System.out.println("Using without wild card");
			return this.withoutWildCard;
		}
	}
}
