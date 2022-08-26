package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate the use of the HashSet class

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        // create a hash-set
        HashSet<String> hs = new HashSet<String>();

        // add elements into hash-set
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        System.out.println(hs);

    }
}
