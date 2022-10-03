package main.java.com.bogdan_yanushkevich.javacore.chapter11;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " enter in method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Class A is interrupt");
        }
        System.out.println(name + " try call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("B in method A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " enter in method B.bar()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Class B is interrupt");
        }
        System.out.println(name + " try call method A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("B in method A.last");
    }
}

public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Rival thread");
        t.start(); // get a lock on object in this thread of execution
        a.foo(b);
        System.out.println("Back to main thread");
    }
    public void run(){
        b.bar(a); // get a lock on object in other thread of execution
        System.out.println("Back to other thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
