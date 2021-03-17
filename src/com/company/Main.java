package com.company;

import com.company.vehicles.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    final static int CAPACITY = 10000;

    public static void main(String[] args) {
        BlockingQueue<Vehicle> vehiclesQueue = new ArrayBlockingQueue<Vehicle>(CAPACITY, true);
        AtomicBoolean isFinished = new AtomicBoolean(false);

        Producer producer = new Producer(vehiclesQueue, isFinished);
        Consumer consumer = new Consumer(vehiclesQueue, isFinished);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);

        pThread.start();
        cThread.start();
    }

}
