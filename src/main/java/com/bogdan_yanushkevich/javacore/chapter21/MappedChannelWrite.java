package main.java.com.bogdan_yanushkevich.javacore.chapter21;

import java.nio.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class MappedChannelWrite {
    public static void main(String[] args) {

        // get a channel to file in try with resources block
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {

            // then map the file to the buffer
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);


            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception" + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
