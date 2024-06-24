package com.example;

// read or write with file system

public class FileResource implements AutoCloseable {

    public FileResource() {
        // constructor
        // initialize connection to file system
        // if file system is not available, throw exception
        //throw new RuntimeException("File system is not available");
    }

    public void read(String path) {
        // read file
        // if read file failed, throw exception
        throw new RuntimeException("Read file failed");
    }

    public void write(String path, String content) {
        // write file
        // if write file failed, throw exception
        throw new RuntimeException("Write file failed");
    }

    public void close() {
        // close connection to file system
    }
}
