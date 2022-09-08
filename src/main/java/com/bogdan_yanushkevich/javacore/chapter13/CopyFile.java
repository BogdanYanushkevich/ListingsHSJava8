package main.java.com.bogdan_yanushkevich.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) throws IOException {

        int i;

        if (args.length != 2) {
            System.out.println("Usage: CopyFile in out");
            return;
        }

        //copy file

        try (FileInputStream fin = new FileInputStream(args[0]);
             FileOutputStream fout = new FileOutputStream(args[1])) {
            // try to open file
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O error has occurred" + e);
        }
    }
}
