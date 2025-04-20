package com.example.rules;

import java.util.List;

public interface IndexingRule {
    void apply(String fileName, List<String> fileContent);
}