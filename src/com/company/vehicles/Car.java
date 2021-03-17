package com.company.vehicles;

import java.awt.*;

public class Car extends Vehicle {
    static final int WHEELS = 4;
    int doorsNumber;

    public Car(int id, int doorsNumber, Color color, String remainPower) {
        super(id, WHEELS, color, remainPower, Energy.GASOLINE);
        this.doorsNumber = doorsNumber;
    }

    public Car(int id, int doorsNumber, Color color, String remainPower, Energy poweredBy) {
        super(id, WHEELS, color, remainPower, poweredBy);
        this.doorsNumber = doorsNumber;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

}
