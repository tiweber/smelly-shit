package de.senacor.smelly.shit.sensor;

import java.util.Random;

public class WC733Forecaster {

    public static final int SUNNY = 0;
    public static final int CLOUDY = 1;
    public static final int UNLIKELY_RAINY = 2;
    public static final int LIKELY_RAINY = 3;
    public static final int DEFINITLY_RAINY = 4;

    public int forecast() {
        return new Random().nextInt(5);
    }
}
