package de.senacor.smelly.shit.model;

import java.time.LocalTime;

public class WhiteSensorData {
    private LocalTime time;

    private Float celsiusTemperature;

    private Float humidityPercentage;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Float getCelsiusTemperature() {
        return celsiusTemperature;
    }

    public void setCelsiusTemperature(Float celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }

    public Float getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(Float humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }
}
