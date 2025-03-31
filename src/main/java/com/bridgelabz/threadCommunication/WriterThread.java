package com.bridgelabz.threadCommunication;

import java.io.IOException;
import java.io.PipedOutputStream;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); // Writing data to pipe
            pos.close(); // Closing stream after writing
        } catch (IOException e) {
            System.out.println("Error in WriterThread.");
            e.printStackTrace();
        }
    }
}
