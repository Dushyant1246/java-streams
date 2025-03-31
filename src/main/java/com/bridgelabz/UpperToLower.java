package com.bridgelabz;

import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.txt";   // Input text file
        String outputFile = "src/main/resources/output.txt"; // Output text file after conversion

        try {
            // Using BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase and write
                writer.newLine(); // Add new line
            }

            // Close resources
            reader.close();
            writer.close();

            System.out.println("File successfully converted to lowercase.");
        } catch (IOException e) {
            System.out.println("An error occurred during file processing.");
            e.printStackTrace();
        }
    }
}
/*
File successfully converted to lowercase.
 */