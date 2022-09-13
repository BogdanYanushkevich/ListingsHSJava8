package main.java.com.bogdan_yanushkevich.javacore.chapter20;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) throws IOException {

        // first output the data to a file
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("Can`t open the file");
            return;
        } catch (IOException e) {
            System.out.println("IO exception " + e);
        }
        // and now enter the data from the file
        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();

            System.out.println("Received values: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("Can`t open the input file");
            return;
        } catch (IOException e) {
            System.out.println("IO exception " + e);
        }
    }
}

