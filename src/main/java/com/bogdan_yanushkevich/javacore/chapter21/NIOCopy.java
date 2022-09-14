package main.java.com.bogdan_yanushkevich.javacore.chapter21;

// Copy the file using the NIO I/O system.

import java.io.*;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Application: where and where to copy");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception" + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
