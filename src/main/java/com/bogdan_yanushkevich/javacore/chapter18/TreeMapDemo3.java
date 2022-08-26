package main.java.com.bogdan_yanushkevich.javacore.chapter18;

import java.util.*;

public class TreeMapDemo3 {
    public static void main(String[] args) {
        /*use the thenComparing() method to create
        comparator that compares first surnames and then
        full name contributors if the last names are the same */

        Comparator<String> compLastNames = (aStr, bStr) -> aStr.substring(aStr.lastIndexOf(' ')).compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' ')));

        // create a tree map
        TreeMap<String, Double> tm = new TreeMap<String, Double>(compLastNames.thenComparing((aStr, bStr) -> aStr.compareToIgnoreCase(bStr)));


        // add elements to tree map
        tm.put("John Doe", (3434.34));
        tm.put("Tom Smith", (123.22));
        tm.put("Jane Baker", (1378.00));
        tm.put("Tod Hall", (99.22));
        tm.put("Ralph Smith", (-19.08));


        // get entry set
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // print entry set
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // deposit the amount of 1000 to the John Doe account
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);
        System.out.println("New John Doe account balance: " +
                tm.get("John Doe"));
    }
}
