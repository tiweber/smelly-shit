package de.senacor.smelly.shit.sensor;

import java.util.Random;

public class DHT11HumiditySensor {

    public double get() {
        return new Random().nextDouble() * 100;
    }
}
