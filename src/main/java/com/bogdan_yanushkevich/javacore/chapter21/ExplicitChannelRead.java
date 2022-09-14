package main.java.com.bogdan_yanushkevich.javacore.chapter21;

// use I/O channel to read file

import java.nio.*;
import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;


public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        // then get the pipe to this file in
        // try statement block with resources
        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))) {

            // allocate buffer memory
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                // read data from file to buffer
                count = fChan.read(mBuf);

                // stop reading when end of file is reached
                if (count != -1) {
                    mBuf.rewind();
                    // read data bytes from buffer and
                    // display them as symbols
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);

            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
