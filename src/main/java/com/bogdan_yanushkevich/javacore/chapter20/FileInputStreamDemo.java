package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {

        int size;

        // To automatically close the input stream
        // use try statement with resources

        try (FileInputStream f = new FileInputStream("C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8\\src\\main\\java\\com\\bogdan_yanushkevich\\javacore\\chapter20\\FileInputStreamDemo.java")) {

            System.out.println("Total available bytes: " + (size = f.available()));

            int n = size / 40;

            System.out.println("First: " + n + " bytes, read from file one by one, by the read method");

            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("\nStill available: " + f.available());
            System.out.println("Read text: " + n + " bytes, read from file one by one, by the read(b[]) method");

            byte[] b = new byte[n];
            if (f.read(b) != n) {
                System.err.println("Can't read " + n + "bytes.");
            }

            System.out.println("[" + new String(b, 0, n) + "]");
            System.out.println("Still available: " + (size = f.available()));
            System.out.println("Skip half remaining bytes by the skip() method ");

            f.skip(size / 2);

            System.out.println("Still available: " + f.available());

            System.out.println("Read " + n / 2 + " bytes placed at the end of the array");

            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("Can't read " + n / 2 + " bytes.");
            }
            System.out.println("[" + new String(b, 0, b.length) + "]");
            System.out.println("Still available: " + f.available());

        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
