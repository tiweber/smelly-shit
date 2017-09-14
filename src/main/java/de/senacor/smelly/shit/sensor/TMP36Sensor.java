package de.senacor.smelly.shit.sensor;

import java.util.Random;

public class TMP36Sensor {
    public static final float TEMP_MIN_KELVIN = 273.15f - 30;

    public static final float TEMP_MAX_KELVIN = 273.15f + 50;

    public float tempUnscaled() {
        return new Random().nextFloat();
    }
}
