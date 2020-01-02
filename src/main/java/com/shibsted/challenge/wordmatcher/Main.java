package com.shibsted.challenge.wordmatcher;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.shibsted.challenge.wordmatcher.find.impl.FindWordsMatcherImpl;
import com.shibsted.challenge.wordmatcher.find.spec.FindWordMatcher;
import com.shibsted.challenge.wordmatcher.io.impl.PrintByConsoleRankingResults;
import com.shibsted.challenge.wordmatcher.io.spec.PrinterResults;
import com.shibsted.challenge.wordmatcher.match.impl.WordMatcherImpl;
import com.shibsted.challenge.wordmatcher.util.FileUtils;

/**
 * A Java application that emulates a text search engine. This application uses
 * an algorithm implementation that allows to a command line to be split in
 * words and find matches in names of files on a given directory.
 * 
 * @author hrodriguez
 *
 */
public class Main {

	/**
	 * The main entry point of this application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		if (args.length == 0) {

			throw new IllegalArgumentException("No directory given to index.");

		}

		try (Scanner keyboard = new Scanner(System.in)) {

			final File indexableDirectory = new File(args[0]);
			File[] listOfFiles = FileUtils.listFiles(indexableDirectory.getAbsolutePath(), Optional.empty());

			System.out.println(listOfFiles.length + " files read in directory " + indexableDirectory.getAbsolutePath());

			Map<String, String> contentFiles = FileUtils.getMapOfContentFile(listOfFiles);

			String termToSearch = "";

			while (!termToSearch.equals(":quit")) {

				System.out.print("search> ");

				termToSearch = keyboard.nextLine();

				FindWordMatcher finder = new FindWordsMatcherImpl(new WordMatcherImpl());

				Map<String, Double> ranking = finder.findRanking(contentFiles, termToSearch);

				PrinterResults printer = new PrintByConsoleRankingResults(ranking.entrySet());

				printer.print();

			}

		} catch (Exception e) {

			System.err
					.println("There was an error trying to find term into selected directory [" + e.getMessage() + "]");

		}

	}

}
