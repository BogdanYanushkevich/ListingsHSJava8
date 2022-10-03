package main.java.com.bogdan_yanushkevich.javacore.chapter28;
//A simple example of a program that allows
//experiment with the effect of change
//threshold value and level of concurrency
//executing tasks in the ForkJoinTask class

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
//The ForkJoinTask class transforms (via the RecursiveAction class) element values
//array of type douye to their square roots


class Transform extends RecursiveAction {
    // Sequential execution threshold, constructor-installed
    int seqThreshold;
    //processed array
    double[] data;

    // determine the part of the processed data
    int start, end;

    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }
    // This method performs a parallel calculation

    @Override
    protected void compute() {
        // If the number of elements is less than the threshold
        //values, perform further processing
        if ((end - start) < seqThreshold) {
            //In the following code snippet, the element by even
            //index is assigned its square root
            //initial value, and the element at an odd index - the cube root of its initial value.
            //This code is only for consuming CPU time to do effect of parallel execution
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            // otherwise continue splitting the data into smaller pieces
            // find the middle
            int middle = (start + end) / 2;

            //launch new subtasks for execution,
            //using split data
            invokeAll(new Transform(data, start, middle, seqThreshold), (new Transform(data, middle, end, seqThreshold)));
        }
    }
}

// demonstrate parallel execution
public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

    /*    if (args.length != 2) {
            System.out.println("Using: " + "FJExperiment parallelism threshold ");
            return;
        }*/
        pLevel = 6;
        threshold = 1000;

        //These variables are used to measure task execution time
        long beginT, endT;
        // Create a task pool. note to set the level of parallelism
        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);

        //start measuring task execution time
        beginT = System.nanoTime();

        // run the main task of type ForkJoinTask
        fjp.invoke(task);

        // complete task time measurement
        endT = System.nanoTime();

        System.out.println("Parallel level: " + pLevel);
        System.out.println("Sequence threshold " + " processing: " + threshold);
        System.out.println("Elapsed time: " + (endT - beginT) + "ns");
        System.out.println();
    }
}
