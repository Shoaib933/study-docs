package com.shubhgupta.practise.mainfiles;

import com.shubhgupta.practise.service.PracUtils;

import java.util.concurrent.*;

public class WorkerThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create a pool of 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                PracUtils.lineChange();
                PracUtils.localPrint("Task " + taskId + " executed by " + threadName);
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }

        executor.shutdown();
    }
}