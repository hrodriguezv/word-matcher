package com.shibsted.challenge.wordmatcher.io.impl;

import java.util.Map.Entry;
import java.util.Set;

import com.shibsted.challenge.wordmatcher.io.spec.PrinterResults;

/**
 * Provides a implementation of the contract defined in {@link PrinterResults}.
 * Its method allow priting a Set of data that contains a ranking of occurrences
 * of file names with is respective matching percentage of a given multi-word
 * value.
 * 
 * @author hrodriguez
 */
public class PrintByConsoleRankingResults implements PrinterResults {

	/** The ranking. */
	private Set<Entry<String, Double>> ranking;

	/**
	 * Instantiates a new object of this class.
	 *
	 * @param set
	 *            the set of results
	 */
	public PrintByConsoleRankingResults(Set<Entry<String, Double>> set) {

		this.ranking = set;

	}

	@Override
	public void print() {

		if (ranking.isEmpty()) {

			System.out.println("no matches found");

		}

		ranking.stream().forEach(entry -> System.out.printf("%s : %.0f%s %n", entry.getKey(), entry.getValue(), "%"));

	}

}
