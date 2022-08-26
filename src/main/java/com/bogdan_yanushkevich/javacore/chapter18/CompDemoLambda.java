package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Use a lambda expression to create a comparator in reverse order

import java.util.*;

public class CompDemoLambda {
    public static void main(String[] args) {
        // use lambda expression for implementation comparator of type Comparator<String>
        Comparator<String> mc = (aStr, bStr) -> aStr.compareTo(bStr);

        //create a tree set of type TreeSet
        TreeSet<String> ts = new TreeSet<String>(mc.reversed());
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
