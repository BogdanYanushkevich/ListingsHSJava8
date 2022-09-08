package main.java.com.bogdan_yanushkevich.javacore.chapter13;

public class AssertDemo {
    // get random number generator
    static int val = 3;

    // return an integer value
    static int getnnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n;

        for (int i = 0; i < 10; i++) {
            n = getnnum();
            assert n > 0;
            System.out.println("n is " + n);
        }
    }
}
