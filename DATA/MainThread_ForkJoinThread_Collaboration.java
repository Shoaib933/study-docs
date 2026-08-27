package com.shubhgupta.practise.mainfiles;
import java.util.concurrent.*;

class SumTask_MainThreadCollab extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;

    public SumTask_MainThreadCollab(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 3) {  // base case: small chunk
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            System.out.println(Thread.currentThread().getName() + " computed sum " + sum);
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork();                  // run left async
            int rightResult = right.compute(); // current thread computes right
            int leftResult = left.join(); // wait for left
            return leftResult + rightResult;
        }
    }
}

public class MainThread_ForkJoinThread_Collaboration {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1; // array = 1..10

        ForkJoinPool pool = new ForkJoinPool();

        // Main thread delegates first half to ForkJoinPool
        SumTask forkJoinTask = new SumTask(arr, 0, arr.length / 2);
        ForkJoinTask<Integer> future = pool.submit(forkJoinTask);

        // Meanwhile, main thread computes second half directly
        int mainThreadSum = 0;
        for (int i = arr.length / 2; i < arr.length; i++) {
            mainThreadSum += arr[i];
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName() + " computed sum " + mainThreadSum);

        // Merge results: main + ForkJoinPool result
        int forkJoinResult = future.join(); // wait for pool to finish
        int total = mainThreadSum + forkJoinResult;

        System.out.println("Final Total Sum = " + total);

        pool.shutdown();
    }
}

//    Main thread:
//
//    Submits a ForkJoinTask to compute sum of first half.
//
//    Simultaneously computes sum of second half itself.
//
//            ForkJoinPool:
//
//    Worker threads take the task and compute in parallel.
//
//            Synchronization:
//
//            future.join() → ensures the main thread waits for the pool’s result before merging.
//
//    Collaboration:
//
//    Both main thread and worker threads are working at the same time.
//
//    This shows how you can split work between the manager (main thread) and team (ForkJoinPool).

