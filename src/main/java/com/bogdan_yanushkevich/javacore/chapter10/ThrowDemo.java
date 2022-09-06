package main.java.com.bogdan_yanushkevich.javacore.chapter10;

public class ThrowDemo {
    static void demoproc(){
        try {
            throw new NullPointerException("demo");
        }catch (NullPointerException e){
            System.out.println("Exception caught in demoproc() method body.");
            throw e; // rethrow the exception
        }
    }
    public static void main(String[] args) {

        try {
            demoproc();
        }catch (NullPointerException e){
            System.out.println("Rethrow: " + e);
        }
    }
}
