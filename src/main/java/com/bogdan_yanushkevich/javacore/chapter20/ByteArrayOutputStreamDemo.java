package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {


        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This data should be output to an array";
        byte[] buf = s.getBytes();


        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println("buffer write error");
            return;
        }

        System.out.println("Buffer as a character string");
        System.out.println(f.toString());
        System.out.println("In array");
        byte[] b = f.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }

            System.out.println("\nB output stream of type OutputStream() ");

            // use try statement with resources for
            // control the flow of data input / output to a file

            try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
                f.writeTo(f2);
            } catch (IOException e) {
                System.out.println("I/O exception" + e);
                return;
            }

            System.out.println("Initialization");
            f.reset();


            for (int j = 0; j < 3 ; j++) {
                f.write('X');
            }
            System.out.println(f.toString());
            }
        }

