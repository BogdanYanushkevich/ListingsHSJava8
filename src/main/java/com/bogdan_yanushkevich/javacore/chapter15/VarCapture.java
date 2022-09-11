package main.java.com.bogdan_yanushkevich.javacore.chapter15;

interface MyFunc {
    int func(int n);
}

public class VarCapture {
    public static void main(String[] args) {
        // Local variable that can be captured

        int num = 10;
        MyFunc myLambda = (n) -> {
            // This use of the num variable is allowed,
            // because it doesn't change

            int v = num + n;
            // But the following line of code is invalid because
            // it attempts to modify the value of the variable num

            // num++
            return v;
        };

        // And the following line of code will result in an error
        // because it actually violates the final state of the variable num

        // num = 9;
    }
}
