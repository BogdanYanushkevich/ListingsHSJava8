package main.java.com.bogdan_yanushkevich.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {

        // get a pipe to a file in a try statement block with resources
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // write some number of bytes to buffer
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

            // prepare buffer for writing data
            mBuf.rewind();

            // write data from buffer to output file
            fChan.write(mBuf);

        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}
