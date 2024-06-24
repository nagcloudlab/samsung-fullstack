package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// source : File

public class Ex1 {
    public static void main(String[] args) {

        File file = new File("/home/nag/samsung-fullstack/01-play-with-java/10-IO/pom.xml");

        try {
            FileInputStream fis = new FileInputStream(file); // byte stream
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            fis.close();

            String content = new String(bytes);
            System.out.println(content);

            FileOutputStream fos = new FileOutputStream(
                    "/home/nag/samsung-fullstack/01-play-with-java/10-IO/pom-copy.xml", false);
            fos.write(bytes);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
