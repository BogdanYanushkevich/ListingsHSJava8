package main.java.com.bogdan_yanushkevich.javacore.chapter22;
// demonstrate the use of the URL class

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL hp = new URL("https://www.baeldung.com/gson-deserialization-guide");

        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("External form: " + hp.toExternalForm());


    }
}
