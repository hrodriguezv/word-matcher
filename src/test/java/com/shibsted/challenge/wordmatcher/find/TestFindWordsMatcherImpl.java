package com.shibsted.challenge.wordmatcher.find;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.shibsted.challenge.wordmatcher.find.impl.FindWordsMatcherImpl;
import com.shibsted.challenge.wordmatcher.find.spec.FindWordMatcher;
import com.shibsted.challenge.wordmatcher.match.impl.WordMatcherImpl;
import com.shibsted.challenge.wordmatcher.match.spec.WordMatcher;
import com.shibsted.challenge.wordmatcher.util.FileUtils;

/**
 * @author hrodriguez
 *
 */
public class TestFindWordsMatcherImpl {

	private String term;
	private File rootDir;
	private File[] listOfFiles;
	private WordMatcher matcher;

	@Before
	public void setup() {

		rootDir = new File(".");
		listOfFiles = FileUtils.listFiles(rootDir + "/files", Optional.empty());
		matcher = new WordMatcherImpl();
	}

	@Test
	public void testFirstPlaceInRanking() {

		term = "Hola Mundo";

		FindWordMatcher finder = new FindWordsMatcherImpl(matcher);

		Map<String, Double> ranking = finder.findRanking(listOfFiles, term);

		assertTrue(FileUtils.removeExtension(ranking.keySet().stream().findFirst().get()).equals(term));

	}

	@Test
	public void testNoMatches() {

		term = "3333333333";

		FindWordMatcher finder = new FindWordsMatcherImpl(matcher);

		Map<String, Double> ranking = finder.findRanking(listOfFiles, term);

		assertTrue(ranking.keySet().isEmpty());

	}

	@Test
	public void testRankingLimitedTo10() {

		String term = "Hola";

		FindWordMatcher finder = new FindWordsMatcherImpl(matcher);

		Map<String, Double> ranking = finder.findRanking(listOfFiles, term);

		assertTrue(ranking.keySet().size() == 10);

	}
}
