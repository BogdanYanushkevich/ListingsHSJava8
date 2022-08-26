package main.java.com.bogdan_yanushkevich.javacore.chapter18;

import java.util.*;

public class ArraysDemo {
    public static void main(String[] args) {
        // allocate and initialize an array
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = -3 * i;
        }
        // print , sort and output the contents of the array again
        System.out.print("Source array : ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted array: ");
        display(array);


        // fill an array and display its content
        Arrays.fill(array, 2, 6, -1);
        System.out.print("Array after calling the fill() method: ");
        display(array);

        // sort and display the contents of the array
        Arrays.sort(array);
        System.out.print("Array after resort : ");
        display(array);

        // perform a binary search for the value -9
        System.out.print("The value -9 is at the position: ");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);
    }

    static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
