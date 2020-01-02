package com.shibsted.challenge.wordmatcher.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Optional;

import org.junit.Test;

/**
 * @author hrodriguez
 *
 */
public class TestFileUtils {

	@Test
	public void testListFileswithNoExtension() {
		File[] listOfFIles = FileUtils.listFiles(new File("./files").getAbsolutePath(), Optional.empty());
		assertEquals(12, listOfFIles.length);
	}

	@Test
	public void testNameFileWithNoExtension() {
		String fileNameWithNoExtension = FileUtils.removeExtension(new File(".files/Hola Mundo.txt").getName());
		assertEquals("Hola Mundo", fileNameWithNoExtension);
	}

}
