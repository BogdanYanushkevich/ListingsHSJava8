package main.java.com.bogdan_yanushkevich.javacore.chapter28;
// A simple example of using the RecursiveTask<V> class

// The RecursiveTask class, used to calculate the sum of the values of the elements in an array of type double

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Double> {
    // Sequential execution threshold
    final int seqThreshold = 500;
    //processed array
    double[] data;

    // determine the part of the processed data
    int start, end;

    Sum(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    // determine the sum of the values of elements in an array of type double
    protected Double compute() {
        double sum = 0;

        // If the number of elements is below the threshold value, then perform further processing sequentially
        if ((end - start) < seqThreshold) {
            // sum the values of elements in an array of type double
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            // otherwise continue splitting the data into smaller pieces
            // find the middle
            int middle = (start + end) / 2;

            //launch new subtasks for execution,
            //using split data

            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            // run each subtask by forking

            subTaskA.fork();
            subTaskB.fork();

            // wait for subtasks to complete and accumulate results
            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

// demonstrate parallel execution
public class RecurTaskDemo {
    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[5000];

        // initialize array nums interleaved positive and negative values
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }

        Sum task = new Sum(nums, 0, nums.length);
        //Run tasks of type ForkJoinTask. Pay
        //note that in this case to invoke() method returns result
        double summation = fjp.invoke(task);

        System.out.println("Summation " + summation);
    }
}
