package com.weatherstations;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class WeatherStationController {

    @GetMapping
    public List<WeatherStationSummary> getAllStations(){
        return List.of();
    }

    @GetMapping("/{stationId}")
    public WeatherStation getStationById(@PathVariable String stationId) {
        return null;
    }
}