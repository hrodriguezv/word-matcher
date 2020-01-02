package com.shibsted.challenge.wordmatcher.match.spec;

/**
 * This interface defines the contract that allows to calculate a match
 * percentage between two two multi-word or phrases.
 * 
 * @author hrodriguez
 */
public interface WordMatcher {

	/**
	 * Determines the match percentage as result of a comparison between two
	 * multiwords values.
	 *
	 * @param multiWord1
	 *            the first multi-word value
	 * @param multiWord2
	 *            the second multi-word value
	 * @return the match percentage between both phrases
	 */
	Double match(String multiWord1, String multiWord2);
}
