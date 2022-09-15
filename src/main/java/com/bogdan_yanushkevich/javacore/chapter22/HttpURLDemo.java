package main.java.com.bogdan_yanushkevich.javacore.chapter22;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("https://www.google.by/");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // output request method
        System.out.println("Request Method: " + hpCon.getRequestMethod());

        // output response code
        System.out.println("Response code: " + hpCon.getResponseCode());

        // output a response message
        System.out.println("Response message: " + hpCon.getResponseMessage());

        // get a list of fields and a set header keys
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("Next comes the heading:");

        // extract all keys and values from header
        for (String k : hdrField) {
            System.out.println("Key: " + k + "Value: " + hdrMap.get(k));
        }
    }
}
