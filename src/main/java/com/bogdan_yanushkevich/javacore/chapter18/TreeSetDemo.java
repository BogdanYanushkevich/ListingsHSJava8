package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate using the TreeSet class

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        // create tree set
        TreeSet<String> ts = new TreeSet<String>();

        // add elements into a tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        System.out.println(ts);

        System.out.println(ts.subSet("C", "F"));

    }
}
