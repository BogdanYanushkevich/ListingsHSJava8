package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class MyExceptoin extends Exception {
    private int detail;

    MyExceptoin(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }
}

class ExceptionDemo {
    static void compute(int a) throws MyExceptoin {
        System.out.println("Compute method called(" + a + ")");
        if (a > 10) {
            throw new MyExceptoin(a);
        }
        System.out.println("Normal termination");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyExceptoin e) {
            System.out.println("Caught exception: " + e);
        }
    }
}