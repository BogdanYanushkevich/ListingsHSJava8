package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate the use of the LinkedHashSet class

import java.util.*;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        // create a hash-set
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();

        // add elements into hash-set
        lhs.add("Beta");
        lhs.add("Alpha");
        lhs.add("Eta");
        lhs.add("Gamma");
        lhs.add("Epsilon");
        lhs.add("Omega");

        System.out.println(lhs);

    }
}

