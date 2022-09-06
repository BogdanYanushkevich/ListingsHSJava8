package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class ChainExcDemo {
    static void demoproc() {
        // create exception
        NullPointerException e = new NullPointerException("High level");
        // add a reason of the exception
        e.initCause(new ArithmeticException("reason"));
        throw e;
    }

    public static void main(String[] args){
        try {
            demoproc();
        }catch (NullPointerException e){
            // view high level exception
            System.out.println("Caught exception: " + e);

            // view the exception that caused
            // for high level exception
            System.out.println("Root cause: " + e.getCause());
        }
    }
}
