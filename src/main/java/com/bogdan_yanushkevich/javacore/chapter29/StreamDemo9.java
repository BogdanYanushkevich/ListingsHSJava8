package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
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

        // iterate over the elements in the data stream

       // while (splitr.tryAdvance(System.out::println));

        splitr.forEachRemaining(System.out::println);
    }
}