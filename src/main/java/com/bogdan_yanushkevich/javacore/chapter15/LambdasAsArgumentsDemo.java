package main.java.com.bogdan_yanushkevich.javacore.chapter15;

interface StringFunc1 {
    String func(String n);
}

public class LambdasAsArgumentsDemo {

    /* The first parameter of this method is of type
       functional interface. Therefore, here
       you can pass a reference to any instance of this
       interface, including the instance created in
       lambda expression. And the second parameter means
       character string to be processed */
    static String stringOp(StringFunc1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda expressions make Java more efficient";

        String outStr;

        System.out.println("This is the original string: " + inStr);

        // Following is a simple lambda expression,
        // converting to uppercase all letters in the original
        // the string passed to the stringOp() method

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("This is a string in capital letters: " + outStr);

        // And here the block lambda expression is passed,
        // removes spaces from the original character string

        outStr = stringOp((str) -> {
            String result = " ";
            int i;

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;


        }, inStr);

        System.out.println("This is a string with spaces removed: " + outStr);

        // You can, of course, pass an instance
        // functional interface StringFunc,
        // created in the previous lambda expression.
        // For example, after the following declaration, the link
        // reverse is done per instance
        // interface StringFunc

        StringFunc1 reverse = (str) -> {
            String result = " ";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        // And now the reverse reference can be passed to
        // as the first parameter of the stringOp() method,
        // because it is done on an object of type StringFunc
        System.out.println("This is the reversed string: " + stringOp(reverse, inStr));
    }
}
