package main.java.com.bogdan_yanushkevich.javacore.chapter11;

class NewThread2 implements Runnable {
    String name; // thread name
    Thread t;

    NewThread2(String threadName) {
        // create new second thread
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Child thread is created: " + t);
        t.start(); // start thread
    }

    // Entry point to the second thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupt.");
        }
        System.out.println(name + " completed.");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("One"); // start threads
        new NewThread2("Two");
        new NewThread2("Three");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted.");
        }
        System.out.println("Main thread is completed.");
    }
}
