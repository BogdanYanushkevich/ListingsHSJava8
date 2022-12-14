package main.java.com.bogdan_yanushkevich.javacore.chapter20;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e) {
            return null;
        }
    }
}


public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;

        Vector<String> files = new Vector<String>();

        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");
        //  InputStreamEnumerator ise = new InputStreamEnumerator(files);

        try (InputStream in = new SequenceInputStream(new InputStreamEnumerator(files))) {
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("Error opening file.");
        } catch (IOException e) {
            System.out.println("Error closing input stream SequenceInputStream");

        }
    }
}
