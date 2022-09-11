package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Apply Generic Function Interface
// with different types of lambda expressions

interface SomeFunc<T> {
    T func(T t);
}

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {

        // use string variant
        // functional interface SomeFunc
        SomeFunc<String> reverse = (str) -> {
            String result = " ";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda refers to " + reverse.func("Lambda"));
        System.out.println("Lambda refers to " + reverse.func("Expression"));

        // and now use the integer version
        // functional interface SomeFunc

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;

            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));
    }
}