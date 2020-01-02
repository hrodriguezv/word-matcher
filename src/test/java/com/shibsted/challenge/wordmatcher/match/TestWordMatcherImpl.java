package com.shibsted.challenge.wordmatcher.match;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.shibsted.challenge.wordmatcher.match.impl.WordMatcherImpl;
import com.shibsted.challenge.wordmatcher.match.spec.WordMatcher;

/**
 * @author hrodriguez
 *
 */
public class TestWordMatcherImpl {

	private WordMatcher matcher;
	
	@Before
	public void setup() {
		matcher = new WordMatcherImpl();
	}
	
	@Test
	public void test100PercentMeasure() {
		String str1 = "SetOfCharacters";
		String str2 = "SetOfCharacters";

		double percentage = matcher.match(str1, str2);

		assertTrue(1d == percentage);
	}

	@Test
	public void test33PercentMeasure() {
		String str1 = "Hola - Copy (4)";
		String str2 = "Hola";

		double percentage = matcher.match(str1, str2);

		assertTrue("0.33".equals(String.format("%.2f", percentage)));
	}

}
