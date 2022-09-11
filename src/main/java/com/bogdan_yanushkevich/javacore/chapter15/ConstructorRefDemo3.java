package main.java.com.bogdan_yanushkevich.javacore.chapter15;

// Implement a simple class factory,
//using constructor reference

interface MyFunc5<R, T> {
    R func(T n);
}

//Simple generic class

class MyClass3<T> {
    private T val;

    // Constructor that takes one parameter
    MyClass3(T v) {
        val = v;
    }

    //The default constructor. This constructor is this program is NOT used

    MyClass3() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

// Simple non-generic class
class MyClass4 {
    String str;

    MyClass4(String s) {
        str = s;
    }

    //The default constructor. This constructor is this program is NOT used
    MyClass4() {
        str = " ";
    }

    String getVal() {
        return str;
    }

}

public class ConstructorRefDemo3 {

    // Factory method for objects of different classes.
    // Each class must have its own constructor,
    // taking one parameter of type T. And the parameter R
    // denotes the type of object being created
    static <R, T> R myClassFactory(MyFunc5<R, T> cons, T v) {
        return cons.func(v);
    }


    public static void main(String[] args) {

        // Create a reference to the constructor of the MyClass class.
        // Here, the constructor is called in the new operation,
        // accepting argument

        MyFunc5<MyClass3<Double>, Double> myClassCons = MyClass3<Double>::new;

        // create an instance of the class type MyClass, using factory method

        MyClass3<Double> mc = myClassFactory(myClassCons, 100.1);

        // use the newly created instance class MyClass
        System.out.println("Value val in object "
                + "mc equal: " + mc.getVal());

        // A nd now create an instance of another class,
        // using myClassFactory() method


        MyFunc5<MyClass4, String> myClassCons2 = MyClass4::new;

        MyClass4 mc2 = myClassFactory(myClassCons2, "Lambda");

        // use the newly created instance of class MyClass
        System.out.println("str value in object "
                + "mc2 is: " + mc2.getVal());
    }
}
