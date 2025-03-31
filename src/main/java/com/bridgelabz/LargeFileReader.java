package com.bridgelabz;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large-file.txt"; // Path to large text file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read file line by line
                if (line.toLowerCase().contains("error")) { // Case-insensitive search for "error"
                    System.out.println(line); // Print only matching lines
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
