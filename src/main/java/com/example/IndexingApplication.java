package com.example;

import com.example.rules.IndexingProcessor;
import com.example.rules.IndexingRule;
import com.example.rules.UpperCaseWordCountRule;
import com.example.rules.LongWordListRule;
import com.example.utils.FileReaderUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexingApplication {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide file paths as arguments.");
            return;
        }

        // Initialize the list of rules
        List<IndexingRule> rules = new ArrayList<>();
        rules.add(new UpperCaseWordCountRule());
        rules.add(new LongWordListRule());

        // Create the IndexingProcessor
        IndexingProcessor processor = new IndexingProcessor(rules);

        // Process each file
        for (String filePath : args) {
            List<String> fileContent = FileReaderUtil.readFile(filePath);
            if (fileContent != null) {
                processor.processFile(filePath, fileContent);
            } else {
                System.out.println("Failed to read file: " + filePath);
            }
        }
    }

    // Method to apply the UpperCaseWordCountRule to a file
    public int applyRule(UpperCaseWordCountRule rule, File file) {
        return rule.apply(file);
    }

    public List<String> applyRule(LongWordListRule rule, File file) {
        return rule.apply(file);
    }
}