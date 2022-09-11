package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Another functional interface

interface NumericTest {
    boolean test(int n);
}

public class LambdaDemo2 {
    public static void main(String[] args) {

        // Lambda expression that checks if 1 is an even number

        NumericTest isEven = (n) -> (n % 2) == 0;

        if (isEven.test(10)) {
            System.out.println("Number 10 is even");
        }
        if (!isEven.test(9)) {
            System.out.println("Number 9 is not even");
        }


        // And now use the lambda expression,
        // which checks if the number is non-negative

        NumericTest isNonNeg = (n) -> n >= 0;

        if (isNonNeg.test(1)){
            System.out.println("1 is non negative value");
        }
        if (!isNonNeg.test(-1)){
            System.out.println("1 is negative value");
        }

    }

}
