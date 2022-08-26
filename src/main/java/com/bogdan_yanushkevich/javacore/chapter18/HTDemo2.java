package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Apply iterators along with the Hashtable class

import java.util.*;

public class HTDemo2 {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<String, Double>();
        Enumeration<String> names;

        String str;
        double bal;

        balance.put("John Doe", 3434.3);
        balance.put("Tom Smith", 123.22);
        balance.put("Jane Baker", 1378.00);
        balance.put("Tod Hall", 99.22);
        balance.put("Ralph Smith", -19.08);

        // Output all accounts in a hash table.
        // First get the representation of all keys as a set
        Set<String> set = balance.keySet();

        // get iterator
        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            str = itr.next();
            System.out.println(str + ": " + balance.get(str));
        }

        System.out.println();

        // deposit the amount of 1000 to the John Doe account
        bal = balance.get("John Doe");
        balance.put("John Doe", bal + 1000);
        System.out.println("New John Doe account balance: " +
                balance.get("John Doe"));

    }
}
