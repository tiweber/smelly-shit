package de.senacor.smelly.shit;

import de.senacor.smelly.shit.model.WhiteSensorData;
import org.assertj.core.data.TemporalUnitWithinOffset;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;


public class WhiteWeatherStationTest {

    private WeatherStation sut;

    @Before
    public void setUp() throws Exception {
        sut = new WhiteWeatherStation();
    }

    @Test
    public void validTemperature() throws Exception {

        WhiteSensorData sensorData = sut.getSensorData();

        assertThat(sensorData.getCelsiusTemperature())
                .isNotNull()
                .isBetween(-30f, 50f);
    }

    @Test
    public void validHumidity() throws Exception {

        WhiteSensorData sensorData = sut.getSensorData();

        assertThat(sensorData.getHumidityPercentage())
                .isNotNull()
                .isPositive()
                .isLessThanOrEqualTo(100f);
    }

    @Test
    public void validLocalTime() throws Exception {

        WhiteSensorData sensorData = sut.getSensorData();

        assertThat(sensorData.getTime())
                .isNotNull()
                .isCloseTo(LocalTime.now(), new TemporalUnitWithinOffset(3, SECONDS));
    }
}