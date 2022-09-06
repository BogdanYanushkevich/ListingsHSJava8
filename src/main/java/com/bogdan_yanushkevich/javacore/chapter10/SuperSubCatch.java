package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Catching exceptions of the general class Exception . ");
        } //catch (ArithmeticException e) { // ERROR: unreachable code !
        System.out.println("This code is generally unreachable.");
    }
}
