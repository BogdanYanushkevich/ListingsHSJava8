package main.java.com.bogdan_yanushkevich.javacore.chapter20;

// Use directories

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8\\src\\main\\java\\com\\bogdan_yanushkevich\\javacore";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory: " + dirname);

            String[] s = f1.list();

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is directory");
                } else {
                    System.out.println("Is file");
                }
            }
        } else {
            System.out.println(dirname + "is not directory");
        }
    }
}

