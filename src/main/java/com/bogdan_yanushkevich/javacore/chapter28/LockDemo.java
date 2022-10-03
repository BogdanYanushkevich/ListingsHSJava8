package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

// Public resource
class Shared2 {
    static int count = 0;
}

// Execution flow incrementing the counter value
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start thread" + name);

        try {
            // at first block counter
            System.out.println("Thread " + name + " waiting for block");
            lock.lock();
            System.out.println("Thread" + name + " block counter.");
            Shared2.count++;
            System.out.println("Thread" + name + ": " + Shared2.count);
            // and now switch the context, if possible
            System.out.println("Thread" + name + " waiting");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            {
                //unlock
                System.out.println("Thread " + name + " unlock counter");
                lock.unlock();

            }
        }
    }
}