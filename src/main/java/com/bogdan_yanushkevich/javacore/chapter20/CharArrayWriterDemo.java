package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CharArrayWriterDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = "This data should be output to an array";
        char[] buf = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);


        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("IO exception");
            return;
        }

        System.out.println("Buffer as a character string");
        System.out.println(f.toString());
        System.out.println("In array");

        char[] c = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

        System.out.println("\nTo an output stream of type FileWriter()");

        // use try statement with resources
        // to control the flow of I/O to a file

        try (FileWriter f2 = new FileWriter("test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
        System.out.println("Reset");
        f.reset();

        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
