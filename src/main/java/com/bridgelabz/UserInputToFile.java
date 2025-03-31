package com.bridgelabz;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("src/main/resources/user-data.txt")) { // Append mode

            // Taking user input
            System.out.print("Enter your Name: ");
            String name = reader.readLine();

            System.out.print("Enter your Age: ");
            String age = reader.readLine();

            System.out.print("Enter your Favorite Programming Language: ");
            String language = reader.readLine();

            // Writing data to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved successfully!");

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
/*
Enter your Name: Dushyant
Enter your Age: 22
Enter your Favorite Programming Language: java
User information saved successfully!
 */