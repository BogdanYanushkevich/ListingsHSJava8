package main.java.com.bogdan_yanushkevich.javacore.chapter21;

// Use mapping to read data from a file

import java.nio.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class MappedChannelRead {
    public static void main(String[] args) {

        // get a pipe to a file in a block
        // try statement with resources
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"))) {

            // get file size
            long fSize = fChan.size();

            // and now display the file in the buffer
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            // read bytes from buffer and print them to screen
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
            System.out.println();

        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

    }
}

