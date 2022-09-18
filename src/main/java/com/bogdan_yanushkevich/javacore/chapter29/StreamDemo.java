package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // create a list array of values of type Integer
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Source list: " + myList);

        // get a stream of list array elements
        Stream<Integer> myStream = myList.stream();

        // get min and max values by calling min(), max(), isPresent() and get() methods

        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        minVal.ifPresent(integer -> System.out.println("Minimum value: " + integer));

        // sure to get a new stream of data, because the previous call
        // to the min() method became the final operation that consumed the data stream
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent()) {
            System.out.println("Maximum value: " + maxVal.get());
        }

        // sort the data stream by calling the sorted() method
        Stream<Integer> sortedStream = myList.stream().sorted();

        // display the sorted data stream by calling the forEach() method
        System.out.print("Sorted data stream: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // display only odd integer values by calling the filter() method
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Odd values: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
        // Odd values greater than 5:
        oddVals = myList.stream().filter((n) -> (n % 2) == 1 && n > 5).filter((n) -> n > 5);

        System.out.print("Odd values greater than 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
