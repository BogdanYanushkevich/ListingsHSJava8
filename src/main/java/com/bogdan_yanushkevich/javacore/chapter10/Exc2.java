package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class Exc2 {
    public static void main(String[] args) {
        int d, a;
        try { // check block of code
            d = 0;
            a = 42 / d;
            System.out.println("This will not be displayed.");
        } catch (ArithmeticException e) { // catch exception
            // division by zero
            System.out.println("Division by zero.");
        }
        System.out.println("After the catch statement.");
    }
}
