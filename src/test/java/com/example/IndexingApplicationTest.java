package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.rules.UpperCaseWordCountRule;
import com.example.rules.LongWordListRule;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexingApplicationTest {

    private IndexingApplication indexingApplication;

    @BeforeEach
    public void setUp() {
        indexingApplication = new IndexingApplication();
    }

    @Test
    public void testUpperCaseWordCountRule() {
        File testFile = new File("src/test/resources/testFile1.txt");
        int upperCaseCount = indexingApplication.applyRule(new UpperCaseWordCountRule(), testFile);
        assertEquals(3, upperCaseCount); // Assuming the test file has 3 uppercase words
    }

    @Test
    public void testLongWordListRule() {
        File testFile = new File("src/test/resources/testFile2.txt");
        List<String> longWords = indexingApplication.applyRule(new LongWordListRule(), testFile);
        assertEquals(5, longWords.size()); // Assuming the test file has 5 words longer than 5 characters
    }
}