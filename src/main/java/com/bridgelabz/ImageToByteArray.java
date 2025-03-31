package com.bridgelabz;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "src/main/resources/input.jpeg";  // Original image file
        String outputImagePath = "src/main/resources/output.jpeg"; // New image file after conversion

        try {
            // Read the image file into a byte array
            FileInputStream fis = new FileInputStream(inputImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray(); // Store image as byte array

            // Write the byte array back to an image file
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImagePath);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bais.close();
            baos.close();

            System.out.println("Image successfully converted to byte array and written back to a new file.");
        } catch (IOException e) {
            System.out.println("An error occurred during file processing.");
            e.printStackTrace();
        }
    }
}
/*
Image successfully converted to byte array and written back to a new file.
 */