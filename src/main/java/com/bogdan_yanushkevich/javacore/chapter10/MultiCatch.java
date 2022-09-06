package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int vals[] = {1, 2, 3};
        try {
            int result = a / b; // generate exception ArithmeticException
            vals[10] = 19; // generate exception ArrayIndexOutOfBoundsException
            // Both exceptions are caught in this catch statement
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exceptions :" + e);
        }
        System.out.println("After repeated interception.");
    }
}
