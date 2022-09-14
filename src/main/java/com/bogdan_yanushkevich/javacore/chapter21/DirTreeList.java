package main.java.com.bogdan_yanushkevich.javacore.chapter21;

// A simple example of using the walkFileTree() method to display a directory tree

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

// create a special version of the SimpleFileVisitor class that overrides the visitFile() method

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DirTreeList {
    public static void main(String[] args) {

        String dirname = "C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8\\src\\main\\java\\com\\bogdan_yanushkevich\\javacore\\chapter21";
        System.out.println("Directory tree, starting from catalog  " + dirname + ":\n");

        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException e) {
            System.out.println("IO exceptoin: " + e);
        }
    }
}
