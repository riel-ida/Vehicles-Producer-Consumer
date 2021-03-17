package com.company;

import com.company.vehicles.Car;
import com.company.vehicles.Truck;
import com.company.vehicles.Vehicle;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable {
    final int WAIT_TIME_OUT = 5*1000;

    private final BlockingQueue<Vehicle> vehiclesQueue;
    private final AtomicBoolean isFinished;

    public Consumer(BlockingQueue<Vehicle> vehiclesQueue, AtomicBoolean isFinished) {
        this.vehiclesQueue = vehiclesQueue;
        this.isFinished = isFinished;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Vehicle vehicle = vehiclesQueue.poll(WAIT_TIME_OUT, TimeUnit.MILLISECONDS);
                if(vehicle != null) {
                    displayVehicle(vehicle);
                } else if(isFinished.get()) {
                    System.out.println("\nConsumer - Finished consuming.");
                    break;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayVehicle(Vehicle vehicle) {
        String displayStr;

        String str = vehicle.getId() + "\n" +
                vehicle.getClass().getSimpleName() + "(" +
                "wheels" + vehicle.getWheels() +
                ", Color: " + vehicle.displayColor(vehicle.getColor()) +
                ", Remaining power: " + vehicle.getRemainPower() +
                ", Powered by " + vehicle.getPoweredBy();

        if (vehicle instanceof Car) {
            displayStr = str.concat(", " + ((Car) vehicle).getDoorsNumber() + " doors)\n");
            System.out.println(displayStr);
        } else if (vehicle instanceof Truck) {
            displayStr = str.concat(", Cargo attached: " + ((Truck) vehicle).getCargo() + ")\n");
            System.out.println(displayStr);
        } else {
            displayStr = str.concat(")\n");
            System.out.println(displayStr);
        }
    }

}
