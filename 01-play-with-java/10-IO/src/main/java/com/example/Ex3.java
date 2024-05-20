package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex3 {

    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in); // character stream
        try {
            // System.out.println("Enter a character:");
            // char c = (char) isr.read();
            // System.out.println("You entered: " + c);

            BufferedReader br = new BufferedReader(isr);
            System.out.println("Enter a string:");
            String s = br.readLine();
            System.out.println("You entered: " + s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
