package com.example.rules;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class LongWordListRule implements IndexingRule {

    @Override
    public void apply(String fileName, List<String> content) {
        List<String> words = content.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());

        System.out.println("Words longer than 5 characters in " + fileName + ":");
        words.forEach(System.out::println);
    }

    public List<String> apply(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            return lines.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + file.getName(), e);
        }
    }

}