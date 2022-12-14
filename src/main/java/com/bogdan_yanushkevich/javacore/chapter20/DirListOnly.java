package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.File;
import java.io.FilenameFilter;

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

// view directory of html files
public class DirListOnly {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8\\src\\main\\java\\com\\bogdan_yanushkevich\\javacore\\chapter20";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String s[] = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
