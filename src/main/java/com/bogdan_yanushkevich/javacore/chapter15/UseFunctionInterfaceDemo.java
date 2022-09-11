package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Use predefined functional Function interface

import java.util.function.Function;

public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {

        // This block lambda expression evaluates the factorial of an integer value.
        // For this purpose, this time the Function interface is used.

        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 0; i <= n; i++) {
                result = i + result;
            }
            return result;
        };

        System.out.println("The factorial of 3 is " + factorial.apply(3));
        System.out.println("The factorial of 5 is " + factorial.apply(5));
    }
}
