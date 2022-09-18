package main.java.com.bogdan_yanushkevich.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Csi");
        myList.add("Omega");

        // get data stream for list array
        Stream<String> mySream = myList.stream();

        // get iterator for data stream
        Iterator<String> itr = mySream.iterator();

        // iterate over the elements in the data stream
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
