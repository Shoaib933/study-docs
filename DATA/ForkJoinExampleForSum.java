package com.shubhgupta.practise.mainfiles;

import com.shubhgupta.practise.service.PracUtils;

import java.util.concurrent.*;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 3) { // small enough, do directly
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork();                  // split left task
            int rightResult = right.compute(); // compute right side // recursion
            int leftResult = left.join(); // wait for left side

            return leftResult + rightResult;
        }
    }
}

public class ForkJoinExampleForSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(arr, 0, arr.length);
        int result = pool.invoke(task); // taking task and invoking it inside ForkJoinPool

        PracUtils.lineChange();
        PracUtils.localPrint("Sum = " + result);
    }
}


//    ForkJoinPool creates a pool of worker threads (usually equal to CPU cores).
//
//            task.compute():
//
//    If subarray length ≤ 3 → compute directly.
//
//    Else → split into two subproblems (left and right).
//
//    One subtask (left) is forked → assigned to a worker thread in the pool.
//
//    Current thread works on right.
//
//    After finishing right, it calls left.join() → waits for left’s result.
//
//    Finally combines both results.

