package main.java.com.bogdan_yanushkevich.javacore.chapter15;

interface MyFunc4<T> {
    MyClass2<T> func(T n);
}

class MyClass2<T> {
    private T val;

    // This constructor takes one argument
    MyClass2(T v) {
        val = v;
    }

    MyClass2() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {

        //Create a reference to the constructor of the MyClass class.
        //The func() method from the MyFunc interface accepts
        //argument, so in the operation new is called
        //parameterized constructor of class MyClass,
        //not its default constructor

        MyFunc4<Integer> myClassCons = MyClass2<Integer>::new;

        // create an instance of class MyClass by reference to its constructor
        MyClass2<Integer> mc = myClassCons.func(100);

        //use the newly created instance class MyClass
        System.out.println("Value val in object mc is " + mc.getVal());
    }
}
