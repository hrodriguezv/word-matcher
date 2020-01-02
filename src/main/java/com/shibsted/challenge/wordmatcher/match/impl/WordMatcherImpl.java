package com.shibsted.challenge.wordmatcher.match.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.shibsted.challenge.wordmatcher.match.spec.WordMatcher;

/**
 * Provides a implementation of the contract defined in {@link WordMatcher}.
 * This class implements an algorithm to calculate the match percentage between
 * two multi-words values. This implementation allows split each multi-word
 * value into Sets of single words and then perform an intersection between them
 * to obtain a number 'N' of coincidences. This number is used to calculate the
 * proportion of these occurrences in relation to the total number of words.
 * 
 * @author hrodriguez
 */
public class WordMatcherImpl implements WordMatcher {

	/**
	 * Split a multi-word reference into a Set of words. This method is in charge to
	 * convert a phrase in a several words.
	 *
	 * @param secondStr
	 *            A multi-word value representation
	 * @return set of words
	 */
	private static Set<String> buildWordSet(String secondStr) {

		String[] array = secondStr.split("[\\W@&.?$+-]+");

		return Arrays.asList(array).stream().collect(Collectors.toSet());
	}

	@Override
	public Double match(String firstStr, String secondStr) {

		Set<String> firstWordSet = buildWordSet(firstStr);
		Set<String> secondWordSet = buildWordSet(secondStr);

		Set<String> intersection = new HashSet<String>(firstWordSet);
		intersection.retainAll(secondWordSet);

		double commonSets = intersection.size();

		return commonSets / firstWordSet.size();

	}

}
