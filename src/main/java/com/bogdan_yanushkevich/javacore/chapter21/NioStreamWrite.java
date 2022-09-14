package main.java.com.bogdan_yanushkevich.javacore.chapter21;

// demonstrate streaming output based on NIO system

import java.io.*;
import java.nio.file.*;

public class NioStreamWrite {
    public static void main(String[] args) {
        // open a file and get the output stream associated with it
        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("test.txt")))) {
            for (int i = 0; i < 26; i++) {
                fout.write('A' + i);
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception" + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
