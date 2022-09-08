package main.java.com.bogdan_yanushkevich.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRread {
    public static void main(String[] args) throws IOException {

        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter character 'q' - to exit.");
        // read characters
        do {
            c =  (char) br.read();
            System.out.println(c);
        } while (c != 'q');

    }
}
