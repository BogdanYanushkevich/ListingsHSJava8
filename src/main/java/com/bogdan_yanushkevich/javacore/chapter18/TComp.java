package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// use a comparator to sort invoices by last names of depositors

import java.util.*;

// compare the last words in both character strings
public class TComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // find the index of the character that starts the last name
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareTo(bStr.substring(j));
        if (k == 0) { // Surnames match, check the full name and surname
            return aStr.compareTo(bStr);
        } else return k;
    }
    // overriding the equals() method is not required
}

class TreeMapDemo2 {
    public static void main(String[] args) {
        // create a tree map
        TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());

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
