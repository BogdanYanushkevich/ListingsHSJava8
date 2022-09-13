package main.java.com.bogdan_yanushkevich.javacore.chapter20;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Below are some numeric values in different formats");

        System.out.printf("Different integer formats: ");
        System.out.printf("%d %(d %+d %05d/n", 3, -3, 3, 3);

        System.out.println();
        System.out.printf("Floating point number format"
                + " default: % f\n", 1234567.123);
        System.out.printf("Negative number format with default floating point: "
                + "%,f\n", -1234567.123);
        System.out.printf("Another Negative Number Format with"
                + "floating point: %,(f\n", -1234567.123);
        System.out.println();

        System.out.printf("Alignment of positive and " +
                "negative numeric values:\n");
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
    }
}
