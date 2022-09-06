package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class NestTry {
    public static void main(String[] args) {

        try {

            int a = args.length;

        /* If no command line arguments are specified,in the next statement will generate
           exception due to division by zero .    */

            int b = 42 / a;

            System.out.println("a = " + a);

            try { //nested try block
            /* If one command line argument is given,
              then an exception due to division by zero
               will be generated in the following code. */

                if (a == 1) {
                    a = a / (a - a);
                }// Division by zero

                /* If two command line arguments are given,
                then an exception is thrown due to the exit
                outside the array. */
                if (a == 2) {
                    int c[] = {1};
                    c[42] = 99; //an out-of-bounds exception is thrown here
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index outside array :" + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("Division by zero: " + e);
        }
    }
}
