package org.example;

import java.io.*;
import java.nio.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronousEchoServer {
    public static void main(String[] args) throws Throwable {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(3000));
//        ExecutorService executorService= Executors.newFixedThreadPool(2);
        while (true) {
            Socket socket = server.accept();
            new Thread(clientHandler(socket)).start(); // on-demand thread creation
//            executorService.submit(clientHandler(socket));
        }
    }

    private static Runnable clientHandler(Socket socket) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + " handling incoming connection");
            try (
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(
                            new OutputStreamWriter(socket.getOutputStream()))) {
                String line = "";
                while (!"/quit".equals(line)) {
                    line = reader.readLine();  // blockig - IO
                    System.out.println("~ " + line);
                    writer.write(line + "\n");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}