package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class FinallyDemo {
    // throw an exception in a method
    static void procA() {
        try {
            System.out.println("In the body of the procA() method");
            throw new RuntimeException("Demo ");
        } finally {
            System.out.println("finally statement block in procA() method");
        }
    }
    // return control from the try statement block

    static void procB() {
        try {
            System.out.println("In the body of the procB() method");
            return;
        } finally {
            System.out.println("finally statement block in procB() method");
        }
    }

    // execute the try block as usual
    static void procC() {
        try {
            System.out.println("In the body of the procC() method");
        } finally {
            System.out.println("finally statement block in procC() method");
        }
    }

    public static void main(String args[]) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Caught exception : " + e);
        }
        procB();
        procC();
    }
}
