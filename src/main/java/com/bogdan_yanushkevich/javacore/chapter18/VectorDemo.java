package main.java.com.bogdan_yanushkevich.javacore.chapter18;
// Demonstrate various vector operations

import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        // the initial size of the vector is 3 and the increment is 2
        Vector<Integer> v = new Vector<Integer>(3, 2);
        System.out.println("Initial vector size : " + v.size());
        System.out.println("Initial vector capacity : " + v.capacity());

        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("The capacity of the vector after adding four elements is: " + v.capacity());

        v.addElement(5);
        System.out.println("Current vector capacity: " + v.capacity());

        v.addElement(6);
        v.addElement(7);

        System.out.println("Te total capacity of the vector: " + v.capacity());

        v.addElement(9);
        v.addElement(10);

        System.out.println("The first element of the vector :" + v.firstElement());
        System.out.println("The last element of the vector : : " + v.lastElement());
        if (v.contains(3)) {
            System.out.println("Vector contains 3.");
        }

        // enumerate vector elements
        Enumeration<Integer> vEnum = v.elements();

        System.out.println("\nVector elements: ");
        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
        System.out.println();

        // Use an iterator to print the contents of a vector
        Iterator<Integer> vItr = v.iterator();

        System.out.println("\nVector elements: ");
        while (vItr.hasNext()) {
            System.out.print(vItr.next() + " ");
        }
        System.out.println();

        // Use an improved for loop in a for each style to output the elements of a vector
        System.out.println("\nVector elements: ");
        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
