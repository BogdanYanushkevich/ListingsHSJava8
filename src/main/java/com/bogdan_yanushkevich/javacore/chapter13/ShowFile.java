package main.java.com.bogdan_yanushkevich.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {

        int i;
        // Make sure the file name is specified
        if (args.length != 1) {
            System.out.println("Usage : ShowFile file_name");
            return;
        }

        //Try statement with resources applied
        //first to open and then to automatic
        //closing the file at the end of the block of this statement

        try (FileInputStream fin = new FileInputStream(args[0])) {

            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
