package main.java.com.bogdan_yanushkevich.javacore.chapter15;

 interface StringFunc {
    String func(String n);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args){

        // This block expression is reversed
        // order of characters in a string

        StringFunc reverse = (str) -> {
            String result = " ";
            int i;

            for (i = str.length()-1; i >=0; i--){
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda refers to "+ reverse.func("Lambda"));
        System.out.println("Lambda refers to "+ reverse.func("Expression"));
    }
}
