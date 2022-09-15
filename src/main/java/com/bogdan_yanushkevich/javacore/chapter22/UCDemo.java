package main.java.com.bogdan_yanushkevich.javacore.chapter22;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("https://benzomir.by/");
        URLConnection hpCon = hp.openConnection();


        // get date
        long d = hpCon.getDate();
        if (d == 0) {
            System.out.println("No date information available.");
        } else {
            System.out.println("Date: " + new Date(d));
        }
        // get date of last modification
        d = hpCon.getLastModified();
        if (d == 0) {
            System.out.println("Information about the date of the last modification.");
        } else {
            System.out.println("Date of last modification: " + new Date(d));
        }
        // get content length
        long len = hpCon.getContentLengthLong();
        if (len == -1) {
            System.out.println("Content length not available.");
        } else {
            System.out.println("Content length: " + len);
        }

        if (len != 0) {
            System.out.println("=== content ===");
            try (InputStream input = hpCon.getInputStream()) {
                while (((c = input.read()) != -1)) {
                    System.out.print((char) c);
                }
            }
        } else {
            System.out.println("Content not available");
        }
    }
}
