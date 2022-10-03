package main.java.com.bogdan_yanushkevich.javacore.chapter11;

// Suspension and resumption of performance flow in a modern way
class NewThread4 implements Runnable {
    String name;
    Thread t;
    boolean suspenfFlag;

    NewThread4(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspenfFlag = false;
        t.start(); // start thread
    }

    // Thread entry point
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspenfFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " is interrupt.");
        }
        System.out.println(name + " is complete.");
    }

    synchronized void mysuspend() {
        suspenfFlag = true;
    }

    synchronized void myresume() {
        suspenfFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {

        NewThread4 obj1 = new NewThread4("One");
        NewThread4 obj2 = new NewThread4("Two");


        try {
            Thread.sleep(1000);
            obj1.mysuspend();
            System.out.println("Suspend thread One");
            Thread.sleep(1000);
            obj1.myresume();
            System.out.println("Resume thread One");
            obj2.mysuspend();
            System.out.println("Suspend thread Two");
            Thread.sleep(1000);
            obj2.myresume();
            System.out.println("Resume thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupt");
        }

        // Wait threads are complete

        try{
            System.out.println("Waiting for threads to complete.");
            obj1.t.join();
            obj2.t.join();
        }catch (InterruptedException e){
            System.out.println("Main thread is complete.");
        }
    }
}
