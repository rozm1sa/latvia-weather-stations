package com.weatherstations;

public class WeatherStationSummary{
    private String stationId;
    private String name;

    public WeatherStationSummary() {
    }

    public WeatherStationSummary(String stationId, String name){
        this.stationId = stationId;
        this.name = name;
    }



    public String getStationId(){
        return stationId
    }

    public void setStationId(){
        this.stationId = stationId;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

}