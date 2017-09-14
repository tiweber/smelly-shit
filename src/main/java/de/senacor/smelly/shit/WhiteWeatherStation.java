package de.senacor.smelly.shit;

import de.senacor.smelly.shit.model.WhiteSensorData;
import de.senacor.smelly.shit.sensor.DHT11HumiditySensor;
import de.senacor.smelly.shit.sensor.TMP36Sensor;

import java.time.Clock;
import java.time.LocalTime;

import static de.senacor.smelly.shit.sensor.TMP36Sensor.TEMP_MAX_KELVIN;
import static de.senacor.smelly.shit.sensor.TMP36Sensor.TEMP_MIN_KELVIN;

public class WhiteWeatherStation implements WeatherStation {

    private DHT11HumiditySensor humiditySensor = new DHT11HumiditySensor();

    private Clock clock = Clock.systemDefaultZone();

    private TMP36Sensor temperatureSensor = new TMP36Sensor();

    @Override
    public WhiteSensorData getSensorData() {
        WhiteSensorData whiteSensorData = new WhiteSensorData();
        whiteSensorData.setTime(LocalTime.now(clock));
        whiteSensorData.setHumidityPercentage((float) humiditySensor.get());
        whiteSensorData.setCelsiusTemperature(getTemperatureFromUnscaled(temperatureSensor.tempUnscaled()));
        return whiteSensorData;
    }

    protected float getTemperatureFromUnscaled(float unscaled) {
        return unscaled * (TEMP_MAX_KELVIN - TEMP_MIN_KELVIN) + TEMP_MIN_KELVIN - 273.15f;
    }
}
