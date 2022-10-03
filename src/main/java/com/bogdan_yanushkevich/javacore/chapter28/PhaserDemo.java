package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;


        System.out.println("Start threads");

        new MyThread2(phsr, "A");
        new MyThread2(phsr, "B");
        new MyThread2(phsr, "C");

        // wait for all threads to complete the execution of the first phase

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is complete.");

        // wait for all threads to complete the execution of the second phase

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is complete.");


        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " is complete.");

        // remove the main execution flow from registration
        phsr.arriveAndDeregister();

        if (phsr.isTerminated()) {
            System.out.println("Phase Synchronizer completed");
        }
    }
}

// applying phase synchronizer type, applying Phase synchronizer type Phaser
class MyThread2 implements Runnable {
    Phaser phsr;
    String name;

    MyThread2(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + "start first phase");
        phsr.arriveAndAwaitAdvance(); // notify about the achievement of the phase
        // A short pause so as not to disrupt the output order.
        //This is done only for demonstration purposes, but
        //not necessarily for the proper
        //functioning of the phase synchronizer.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + "start second phase");
        phsr.arriveAndAwaitAdvance(); // notify about the achievement of the phase
        // A short pause so as not to disrupt the output order.
        //This is done only for demonstration purposes, but
        //not necessarily for the proper
        //functioning of the phase synchronizer.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + "start third phase");
        phsr.arriveAndDeregister(); // notify about the achievement of the phase and deregister
    }
}