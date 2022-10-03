package main.java.com.bogdan_yanushkevich.javacore.chapter28;

// Extend the class to perform only a certain number of phases


import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }
    //to onAdvance() to perform a certain number of phases

    @Override
    protected boolean onAdvance(int p, int regParties) {
        //the following call to the println() method is required
        //for illustration purposes only. As a rule, the method
        //onAdvance() does not display the output data

        System.out.println("Phase " + p + " complete.\n");

        //if all phases are complete return true
        if (p == numPhases || regParties == 0) {
            return true;
            //Otherwise, return a boolean\
        }
        return false;
    }
}


public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1, 4);
        System.out.println("Start threads\n");
        new MyThread3(phsr, "A");
        new MyThread3(phsr, "B");
        new MyThread3(phsr, "C");
        // wait for the completion of a certain number of phases
        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }
        System.out.println("Phase Synchronizer completed.");
    }
}

// applying phase synchronizer type, applying Phase synchronizer type Phaser
class MyThread3 implements Runnable {
    Phaser phsr;
    String name;

    MyThread3(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Thread " + name + " start phase " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();
            // A short pause so as not to disrupt
            //the output order. This is done only for
            //demonstration, but not necessarily for
            //the proper functioning of the phase synchronizer.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
