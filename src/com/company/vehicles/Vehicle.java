package com.company.vehicles;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    //This field will be incremented by 1 with each vehicle production
    public static AtomicInteger productionSequence = new AtomicInteger(0);

    int id;
    int wheels;
    Color color;
    String remainPower;
    Energy poweredBy;

    enum Energy {
        ELECTRICITY,
        GASOLINE,
        DIESEL
    }

    public Vehicle(int id, int wheels, Color color, String remainPower, Energy poweredBy) {
        this.id = id;
        this.wheels = wheels;
        this.color = color;
        this.remainPower = remainPower;
        this.poweredBy = poweredBy;
    }

    public int getId() {
        return id;
    }

    public int getWheels() {
        return wheels;
    }

    public Color getColor() {
        return color;
    }

    public String getRemainPower() {
        return remainPower;
    }

    public Energy getPoweredBy() {
        return poweredBy;
    }

    public String displayColor(Color color) {
        return "[red=" + color.getRed() +
                ", green=" + color.getGreen() +
                ", blue=" + color.getBlue() +
                "]";
    }

}
