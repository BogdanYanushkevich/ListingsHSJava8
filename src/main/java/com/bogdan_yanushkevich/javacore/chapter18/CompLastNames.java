package main.java.com.bogdan_yanushkevich.javacore.chapter18;

/* Use the thenComparinq() method to sort accounts in depositors
first by last name, and then by first name */

import java.util.*;

class CompLastNames implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j;

        // find the index of the character that starts the last name
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

// sort depositors' accounts by full name if the names are the same
class CompThenByFirtsName implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j;

        return aStr.compareToIgnoreCase(bStr);

    }
}

class TreeMapDemo2A {
    public static void main(String[] args) {
        /*use the thenCoparing() method to create
        comparator that compares first surnames and then
        full name contributors if the last names are the same */
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst =
                compLN.thenComparing(new CompThenByFirtsName());

        // create a tree map
        TreeMap<String, Double> tm = new TreeMap<String, Double>(compLastThenFirst);

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

