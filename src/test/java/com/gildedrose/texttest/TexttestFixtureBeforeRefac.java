package com.gildedrose.texttest;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

import com.gildedrose.TexttestFixture;

public class TexttestFixtureBeforeRefac {

    public static final String FILENAME_FORMAT = "src/test/resources/texttest-originalll/testfiledays%d.txt";

    @Ignore
    @Test
    public void generateFiles() {
        IntStream.range(-1,101).forEach(day -> generateFile(day));
    }

    private void generateFile(int day) {
        try {
            String filename = String.format(FILENAME_FORMAT, day);
            try (PrintStream fileOut = new PrintStream(filename)) {
                System.setOut(fileOut);
                String[] dayWrapper = { String.valueOf(day) };
                TexttestFixture.main(dayWrapper);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
