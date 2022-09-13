package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8\\src\\main\\java\\com\\bogdan_yanushkevich\\javacore\\chapter20\\COPYRIGHT");
        p("File name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Absolut path: " + f1.getAbsolutePath());
        p("Parent directory: " + f1.getParent());
        p(f1.exists() ? "exists" : "not exist");
        p(f1.canWrite() ? "can wright" : "can`t wright");
        p(f1.canRead() ? "can read" : "can`t read");
        p(f1.isFile() ? "is a regular file" : "may be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "isn`t absolute");
        p("File last modified: " + f1.lastModified());
        p("Size: " + f1.length() + " byte");
    }
}
