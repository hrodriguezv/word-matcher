package com.shibsted.challenge.wordmatcher.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * General file manipulation utilities.
 *
 * @author hrodriguez
 */
public class FileUtils {

	/**
	 * Removes the extension of a file name.
	 *
	 * @param fileName
	 *            the file name
	 * @return the string
	 */
	public static String removeExtension(String fileName) {
		return fileName.replaceFirst("[.][^.]+$", "");
	}

	/**
	 * Retrieves a filtered list of files of a given directory and an extension.
	 *
	 * @param dirName
	 *            the dir name
	 * @param extensionToFilter
	 *            the extension to filter
	 * @return the file[]
	 */
	public static File[] listFiles(String dirName, Optional<String> extensionToFilter) {

		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String filename) {

				if (extensionToFilter.isPresent()) {
					return filename.endsWith(extensionToFilter.get());
				}
				return true;
			}

		});

	}

	/**
	 * List all files of a given directory.
	 *
	 * @param dirName
	 *            the dir name
	 * @return the file[]
	 */
	public static File[] listFiles(String dirName) {
		return listFiles(dirName, Optional.empty());
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	private static String readLineByLineJava8(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static Map<String, String> getMapOfContentFile(File[] files) {

		return Arrays.asList(files).stream().collect(Collectors.toMap(file->file.getName(), file-> readLineByLineJava8(file.getAbsolutePath())));
	
	}
}
