package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Demonstrate the use of a reference to a generic method declared in a non-generic class

// functional interface to process an array of values and return an integer result

interface MyFunc2<T> {
    int func(T[] vals, T v);
}

// This class defines the countMatching() method,
// returning the number of elements in the array,
// equal to the specified value. Note that the countMatching() method is generic,
// whereas the MyArrayOps class is non-generic

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }
        return count;
    }
}

public class GenericMethodRefDemo {

    // As the first parameter of this method the functional interface MyFunc is specified,
    // and as two other parameters - an array and value, both types of T
    static <T> int myOp(MyFunc2<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};
        int count;

        count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("The vals array contains " + count + " number four");

        count = myOp(MyArrayOps::<String>countMatching, strs, "Two");

        System.out.println("The strs array contains " + count + " number two");

    }
}
