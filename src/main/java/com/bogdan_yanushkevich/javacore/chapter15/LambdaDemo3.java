package main.java.com.bogdan_yanushkevich.javacore.chapter15;

interface NumericTest2 {
    boolean test(int n, int d);
}

public class LambdaDemo3 {
    public static void main(String[] args) {
        // This lambda expression checks if
        //is one number a multiple of another

        NumericTest2 isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2)) {
            System.out.println("Number 2 is " + " a multiple of 10");
        }
        if (!isFactor.test(10, 3)) {
            System.out.println("Number 3 isn`t " + " a multiple of 10");
        }
    }
}
