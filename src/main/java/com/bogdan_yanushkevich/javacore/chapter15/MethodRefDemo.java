package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Demonstrate a reference to a static method

//Functional interface for operations
//over character strings

interface StringFunc2 {
    String func(String n);
}

// This class defines a static strReverse() method
class MyStringOps {

    // static method that changes the order sequence of characters in a string

    static String strReverse(String str) {
        String result = " ";
        int i;

        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}


public class MethodRefDemo {

    // In this method, the functional interface
    // indicated as the type of its first
    // parameter. Therefore, he may be
    // passed any instance of this interface,
    // including the reference to the method

    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Lambda expressions boost Java efficiency";
        String outStr;

        // Here the reference to the strReverse() method is passed stringOp() method

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Source string: " + inStr);
        System.out.println("Inverted string: " + outStr);


    }
}
