package com.weatherstations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherStationServiceTest {

    @Mock
    private DataSourceClient dataSourceClient;

    @InjectMocks
    private WeatherStationService weatherStationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStationsSummary_ReturnsListOfSummaries() {
        // Arrange - Create test data
        WeatherStation station1 = new WeatherStation();
        station1.setStationId("STATION001");
        station1.setName("Test Station 1");

        WeatherStation station2 = new WeatherStation();
        station2.setStationId("STATION002");
        station2.setName("Test Station 2");

        when(dataSourceClient.fetchWeatherStations())
            .thenReturn(Arrays.asList(station1, station2));

        List<WeatherStationSummary> result = weatherStationService.getAllStationsSummary();

        assertEquals(2, result.size());
        assertEquals("STATION001", result.get(0).getStationId());
        assertEquals("Test Station 1", result.get(0).getName());
        assertEquals("STATION002", result.get(1).getStationId());
        assertEquals("Test Station 2", result.get(1).getName());
        
        verify(dataSourceClient, times(1)).fetchWeatherStations();
    }

    @Test
    void testGetStationById_WhenStationExists_ReturnsStation() {
        WeatherStation station = new WeatherStation();
        station.setStationId("STATION001");
        station.setName("Test Station");
        station.setLatitude(56.95);
        station.setLongitude(24.12);

        when(dataSourceClient.fetchWeatherStations())
            .thenReturn(Arrays.asList(station));

        WeatherStation result = weatherStationService.getStationById("STATION001");

        assertNotNull(result);
        assertEquals("STATION001", result.getStationId());
        assertEquals("Test Station", result.getName());
        assertEquals(56.95, result.getLatitude());
    }

    @Test
    void testGetStationById_WhenStationDoesNotExist_ReturnsNull() {
        WeatherStation station = new WeatherStation();
        station.setStationId("STATION001");
        station.setName("Test Station");

        when(dataSourceClient.fetchWeatherStations())
            .thenReturn(Arrays.asList(station));

        WeatherStation result = weatherStationService.getStationById("NONEXISTENT");
        assertNull(result);
    }

    @Test
    void testGetAllStationsSummary_WhenNoStations_ReturnsEmptyList() {
        when(dataSourceClient.fetchWeatherStations())
            .thenReturn(Arrays.asList());

        List<WeatherStationSummary> result = weatherStationService.getAllStationsSummary();
        assertTrue(result.isEmpty());
    }
}