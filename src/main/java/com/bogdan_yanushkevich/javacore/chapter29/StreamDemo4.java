package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        // Display square roots of elements from
        // list myList to a new data stream

        Stream<Double> sqrtRootStream = myList.stream().map((a) -> Math.sqrt(a));

        // get the product of square roots

        double productOfSqrtRoots = sqrtRootStream.reduce(1.0, (a, b) -> a * b);

        System.out.println("Product of sqrt Roots: " + productOfSqrtRoots);
    }
}
