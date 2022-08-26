package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate applications of the ArrayDeque class

import java.util.*;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // create a deque
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // use the ArrayDeque class to organize the stack

        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");

        System.out.println("Popping from the stack: ");

        while (adq.peek() != null) {
            System.out.print(adq.pop() + " ");
        }

    }
}
