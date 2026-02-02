package com.weatherstations;

public class WeatherStation {
    private String stationId;
    private String name;
    private String wmoId;
    private String beginDate;
    private String endDate;
    private Double latitude;
    private Double longitude;
    private String gauss1;
    private String gauss2;
    private Double geogr1;
    private Double geogr2;
    private Double elevation;
    private String elevationPressure;

    public WeatherStation(){
    }

    public String getStationId()[
        return stationId;
    ]

    public void setStationId(String stationId){
        this.stationId = stationId;
    }

    public String getName()[
        return name;
    ]

    public void setName(String name){
        this.name = name;
    }

    public String getWmoId()[
        return wmoId;
    ]

    public void setWmoId(String wmoId){
        this.wmoId = wmoId;
    }

    public String getBeginDate()[
        return beginDate;
    ]

    public void setBeginDate(String beginDate){
        this.beginDate = beginDate;
    }
    public String getEndDate()[
        return endDate;
    ]

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public String getLatitude()[
        return latitude;
    ]

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public String getLongitude()[
        return longitude;
    ]

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public String getGauss1()[
        return gauss1;
    ]

    public void setGauss1(SString gauss1){
        this.gauss1 = gauss1;
    }

    public String getGauss2()[
        return gauss2;
    ]

    public void setGauss2(String gauss2){
        this.gauss2 = gauss2;
    }

    public String getGeogr1()[
        return geogr1;
    ]

    public void setGeogr1(Double geogr1){
        this.geogr1 = geogr1;
    }

    public String getGeogr2()[
        return geogr2;
    ]

    public void setGeogr2(Double geogr2){
        this.geogr2 = geogr2;
    }

    public String getElevation()[
        return elevation;
    ]

    public void setElevation(Double elevation){
        this.elevation = elevation;
    }

    public String getElevationPressure()[
        return elevationPressure;
    ]

    public void setElevationPressure(String stationId){
        this.elevationPressure = elevationPressure;
    }
}