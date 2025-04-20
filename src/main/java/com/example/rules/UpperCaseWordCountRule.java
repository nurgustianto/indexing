package com.example.rules;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class UpperCaseWordCountRule implements IndexingRule {

    public int apply(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            return (int) lines.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .filter(word -> !word.isEmpty() && Character.isUpperCase(word.charAt(0)))
                .count();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + file.getName(), e);
        }
    }

    @Override
    public void apply(String fileName, List<String> fileContent) {
        long count = fileContent.stream()
            .flatMap(line -> List.of(line.split("\\s+")).stream())
            .filter(word -> !word.isEmpty() && Character.isUpperCase(word.charAt(0)))
            .count();

        System.out.println("File: " + fileName + " - Words starting with uppercase: " + count);
    }
}