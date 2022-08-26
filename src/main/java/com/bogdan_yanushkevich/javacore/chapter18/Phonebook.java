package main.java.com.bogdan_yanushkevich.javacore.chapter18;

// Simple database of telephone numbers, built on property lists.

import java.io.*;
import java.util.*;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fin = null;
        boolean changed = false;

        // Trying to open file phonebook.dat

        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            // ignore missing file
        }

        /*If the phone book already exists, download existing phone numbers.*/
        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // allow the user to enter new names and phone numbers of subscribers

        do {
            System.out.println("Enter name" + "('exit' to complete) : ");
            name = br.readLine();
            if (name.equals("exit")) continue;
            System.out.println("Enter the number: ");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!name.equals("exit"));
        // save the phone book if it has changed
        if (changed) {
            FileOutputStream fout = new FileOutputStream("phonebook.dat");
            ht.store(fout, "Phonebook");
            fout.close();
        }

        do {
            System.out.println("Enter a name to search: " + "('exit') to complete):");
            name = br.readLine();
            if (name.equals("exit")) continue;
            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("exit"));
    }
}
