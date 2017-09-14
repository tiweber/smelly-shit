package de.senacor.smelly.shit.model;

public class GoldSensorData extends WhiteSensorData {

    private Float celsiusTemperature2;

    private String forecast;

    public Float getCelsiusTemperature2() {
        return celsiusTemperature2;
    }

    public void setCelsiusTemperature2(Float celsiusTemperature2) {
        this.celsiusTemperature2 = celsiusTemperature2;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
