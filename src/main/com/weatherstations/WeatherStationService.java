package com.weatherstations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherStationService{

    @Autowired
    private DataSourceClient dataSourceClient;

    public List<WeatherStationSummary> getAllStationsSummary(){
        List<WeatherStation> allStations = dataSourceClient.fetchWeatherStations();
        return allStations.stream()
            .map(station -> new WeatherStationSummary(station.getStationId(), station.getName()))
            .collect(Collectors.toList());
    }
    
    public WeatherStation getStationById(String stationId){
        List<WeatherStation> allStations = dataSourceClient.fetchWeatherStations();
        return allStations.stream()
            .filter(station -> station.getStationId(). equals(stationId))
            .findFirst()
            .orElse(null);
    }
}