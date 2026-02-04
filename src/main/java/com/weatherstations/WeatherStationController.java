package com.weatherstations;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class WeatherStationController {

    private final WeatherStationService service;

    public WeatherStationController(WeatherStationService service) {
        this.service = service;
    }

    @GetMapping
    public List<WeatherStationSummary> getAllStations(){
        return service.getAllStationsSummary();
    }

    @GetMapping("/{stationId}")
    public WeatherStation getStationById(@PathVariable String stationId) {
        return service.getStationById(stationId);
    }
}