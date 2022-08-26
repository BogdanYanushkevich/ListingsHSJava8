package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate a simple application of the interface Spliterator

import java.util.*;

public class SpliteratorDemo {
    public static void main(String[] args) {
        // create array list for double
        ArrayList<Double> vals = new ArrayList<>();

        // add values to array list
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // call the tryAdvance() method to enter the contents of the array list vals
        System.out.print("Arraylist vals content: \n");
        Spliterator<Double> splititr = vals.spliterator();
        while (splititr.tryAdvance((n) -> System.out.println(n))) ;
        System.out.println();

        /* create a new array list containing the square roots of the
        double values from the array list vals  */
        splititr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while (splititr.tryAdvance((n) -> sqrs.add(Math.sqrt(n)))) ;

        // call the forEachRemaining() method to enter the contents of the array list sqrs
        System.out.print("Arraylist sqrs content: \n");
        splititr = sqrs.spliterator();
        splititr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();

    }
}
