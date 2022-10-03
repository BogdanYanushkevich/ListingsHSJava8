package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

//public resource
class Shared {
    static int count = 0;
}

//Thread, increase counter value by one
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Start thread: " + name);
        try {
            //At first get permission
            System.out.println("Thread" + name + " waiting permission.");
            sem.acquire();
            System.out.println("Thread" + name + " get permission");
            // get access to a public resource
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + " :" + Shared.count);

                // allow context switching if possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // release permission
        System.out.println("Thread" + name + "release permission");
        sem.release();
    }
}

//Thread decrease count value
class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Start thread: " + name);
        try {
            //At first get permission
            System.out.println("Thread" + name + " waiting permission.");
            sem.acquire();
            System.out.println("Thread" + name + " get permission");
            // get access to a public resource
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + " :" + Shared.count);

                // allow context switching if possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        // release permission
        System.out.println("Thread" + name + "release permission");
        sem.release();
    }
}

