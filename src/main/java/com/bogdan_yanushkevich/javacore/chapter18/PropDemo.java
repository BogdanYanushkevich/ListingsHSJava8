package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Demonstrate the use of a property list

import java.util.*;

public class PropDemo {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson-City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        // get key set
        Set<?> states = capitals.keySet();

        // print all states and their capitals
        for (Object name : states) {
            System.out.println("Capital of the state " + name + " - "
                    + capitals.getProperty((String) name) + ".");
        }
        System.out.println();

        // find a state that is not in the list by specifying the default values
        String str = capitals.getProperty("Florida", "not found");
        System.out.println("Capital of the state Florida " + str + ".");
    }
}
