package com.gildedrose.texttest;

import static com.gildedrose.texttest.TexttestFixtureBeforeRefac.FILENAME_FORMAT;
import static junit.framework.TestCase.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Ignore;
import org.junit.Test;

import com.gildedrose.TexttestFixture;

@Ignore
public class TexttestFixtureAfterRefac {

	@Test
	public void testTextForMinus1Day() throws IOException {
		String[] files = textsBeforeAndAfterRefac(-1);
		assertEquals(files[0], files[1]);
	}

	@Test
	public void testTextFor0Day() throws IOException {
		String[] files = textsBeforeAndAfterRefac(0);
		assertEquals(files[0], files[1]);
	}

	@Test
	public void testTextFor1Day() throws IOException {
		String[] files = textsBeforeAndAfterRefac(1);
		assertEquals(files[0], files[1]);
	}

	@Test
	public void testTextFor3Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(2);
		assertEquals(files[0], files[1]);
	}

	@Test
	public void testTextFor4Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(4);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor5Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(5);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor6Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(6);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor9Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(9);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor10Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(10);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor11Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(11);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor12Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(12);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor20Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(20);
		assertEquals(files[0], files[1]);
	}


	@Test
	public void testTextFor100Days() throws IOException {
		String[] files = textsBeforeAndAfterRefac(100);
		assertEquals(files[0], files[1]);
	}



	private String[] textsBeforeAndAfterRefac(int day) throws IOException {
		String fileNameOriginal = String.format(FILENAME_FORMAT, day);
		String fileOriginal = new String(Files.readAllBytes(Paths.get(fileNameOriginal)),StandardCharsets.UTF_8.toString());

		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (PrintStream ps = new PrintStream(baos, true, StandardCharsets.UTF_8.toString())) {
			System.setOut(ps);
			String[] dayWrapper = { String.valueOf(day) };
			TexttestFixture.main(dayWrapper);
			String fileAfterRefac = new String(baos.toByteArray(), StandardCharsets.UTF_8);

			return new String[]{fileOriginal, fileAfterRefac};
		}
	}

}
