package com.shibsted.challenge.wordmatcher.find.spec;

import java.io.File;
import java.util.Map;

/**
 * This interface defines the contract that allows obtaining a data structure to
 * represent the match percentage of a phrase or multi-words term on the names
 * of a number of files in a given directory.
 * 
 * @author hrodriguez
 */
public interface FindWordMatcher {

	/**
	 * Performs a matching operation on the name of each file in the array using the
	 * given term, returning a map of the top 10 (max) of occurences in rank order.
	 * 
	 * @param files
	 *            Array of files where the match finding will be made.
	 * @param termToMatch
	 *            the term to match.
	 * @return a sorted map of key and value that represents the name of file with
	 *         its respective match percentage.
	 */
	Map<String, Double> findRanking(File[] files, String termToMatch);

	Map<String, Double> findRanking(Map<String, String> map, String termToMatch);

}
