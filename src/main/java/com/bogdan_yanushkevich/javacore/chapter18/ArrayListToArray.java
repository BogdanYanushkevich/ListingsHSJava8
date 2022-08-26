package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Convert ArrayList to regular array

import java.util.*;

public class ArrayListToArray {
    //create arraylist
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        // add elements to arraylist
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        System.out.println("Arraylist content: " + al);

        // create array
        Integer[] ia = new Integer[al.size()];
        ia = al.toArray(ia);

        int sum = 0;

        // sum array elements
        for (int i : ia) {
            sum += i;
        }

        System.out.println("Sum: " + sum);

    }
}
