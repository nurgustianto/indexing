package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtil {

    public static List<String> readFileLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static String[] splitTextIntoWords(String text) {
        return text.split("\\W+");
    }

    public static List<String> readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Invalid file path: " + filePath);
        }
        try {
            return readFileLines(file);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    public static List<String> extractWords(File file) throws IOException {
    return Files.readAllLines(file.toPath()).stream()
            .flatMap(line -> List.of(line.split("\\W+")).stream())
            .filter(word -> !word.isBlank())
            .collect(Collectors.toList());
    }

}