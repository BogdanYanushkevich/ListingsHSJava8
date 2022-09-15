package main.java.com.bogdan_yanushkevich.javacore.chapter22;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String[] args) throws Exception {
        int c;

        // create a socket connection to the internic.net website on port 43

        try (Socket s = new Socket("whois.internic.net", 43)) {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // form a query string
            String str = (args.length == 0 ? "OraclePressbooks.com" : args[0]) + "\n";

            // convert query string to bytes
            byte[] buf = str.getBytes();

            // send request
            out.write(buf);

            // read the response and display it on the screen
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
