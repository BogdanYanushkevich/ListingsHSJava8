package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Demonstrate the use of the FileOutputStearn class.
//This program uses the traditional way to close a file
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        String source = "Now is the time for all good men" +
                " to come to the aid of their country\n" +
                " and рау their due taxes.";

        byte buf[] = source.getBytes();

        try (FileOutputStream f0 = new FileOutputStream("file1.txt");
             FileOutputStream f1 = new FileOutputStream("file2.txt");
             FileOutputStream f2 = new FileOutputStream("file3.txt");) {
            // write data to first file
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }
            // write data to second file
            f1.write(buf);
            // write data to third file
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);

        } catch (IOException e) {
            System.out.println("An I/O error has occurred");
        }
    }
}
