package com.company;

import com.company.vehicles.*;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer implements Runnable {
    final int PRODUCTION_TIME_OUT = 60*1000;
    final int VEHICLE_TYPES = 5;
    Random random = new Random();

    private final BlockingQueue<Vehicle> vehiclesQueue;
    private final AtomicBoolean isFinished;

    public Producer(BlockingQueue<Vehicle> vehiclesQueue, AtomicBoolean isFinished) {
        this.vehiclesQueue = vehiclesQueue;
        this.isFinished = isFinished;
    }

    @Override
    public void run() {
        long end = System.currentTimeMillis() + PRODUCTION_TIME_OUT;
        while (System.currentTimeMillis() < end) {
            try {
                Vehicle randomVehicle = generateRandomVehicle();
                vehiclesQueue.put(randomVehicle);
//                System.out.println("\nProducer - Produced vehicle " + randomVehicle.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isFinished.compareAndSet(false, true);
        System.out.println("\nProducer - Finished producing.");
    }

    private Vehicle generateRandomVehicle() {
        Vehicle vehicle;
        int randomIndex = random.nextInt(VEHICLE_TYPES);

        switch(randomIndex) {
            case(0):
                vehicle = new Car(Vehicle.productionSequence.getAndIncrement(),
                        randomDoorsNumber(), randomColor(), randomRemainPower());
                break;
            case(1):
                vehicle = new ElectricCar(Vehicle.productionSequence.getAndIncrement(),
                        randomDoorsNumber(), randomColor(), randomRemainPower());
                break;
            case(2):
                vehicle = new Motorcycle(Vehicle.productionSequence.getAndIncrement(),
                        randomColor(), randomRemainPower());
                break;
            case(3):
                vehicle = new ElectricMotorcycle(Vehicle.productionSequence.getAndIncrement(),
                        randomColor(), randomRemainPower());
                break;
            default:
                vehicle = new Truck(Vehicle.productionSequence.getAndIncrement(), randomCargo(), randomColor(), randomRemainPower());
        }

        return vehicle;
    }

    private Color randomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }

    private String randomRemainPower() {
        DecimalFormat PercentFormat = new DecimalFormat("#%");
        return PercentFormat.format(Math.random());
    }

    private int randomDoorsNumber() {
        return random.nextInt(4) + 2;
    }

    private Truck.CargoAttached randomCargo() {
        int randomIndex = random.nextInt(Truck.CargoAttached.values().length);
        return Truck.CargoAttached.values()[randomIndex];
    }

}
