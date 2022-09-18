package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Csi");
        myList.add("Omega");

        // get data stream for list array
        Stream<String> myStream = myList.stream();

        // get iterator for data stream
        Spliterator<String> splitr = myStream.spliterator();

        // and now divide the first iterator
        Spliterator<String> splitr2 = splitr.trySplit();

        // use splitter iterator first,
        // if can't split iterator splitter
        if (splitr2 != null) {
            System.out.println("Result output by iterator splititr2: ");
            splitr2.forEachRemaining(System.out::println);

            // and now use the iterator splititr
            System.out.println("\nResult output by iterator splititr: ");
            splitr.forEachRemaining(System.out::println);
        }
    }
}
