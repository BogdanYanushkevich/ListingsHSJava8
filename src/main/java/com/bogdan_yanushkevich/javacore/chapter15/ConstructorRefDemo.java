package main.java.com.bogdan_yanushkevich.javacore.chapter15;

//Demonstrate using a constructor reference

// The functional interface MyFunc defines
// a method that returns a reference to the class MyClass

interface MyFunc3 {
    MyClass func(int n);
}

class MyClass1 {
    private int val;

    // This constructor takes one argument
    MyClass1(int v) {
        val = v;
    }

    MyClass1() {
        val = 0;
    }

    int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {

        //Create a reference to the constructor of the MyClass class.
        //The func() method from the MyFunc interface accepts
        //argument, so in the operation new is called
        //parameterized constructor of class MyClass,
        //not its default constructor

        MyFunc3 myClassCons = MyClass::new;

        // create an instance of class MyClass by reference to its constructor
        MyClass mc = myClassCons.func(100);

        //use the newly created instance class MyClass
        System.out.println("Value val in object mc is " + mc.getVal());
    }
}
