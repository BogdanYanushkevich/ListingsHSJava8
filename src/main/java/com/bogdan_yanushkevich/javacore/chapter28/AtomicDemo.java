package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.atomic.AtomicInteger;

// A simple example of performing atomic operations
public class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}

class Shared3 {
    static AtomicInteger ai = new AtomicInteger(0);
}

// The execution flow in which the counter value is incremented
class AtomThread implements Runnable {
    String name;

    AtomThread(String n) {
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start thread" + name);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread " + name + " get: " + Shared3.ai.getAndSet(i));
        }
    }
}