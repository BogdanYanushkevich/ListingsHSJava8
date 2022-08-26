package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Using a foreach-style for loop to iterate over the elements of a collection

import java.util.*;

public class ForEachDemo {
    public static void main(String[] args) {
        // create array list for integers
        ArrayList<Integer> vals = new ArrayList<Integer>();

        // add integers to array list
        vals.add(1);
        vals.add(2);
        vals.add(3);
        vals.add(4);
        vals.add(5);

        // organize integer values into array list
        System.out.println("Arraylist vals content: ");
        for (int v : vals) {
            System.out.print(v + " ");
        }
        System.out.println();

        // sum integer values in a for loop
        int sum = 0;
        for (int v : vals) {
            sum += v;
        }
        System.out.println("Sum integer values: " + sum);

    }
}
