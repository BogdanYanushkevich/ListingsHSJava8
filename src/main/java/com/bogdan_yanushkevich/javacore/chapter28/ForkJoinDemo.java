package main.java.com.bogdan_yanushkevich.javacore.chapter28;
// A simple example of the implementation of the "divide and conquer" strategy. In this example,
//the Recursive Action class is used

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


// The ForkJoinTask class transforms (via the RecursiveAction class) element values
//array of type douye to their square roots


class SqrtTransform extends RecursiveAction {
    //In this example, the threshold value is arbitrarily set to 1000.
    //In real code it
    //the optimal value can be determined in
    //as a result of profiling the executive system or experimentally
    final int seqThreshold = 1000;

    //processed array
    double[] data;

    // determine the part of the processed data
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    // This method performs a parallel calculation

    @Override
    protected void compute() {
        // If the number of elements is less than the threshold
        //values, perform further processing
        //successively
        if ((end - start) < seqThreshold) {
            // convert the value of each element
            //array to its square root
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            // otherwise continue splitting the data into smaller pieces
            // find the middle
            int middle = (start + end) / 2;

            //launch new subtasks for execution,
            //using split data
            invokeAll(new SqrtTransform(data, start, middle), (new SqrtTransform(data, middle, end)));
        }
    }
}
// demonstrate parallel execution

public class ForkJoinDemo {
    public static void main(String[] args) {
//create a task pool
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        double[] nums = new double[100000];
        // assign some values
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("Part of the original sequence:");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");


        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        // run main task type ForkJoinTask to execute
        fjp.invoke(task);

        System.out.println("Part of the converted\n" +
                "sequences (up to four decimal places): ");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}

