package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        // get link to console

        con = System.console();

        // exit the program if the console is not available
        if (con == null) {
            return;
        }
        // read a line and output it
        str = con.readLine("Enter string: ");
        con.printf("Your string: %s\n", str);

    }
}
