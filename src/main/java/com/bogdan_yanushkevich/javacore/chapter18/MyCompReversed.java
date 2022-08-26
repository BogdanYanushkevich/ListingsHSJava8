package main.java.com.bogdan_yanushkevich.javacore.chapter18;

import java.util.*;

// Comparator to compare character strings in reverse order

class MyCompReversed implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        // do the comparison in reverse order
        return aStr.compareTo(bStr);
    }
    // overriding the equals() method is not require
}

class CompDemoReversed {
    public static void main(String[] args) {

        MyCompReversed mcr = new MyCompReversed();
        /* create a tree set of type TreeSet
        pass a reverse-ordered version of the comparator of type
        MyComp to a tree set of type TreeSet */
        TreeSet<String> ts = new TreeSet<String>(mcr.reversed());
        // add elements into a tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // print elements from a tree set
        for (String element : ts) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

