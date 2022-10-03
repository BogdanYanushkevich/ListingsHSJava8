package main.java.com.bogdan_yanushkevich.javacore.chapter11;


// Create second thread
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // create new second thread
        t = new Thread(this, "Demo thread");
        System.out.println("Child thread is created: " + t);
        t.start(); // start thread
    }

    // Entry point to the second thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread is interrupt.");
        }
        System.out.println("Child thread is completed.");
    }
}


class ThreadDemo {
    public static void main(String[] args) {
        new NewThread(); // create new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted.");
        }
        System.out.println("Main thread is completed.");
    }
}
