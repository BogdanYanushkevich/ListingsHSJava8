package main.java.com.bogdan_yanushkevich.javacore.chapter13;

public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();

        ob.i = 10;

        System.out.println("Content of ob.i before calling platform-specific method : " + ob.i);

        ob.test();

        System.out.println(" The contents of ob .i after the call platform-specific method: " + ob.i);

    }

    // declare platform specific method
    public native void test();

    // load a DLL containing a static method

    static {
        System.loadLibrary("NativeDemo");
    }
}
