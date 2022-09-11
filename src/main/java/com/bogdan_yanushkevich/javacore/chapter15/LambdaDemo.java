package main.java.com.bogdan_yanushkevich.javacore.chapter15;

interface MyNumber {
    double getValue();
}

public class LambdaDemo {
    public static void main(String[] args) {

        MyNumber myNum; //declare a link to functional interface

        /* Here the lambda expression is simply
           constant expression. When it is assigned
           reference variable myNum, an instance of
           the class is obtained  in which the lambda expression
           implements getValue() method from function interface MyNumber       */

        myNum = () -> 123.45;

        // call the getValue() method provided
        // previously assigned lambda expression

        System.out.println("Fixed value: " + myNum.getValue());

        // And here we use a more complex expression

        myNum = () -> Math.random() * 100;

        // The following lines of code call the lambda expression
        // from the previous line of code

        System.out.println("Random value: " + myNum.getValue());

        System.out.println("Another random value: " + myNum.getValue());

        // Lambda expression must be compatible
        // by data type with an abstract method,
        // defined in the functional interface.
        // Therefore, the following line of code is wrong:

       // myNum = () -> "123.03" // Error!

    }
}
