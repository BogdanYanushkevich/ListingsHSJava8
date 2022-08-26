package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate using the LinkedList class

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        //create LinkedList
        LinkedList<String> ll = new LinkedList<String>();

        // add elements to LinkedList

        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");

        ll.add(1, "A2");

        System.out.println("LinkedList content: " + ll);

        // remove elements from linked list
        ll.remove("F");
        ll.remove("2");

        System.out.println("Linked list content ll after removing elements: " + ll);

        // remove elements from linked list
        ll.removeFirst();
        ll.removeLast();

        System.out.println("Contents of linked list ll after removing" +
                " first and last elements : " + ll);

        // get and assign a value
        String val = ll.get(2);
        ll.set(2, val + " changed");

        System.out.println("Content of linked list ll after change: " + ll);

    }
}
