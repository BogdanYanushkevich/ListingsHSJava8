package main.java.com.bogdan_yanushkevich.javacore.chapter21;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;


public class PathDemo {
    public static void main(String[] args) {

        Path filepath = Paths.get("test.txt");

        System.out.println("File name: " + filepath.getName(0));
        System.out.println("Path to file: " + filepath);
        System.out.println("Absolut path to file: " + filepath.toAbsolutePath());
        System.out.println("Parent directory: " + filepath.getParent());

        if (Files.exists(filepath)) {
            System.out.println("File exist");
        } else {
            System.out.println("File is not exist");
        }
        try {
            if (Files.isHidden(filepath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File isn`t hidden");
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

        Files.isWritable(filepath);
        System.out.println("File is writable");
        Files.isReadable(filepath);
        System.out.println("File is readable");

        try {
            BasicFileAttributes attribs = Files.readAttributes(filepath, BasicFileAttributes.class);

            if (attribs.isDirectory()) {
                System.out.println("It is directory");
            } else {
                System.out.println("It isn`t directory");
            }
            if (attribs.isRegularFile()) {
                System.out.println("It is regular file");
            } else {
                System.out.println("It isn`t regular file");
            }
            if (attribs.isSymbolicLink()) {
                System.out.println("Is symbolic link");
            } else {
                System.out.println("It isn`t symbolic link");
            }
            System.out.println("Last modify time: " + attribs.lastModifiedTime());
            System.out.println("File size: " + attribs.size());

        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }


    }
}
