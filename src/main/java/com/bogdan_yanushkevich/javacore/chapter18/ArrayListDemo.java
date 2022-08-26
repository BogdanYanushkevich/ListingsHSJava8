package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate using the ArrayList class

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // create arraylist
        ArrayList<String> al = new ArrayList<String>();

        System.out.println("The initial size of the arraylist  al: " + al.size());
        // add elements to arraylist
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");

        System.out.println("Arraylist size after change: " + al.size());

        // print arraylist
        System.out.println("Arraylist content: " + al);


        // remove elements from arraylist
        al.remove("F");
        al.remove(2);

        System.out.println("The size of the arraylist al after deleting elements: " +
                al.size());

        System.out.println("Arraylist content: " + al);

    }
}
