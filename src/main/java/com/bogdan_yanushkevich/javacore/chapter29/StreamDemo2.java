package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        //create a list of objects of type Integer
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        // two ways to get the result of multiplication
        // integer elements of the List using
        // reduce() method

        Optional<Integer> produtcObj = myList.stream().reduce((a, b) -> a + b);
        produtcObj.ifPresent(integer -> System.out.println("Product as an Object of type Optional: " + integer));

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as an int: " + product);

        int evenProduct = myList.stream().reduce(1, (a, b) -> {
            if (b % 2 == 0) {
                return a * b;
            } else {
                return a;
            }
        });
        System.out.println("Even product is: " + evenProduct);

        int parallelProduct = myList.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b);
        System.out.println("Parallel product is: " + parallelProduct);
    }
}
