package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.CountDownLatch;

// Demonstrate the application of the CountdownLatch class
public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);

        System.out.println("Start thread");
        new Thread(new MyThread(cd1)).start();

        try {
            cd1.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread complete");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch c) {
        latch = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown(); // countdown
        }
    }
}