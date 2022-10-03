package main.java.com.bogdan_yanushkevich.javacore.chapter28;

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();

        new MakeString(exgr);
        new UseString(exgr);

    }
}

class MakeString implements Runnable {
    Exchanger<String> e;
    String str;

    MakeString(Exchanger<String> c) {
        e = c;
        str = "";
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            // fill the buffer
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }

            try {
                // exchange a filled buffer for an empty one
                str = e.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Thread type Thread using a character string
class UseString implements Runnable {
    Exchanger<String> e;
    String str;

    UseString(Exchanger<String> c) {
        e = c;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                // exchange a filled buffer for an empty on
                str = e.exchange("");
                System.out.println("Get: " + str
                );
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}