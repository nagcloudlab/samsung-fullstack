package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class ServerApp {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        ExecutorService executorService = null;
        try {
            executorService = java.util.concurrent.Executors.newFixedThreadPool(8);
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");
            while (true) {
                executorService.execute(new Request(serverSocket.accept()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class Request implements Runnable {
    Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try (
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(
                            new OutputStreamWriter(socket.getOutputStream()))) {
                String line = "";
                while (!"/quit".equals(line)) {
                    line = reader.readLine(); // <2>
                    System.out.println("~ " + line);
                    writer.write(line + "\n"); // <3>
                    writer.flush();
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// serlization:
// convert java object to byte stream, then store in file or send over network

// deserialization:
// convert byte stream to java object

// why we need ?

// keep passive objects outside heap memoryb ( in file )
// send object over network
// restore after JVM restart
