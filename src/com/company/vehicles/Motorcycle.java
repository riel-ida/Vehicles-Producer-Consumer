package com.company.vehicles;

import java.awt.*;

public class Motorcycle extends Vehicle {
    static final int WHEELS = 2;

    public Motorcycle(int id, Color color, String remainPower) {
        super(id, WHEELS, color, remainPower, Energy.GASOLINE);
    }

    public Motorcycle(int id, Color color, String remainPower, Energy poweredBy) {
        super(id, WHEELS, color, remainPower, poweredBy);
    }

}
