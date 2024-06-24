package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// source : File

public class Ex2 {
    public static void main(String[] args) {

        File file = new File("/home/nag/samsung-fullstack/01-play-with-java/10-IO/pom.xml");

        try {
            FileReader fr = new FileReader(file); // character stream
            char[] chars = new char[(int) file.length()];
            fr.read(chars);
            fr.close();

            String content = new String(chars);
            System.out.println(content);

            FileWriter fw = new FileWriter(
                    "/home/nag/samsung-fullstack/01-play-with-java/10-IO/pom-copy.xml", false);
            fw.write(content);
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
