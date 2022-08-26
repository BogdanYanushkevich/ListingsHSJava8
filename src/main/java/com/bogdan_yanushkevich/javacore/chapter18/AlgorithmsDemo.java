package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate the application of various collection algorithms

import java.util.*;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        // create an uninitialized linked list
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        // create a reverse-ordered comparator
        Comparator<Integer> r = Collections.reverseOrder();

        Collections.sort(ll, r);

        System.out.print("The list is sorted in reverse order: ");

        for (int i : ll) {
            System.out.print(i + " ");
        }

        System.out.println();

        // shuffle the list
        Collections.shuffle(ll);

        // output shuffled list
        System.out.println("List shuffled : ");

        for (int i : ll) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Minimum : " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));

    }
}
