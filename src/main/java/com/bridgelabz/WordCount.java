package com.bridgelabz;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.txt"; // Path to text file
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split(" "); // Split by non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // Count words
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }

        // Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display top 5 most frequently occurring words
        System.out.println("Top 5 most frequently occurring words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue());
        }
    }
}
/*
Top 5 most frequently occurring words:
the: 3
file: 3
line: 3
this: 3
is: 3
 */