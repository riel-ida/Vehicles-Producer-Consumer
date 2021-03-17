package com.company.vehicles;

import java.awt.*;

public class ElectricCar extends Car {

    public ElectricCar(int id, int doors, Color color, String remainPower) {
        super(id, doors, color, remainPower, Energy.ELECTRICITY);
    }

}
