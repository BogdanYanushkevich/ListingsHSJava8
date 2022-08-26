package main.java.com.bogdan_yanushkevich.javacore.chapter18;

import java.util.*;

// Comparator to compare character strings in reverse order

class MyComp implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        // do the comparison in reverse order
        return bStr.compareTo(aStr);
    }
    // overriding the equals() method is not require
}

class CompDemo {
    public static void main(String[] args) {
        //create a tree set of type TreeSet
        TreeSet<String> ts = new TreeSet<String>(new MyComp());
        // add elements into a tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // print elements from a tree set
        for(String element : ts){
            System.out.print(element + " ");
        }
        System.out.println();
    }
}