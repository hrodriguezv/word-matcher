package com.shibsted.challenge.wordmatcher.find.impl;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.shibsted.challenge.wordmatcher.find.spec.FindWordMatcher;
import com.shibsted.challenge.wordmatcher.match.spec.WordMatcher;
import com.shibsted.challenge.wordmatcher.util.FileUtils;

/**
 * Provides a implementation of the contract defined in {@link FindWordMatcher}.
 * Its methods allow calculating the matching percentage of a given multi-word
 * value on a list of files obtained previously, being organized in a Map of key
 * and value that represents the name of the matched file with its respective
 * match percentage.
 * 
 * @author hrodriguez
 */
public class FindWordsMatcherImpl implements FindWordMatcher {

	/** Instance of matcher object in charge of perform matching operations. */
	private WordMatcher matcher;

	/**
	 * Instantiates a new object of this class.
	 *
	 * @param ref
	 *            the ref to WordMatcher
	 */
	public FindWordsMatcherImpl(WordMatcher ref) {

		this.matcher = ref;

	}

	/**
	 * Builds the data structure.
	 *
	 * @param files
	 *            the files
	 * @param termToMatch
	 *            the term to match
	 * @return the map
	 */
	private Map<String, Double> buildMap(File[] files, String termToMatch) {

		Map<String, Double> map = new HashMap<>();

		for (File file : files) {

			double percentage = matcher.match(FileUtils.removeExtension(file.getName()), termToMatch);
			if (percentage > 0) {

				map.put(file.getName(), 100 * percentage);

			}

		}
		return map;
	}

	private Map<String, Double> buildMap(Map<String, String> memory, String termToMatch) {

		return memory.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(),
				entry -> 100 * matcher.match(FileUtils.removeExtension(entry.getValue()), termToMatch)));
	}

	@Override
	public Map<String, Double> findRanking(File[] files, String termToMatch) {

		Map<String, Double> sorted = buildMap(files, termToMatch).entrySet().stream().filter(x -> x.getValue() > 0)
				.limit(10).sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(entry -> entry.getKey(), entry -> entry.getValue(), (entry1, entry2) -> entry2,
						LinkedHashMap::new));

		return sorted;

	}

	@Override
	public Map<String, Double> findRanking(Map<String, String> map, String termToMatch) {
		return buildMap(map, termToMatch).entrySet().stream().filter(x -> x.getValue() > 0).limit(10)
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(entry -> entry.getKey(),
						entry -> entry.getValue(), (entry1, entry2) -> entry2, LinkedHashMap::new));
	}

}
