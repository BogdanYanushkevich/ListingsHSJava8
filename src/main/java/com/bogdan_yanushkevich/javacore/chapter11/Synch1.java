package main.java.com.bogdan_yanushkevich.javacore.chapter11;


// this program is not synchronized

class CallMe1 {
     void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
        System.out.print("]");
    }
}

class Caller1 implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller1(CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target){
            target.call(msg);
        }
    }
}

class Synch1 {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller obj1 = new Caller(target, "Welcome");
        Caller obj2 = new Caller(target, "to synchronized");
        Caller obj3 = new Caller(target, "world");

        //wait thread complete

        try {
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
    }
}
