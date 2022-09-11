package main.java.com.bogdan_yanushkevich.javacore.chapter15;

//Functional interface for operations
//over character strings

interface StringFunc3 {
    String func(String n);
}

class MyStringOps1 {

    // static method that changes the order sequence of characters in a string

    String strReverse(String str) {
        String result = " ";
        int i;

        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo2 {
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

        // create an object of type MyStringOps
        MyStringOps1 stringOps = new MyStringOps1();


        //And now a reference to the strReverse() instance method
        //passed to the stringOp method

        outStr = stringOp(stringOps::strReverse, inStr);


        System.out.println("Source string: " + inStr);
        System.out.println("Inverted string: " + outStr);

    }

}
