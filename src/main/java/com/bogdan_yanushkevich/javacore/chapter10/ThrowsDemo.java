package main.java.com.bogdan_yanushkevich.javacore.chapter10;

// This program contains a bug and therefore cannot be compiled.
public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("In the body of the throwOne() method.");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Caught exception: " + e);
        }
    }
}
