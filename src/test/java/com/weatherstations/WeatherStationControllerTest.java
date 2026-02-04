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

class WeatherStationControllerTest {

    @Mock
    private WeatherStationService weatherStationService;

    @InjectMocks
    private WeatherStationController weatherStationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStations_ReturnsStationList() {
        WeatherStationSummary summary1 = new WeatherStationSummary("STATION001", "Station 1");
        WeatherStationSummary summary2 = new WeatherStationSummary("STATION002", "Station 2");
        
        when(weatherStationService.getAllStationsSummary())
            .thenReturn(Arrays.asList(summary1, summary2));

        List<WeatherStationSummary> result = weatherStationController.getAllStations();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("STATION001", result.get(0).getStationId());
        assertEquals("Station 1", result.get(0).getName());
        
        verify(weatherStationService, times(1)).getAllStationsSummary();
    }

    @Test
    void testGetAllStations_WhenNoStations_ReturnsEmptyList() {
        when(weatherStationService.getAllStationsSummary())
            .thenReturn(Arrays.asList());

        List<WeatherStationSummary> result = weatherStationController.getAllStations();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetStationById_WhenStationExists_ReturnsStation() {
        WeatherStation station = new WeatherStation();
        station.setStationId("STATION001");
        station.setName("Test Station");
        station.setLatitude(56.95);
        
        when(weatherStationService.getStationById("STATION001"))
            .thenReturn(station);

        WeatherStation result = weatherStationController.getStationById("STATION001");

        assertNotNull(result);
        assertEquals("STATION001", result.getStationId());
        assertEquals("Test Station", result.getName());
        assertEquals(56.95, result.getLatitude());
    }

    @Test
    void testGetStationById_WhenStationDoesNotExist_ReturnsNull() {
        when(weatherStationService.getStationById("NONEXISTENT"))
            .thenReturn(null);

        WeatherStation result = weatherStationController.getStationById("NONEXISTENT");

        assertNull(result);
    }
}