package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class HalfSyncCounter {

    private final AtomicInteger counter = new AtomicInteger();
    private int syncCounter;
    private final Object lock = new Object();

    public void increment() {
        if (!nextValue(1)) {
            synchronized (lock) {
                syncCounter++;
            }
        }
    }


    public boolean nextValue(int nextValue) {
        int current = counter.get(); // volatile read
        int newValue = current + nextValue;
        return counter.compareAndSet(current, newValue);
    }

    public int result() {
        System.out.println("syncCounter = " + syncCounter);
        if (syncCounter == 0) {
            return counter.get();
        }
        nextValue(syncCounter);
        syncCounter = 0;
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        var counter = new HalfSyncCounter();
        var thread = new Thread(() -> {
            for(var i = 0; i < 100_000; i++) {
                counter.increment();
            }
        });
        thread.start();
        for(var i = 0; i < 100_000; i++) {
            counter.increment();
        }
        thread.join();
        System.out.println(counter.result());
        System.out.println(counter.result());
    }
}

