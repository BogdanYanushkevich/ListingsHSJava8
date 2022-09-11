package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Use method reference to find
// is the maximum value in the collection

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
    private int val;

    MyClass(int v) {
        val = v;
    }

    int getVal() {
        return val;
    }
}

public class UseMethodRef {

    // The compare() method, which is compatible with a similar method,
    // defined in the Comparator<T> interface

    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {

        int maxVal;
        ArrayList<MyClass> a1 = new ArrayList<MyClass>();

        a1.add(new MyClass(1));
        a1.add(new MyClass(4));
        a1.add(new MyClass(2));
        a1.add(new MyClass(9));
        a1.add(new MyClass(3));
        a1.add(new MyClass(8));

        // find the maximum value using compareMC() method
        MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMC);
        System.out.println("Max value equals: " + maxValObj.getVal());
    }
}
