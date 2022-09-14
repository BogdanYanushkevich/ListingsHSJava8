package main.java.com.bogdan_yanushkevich.javacore.chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/* This program outputs a text file using the stream I/O code based on the NIO system.
To use this program, specify the name of the file you want to view. For example, to view the TEST.TXT file, enter in command mode
line the following command:
*/
public class ShowFile {
    public static void main(String[] args) {

        int i;

        // first make sure the file name is specified
        if (args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }

        // open a file and get the I/O stream associated with it

        try (InputStream fin = Files.newInputStream(Paths.get(args[0]))) {

            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);

        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception" + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
