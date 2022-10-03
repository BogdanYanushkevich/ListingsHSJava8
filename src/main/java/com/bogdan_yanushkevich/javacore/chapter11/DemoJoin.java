package main.java.com.bogdan_yanushkevich.javacore.chapter11;

class NewThread3 implements Runnable {
    String name; // thread name
    Thread t;

    NewThread3(String threadName) {
        // create new second thread
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread:  " + t);
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

public class DemoJoin {
    public static void main(String[] args) {
        NewThread3 obj1 = new NewThread3("One"); // start threads
        NewThread3 obj2 = new NewThread3("Two");
        NewThread3 obj3 = new NewThread3("Three");

        System.out.println("Thread One is started: " + obj1.t.isAlive());
        System.out.println("Thread Two is started: " + obj2.t.isAlive());
        System.out.println("Thread Three is started: " + obj3.t.isAlive());

        //wait thread complete
        try {
            System.out.println("Waiting for threads to complete");
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted.");
        }
        System.out.println("Thread One is started: " + obj1.t.isAlive());
        System.out.println("Thread Two is started: " + obj2.t.isAlive());
        System.out.println("Thread Three is started: " + obj3.t.isAlive());
    }
}
