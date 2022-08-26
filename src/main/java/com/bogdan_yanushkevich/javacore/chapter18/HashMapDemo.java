package main.java.com.bogdan_yanushkevich.javacore.chapter18;

import java.util.*;


public class HashMapDemo {
    public static void main(String[] args) {
        // create a hash map
        HashMap<String, Double> hm = new HashMap<String, Double>();

        // add elements to hash map
        hm.put("John Doe", (3434.34));
        hm.put("Tom Smith", (123.22));
        hm.put("Jane Baker", (1378.00));
        hm.put("Tod Hall", (99.22));
        hm.put("Ralph Smith", (-19.08));

        // get entry set
        Set<Map.Entry<String, Double>> set = hm.entrySet();

        // print entry set
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // deposit the amount of 1000 to the John Doe account
        double balance = hm.get("John Doe");
        hm.put("John Doe", balance + 1000);
        System.out.println("New John Doe account balance: " +
                hm.get("John Doe"));
    }
}
