package com.bridgelabz;
import java.io.*;

public class StudentDataStreams {
    public static void main(String[] args) {
        String fileName = "src/main/resources/students.dat"; // Binary file to store student data

        // Writing student details to a binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Writing student details
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);

            System.out.println("Student details written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to the file.");
            e.printStackTrace();
        }

        // Reading student details from the binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieving student details from file:");

            while (dis.available() > 0) {
                int rollNo = dis.readInt(); // Read roll number
                String name = dis.readUTF(); // Read name
                double gpa = dis.readDouble(); // Read GPA

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error while reading from the file.");
            e.printStackTrace();
        }
    }
}
/*
Student details written to the file successfully.

Retrieving student details from file:
Roll No: 101, Name: Alice, GPA: 3.8
Roll No: 102, Name: Bob, GPA: 3.6
 */