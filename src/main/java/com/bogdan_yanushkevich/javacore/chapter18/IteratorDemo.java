package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate using iterators

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        // create array list
        ArrayList<String> al = new ArrayList<String>();

        // add elements to arraylist

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");


        // use iterators to output content array list al

        System.out.print("Arraylist al content: ");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // change iterable objects
        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }

        System.out.print("Changed content of array list al: ");
        itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // and now display the list in reverse order
        System.out.print("Reversed list : ");
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();

    }
}
