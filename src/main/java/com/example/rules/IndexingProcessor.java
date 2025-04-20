package com.example.rules;

import com.example.rules.IndexingRule;
import java.util.List;

public class IndexingProcessor {
    private final List<IndexingRule> rules;

    // Constructor to initialize the list of rules
    public IndexingProcessor(List<IndexingRule> rules) {
        this.rules = rules;
    }

    // Method to process a file with all the rules
    public void processFile(String fileName, List<String> fileContent) {
        for (IndexingRule rule : rules) {
            rule.apply(fileName, fileContent);
        }
    }
}