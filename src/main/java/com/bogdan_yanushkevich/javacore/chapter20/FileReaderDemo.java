package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("FileReaderDemo.java")) {
            int c;
            // read and print content

            while ((c = fr.read()) != -1) {
                System.out.println((char) c);
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
