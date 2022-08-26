package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Use default property list

import java.util.*;

public class PropDemoDef {
    public static void main(String[] args) {
        Properties defList = new Properties();
        defList.put("Florida", "Tellessy");
        defList.put("Wisconsin", "Madison");
        Properties capitals = new Properties(defList);
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

        // The state of Florida will now be found in the default list
        String str = capitals.getProperty("Florida");
        System.out.println("Capital of the state Florida - " + str + ".");
    }
}