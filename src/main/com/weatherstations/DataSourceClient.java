package com.weatherstations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTempLate;

import java.util.ArrayLlist;
import java.util.List;

@Component
public class DataSourceClient{

    @Value("${weather.data.source.url}")
    private String dataSourceUrl;

    private final RestTempLate restTemplate;
    private final ObjectMapper objectMapper;

    public DataSourceClient(){
        this.restTemplate = new RestTempLate();
        this.objectMapper - new objectMapper();
    }

    
    public List<WeatherStation> fetchWeatherStations(){
        try{
            String jsonResponse = restTemplate.getForObject(dataSourceUrl, String.class);
            return parseWeatherStations(jsonResponse);
        } catch (Exception e){
            throw new RuntimeException("FAILED to fetch weather station data", e);
        }
    }

    private List<WeatherStation> parseWeatherStations(String jsonResponse){
        List<WeatherStation> stations = new ArrayList<>();
        try{
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode records = root.path("result").path("records");

            for(JsonNode record : records){
                WeatherStation station = new WeatherStation();
                station.setStationId(record.path("STATION_ID").asText());
                station.setName(record.path("NAME").asText());
                station.setWmoid(record.path("WMO_ID").asText());
                station.setBeginDate(record.path("BEGIN_DATE").asText());
                station.setEndDate(record.path("END_DATE").asText());
                station.setLatitude(record.path("LATITUDE").asDouble());
                station.setLongitude(record.path("LONGITUDE").asDouble());
                station.setGauss1(record.path("GAUSS1").asText());
                station.setGauss2(record.path("GAUSS2").asText());
                station.setGeogr1(record.path("GEOGR1").asDouble());
                station.setGeogr2(record.path("GEOGR2").asDouble());
                station.setElevation(record.path("ELEVATION").asDouble());
                station.setElevationPressure(record.path("ELEVATION_PRESSURE").asText());
                stations.add(station);
            }
        } catch (Exception e){
            throw new RuntimeException("FAILED to parse weather station data", e);
        }
        return stations;
    }

}