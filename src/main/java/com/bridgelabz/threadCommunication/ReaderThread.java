package com.bridgelabz.threadCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            String receivedMessage = reader.readLine(); // Reading data from pipe
            System.out.println("Reader Thread received: " + receivedMessage);
            pis.close();
        } catch (IOException e) {
            System.out.println("Error in ReaderThread.");
            e.printStackTrace();
        }
    }
}