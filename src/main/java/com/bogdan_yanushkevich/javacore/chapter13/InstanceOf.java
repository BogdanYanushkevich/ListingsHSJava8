package main.java.com.bogdan_yanushkevich.javacore.chapter13;

import java.util.Objects;

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

public class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A) {
            System.out.println("a is an instance of A");
        }
        if (b instanceof B) {
            System.out.println("b is an instance of B");
        }
        if (c instanceof C) {
            System.out.println("c is an instance of C");
        }
        if (c instanceof A) {
            System.out.println("c can be converted to type A");
        }
        if (a instanceof C) {
            System.out.println("a can be converted to type C");
        }
        System.out.println();

        // compare with derived types
        A ob;

        ob = d; // d object link
        System.out.println("ob linked d");
        if (ob instanceof D) {
            System.out.println("ob is instance d");
        }
        System.out.println();

        ob = c; // d object link
        System.out.println("ob linked c");
        if (ob instanceof D) {
            System.out.println("ob can be converted to type D");
        } else {
            System.out.println("ob can`t be converted to type D");
        }
        if (ob instanceof A) {
            System.out.println("ob can be converted to type A");
        }
        System.out.println();

        if (a instanceof Object) {
            System.out.println("a can be converted to type Object");
        }
        if (b instanceof Object) {
            System.out.println("b can be converted to type Object");
        }
        if (c instanceof Object) {
            System.out.println("c can be converted to type Object");
        }
        if (d instanceof Object) {
            System.out.println("d can be converted to type Object");
        }

    }
}
