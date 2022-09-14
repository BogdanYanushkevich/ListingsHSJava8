package main.java.com.bogdan_yanushkevich.javacore.chapter21;

//view directory content

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DirList {
    public static void main(String[] args) {
        String dirname = "C:\\Users\\Bogdan\\IdeaProjects\\ListingsHSJava8";

        // create a filter that returns a boolean
        // true only for available
        // to write files

        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path filename) throws IOException {
                if (Files.isWritable(filename)) {
                    return true;
                }
                return false;
            }
        };

        // get and use input stream from directory
        // only writable files

        try (DirectoryStream<Path> distrm = Files.newDirectoryStream(Paths.get(dirname), how)) {

            System.out.println("Directory: " + dirname);

            for (Path entry : distrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.print("<DIR>");
                } else {
                    System.out.print("      ");
                }
                System.out.println(entry.getName(entry.getNameCount() - 1));
            }


        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception: " + e);
        } catch (NotDirectoryException e) {
            System.out.println("Not directory exception: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

    }
}
