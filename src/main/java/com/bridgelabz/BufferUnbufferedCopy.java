package com.bridgelabz;

import java.io.*;

public class BufferUnbufferedCopy {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large-file.txt";
        String destinationPath = "src/main/resources/";

        try {
            long time = System.nanoTime();
            bufferedCopy(filePath, destinationPath + "buffered-file.txt");
            System.out.println("Time taken for buffered copy: " + (System.nanoTime() - time) / 1_000_000 + " ms");
            time = System.nanoTime();
            unbufferedCopy(filePath, destinationPath + "unbuffered-file.txt");
            System.out.println("Time taken for unbuffered copy: " + (System.nanoTime() - time) / 1_000_000 + " ms");
        }catch (FileNotFoundException e){
            System.err.println("FileNotFound Exception...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static void bufferedCopy(String filePath, String destinationPath) throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationPath));
        byte[] byteBuffer = new byte[4096];
        int byteReader;

        while ((byteReader = bis.read(byteBuffer)) != -1){
            bos.write(byteBuffer, 0, byteReader);
        }
    }

    static void unbufferedCopy(String filePath, String destinationPath) throws Exception{
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(destinationPath);
        int byteReader;

        while ((byteReader = fis.read()) != -1){
            fos.write(byteReader);
        }
    }
}
/*
Time taken for buffered copy: 5 ms
Time taken for unbuffered copy: 6425 ms
 */