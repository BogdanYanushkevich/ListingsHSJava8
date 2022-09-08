package main.java.com.bogdan_yanushkevich.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLines {
    public static void main(String[] args) throws IOException {
        // create an input stream of type BufferedReader
        // using standard input System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to complete." );

        do {
            str = br.readLine();
            System.out.println(str);
        }while (!str.equals("stop"));
    }
}
