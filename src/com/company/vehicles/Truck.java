package com.company.vehicles;

import java.awt.*;

public class Truck extends Vehicle {
    static final int WHEELS = 18;
    CargoAttached cargo;

    public enum CargoAttached {
        FOOD,
        CLOTHING,
        FURNITURE,
        ELECTRONICS
    }

    public Truck(int id, CargoAttached cargo, Color color, String remainPower) {
        super(id, WHEELS, color, remainPower, Energy.DIESEL);
        this.cargo = cargo;
    }

    public CargoAttached getCargo() {
        return cargo;
    }

}
