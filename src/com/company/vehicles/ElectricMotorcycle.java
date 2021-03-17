package com.company.vehicles;

import java.awt.*;

public class ElectricMotorcycle extends Motorcycle {

    public ElectricMotorcycle(int id, Color color, String remainPower) {
        super(id, color, remainPower, Energy.ELECTRICITY);
    }

}
