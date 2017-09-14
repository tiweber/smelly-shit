package de.senacor.smelly.shit;

import de.senacor.smelly.shit.model.GoldSensorData;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldWeatherStationTest {

    private GoldWeatherStation sut;

    @Before
    public void setUp() throws Exception {
        sut = new GoldWeatherStation();
    }

    @Test
    public void validTemperature2() throws Exception {

        GoldSensorData sensorData = sut.getSensorData();

        assertThat(sensorData.getCelsiusTemperature())
                .isNotNull()
                .isBetween(-30f, 50f);
    }

    @Test
    public void validForecast() throws Exception {

        GoldSensorData sensorData = sut.getSensorData();

        assertThat(sensorData.getForecast())
                .isNotEmpty();
    }
}