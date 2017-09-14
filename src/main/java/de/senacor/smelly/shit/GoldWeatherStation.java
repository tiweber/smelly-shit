package de.senacor.smelly.shit;

import de.senacor.smelly.shit.model.GoldSensorData;
import de.senacor.smelly.shit.model.WhiteSensorData;
import de.senacor.smelly.shit.sensor.TMP36Sensor;
import de.senacor.smelly.shit.sensor.WC733Forecaster;

import static de.senacor.smelly.shit.sensor.WC733Forecaster.CLOUDY;
import static de.senacor.smelly.shit.sensor.WC733Forecaster.DEFINITLY_RAINY;
import static de.senacor.smelly.shit.sensor.WC733Forecaster.LIKELY_RAINY;
import static de.senacor.smelly.shit.sensor.WC733Forecaster.SUNNY;
import static de.senacor.smelly.shit.sensor.WC733Forecaster.UNLIKELY_RAINY;

public class GoldWeatherStation extends WhiteWeatherStation {

    private TMP36Sensor temperatureSensor2 = new TMP36Sensor();

    private WC733Forecaster weatherForecaster = new WC733Forecaster();

    @Override
    public GoldSensorData getSensorData() {
        WhiteSensorData whiteSensorData = super.getSensorData();
        GoldSensorData goldSensorData = new GoldSensorData();

        goldSensorData.setCelsiusTemperature(whiteSensorData.getCelsiusTemperature());
        goldSensorData.setHumidityPercentage(whiteSensorData.getHumidityPercentage());
        goldSensorData.setTime(whiteSensorData.getTime());

        goldSensorData.setCelsiusTemperature2(getTemperatureFromUnscaled(temperatureSensor2.tempUnscaled()));

        switch (weatherForecaster.forecast()) {
            case SUNNY:
                goldSensorData.setForecast("Sunny");
                break;
            case CLOUDY:
                goldSensorData.setForecast("Cloudy");
                break;
            case UNLIKELY_RAINY:
                goldSensorData.setForecast("Maybe rain, maybe not.");
                break;
            case LIKELY_RAINY:
                goldSensorData.setForecast("Umbrella strongly recommended.");
                break;
            case DEFINITLY_RAINY:
                goldSensorData.setForecast("UMBRELLA!!!");
                break;
            default:
                goldSensorData.setForecast("Forecast is broken. Stay at home.");
        }
        return goldSensorData;
    }
}
