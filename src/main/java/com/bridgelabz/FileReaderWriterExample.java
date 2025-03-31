package com.bridgelabz;

import java.io.*;

public class FileReaderWriterExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/resources/input.txt");
             FileOutputStream fos = new FileOutputStream("src/main/resources/output.txt")) {

            int charData;
            while ((charData = fis.read()) != -1) {
                fos.write(charData);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
input.txt:
this is a line in file
this is another line in the file
this is the last line of the file

output.txt:
this is a line in file
this is another line in the file
this is the last line of the file
 */