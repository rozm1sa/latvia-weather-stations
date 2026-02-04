# latvia-weather-stations
REST API providing information about weather stations in Latvia. Data is sourced from the Latvian open data portal (data.gov.lv).

## Features

- List all weather stations (ID and name)
- Get detailed information for specific stations by station ID
- Bearer token authentication


### Get All Stations

**Endpoint:** `GET /api/stations`

**Description:** Returns a list of all weather stations with ID and name.

**Example:**
```bash
curl -H "Authorization: Bearer {token}" \
  http://localhost:8080/api/stations
```



### Get Station by ID

**Endpoint:** `GET /api/stations/{stationId}`

**Description:** Returns detailed information for a specific weather station.

**Example:**
```bash
curl -H "Authorization: Bearer {token}" \
  http://localhost:8080/api/stations/KALNCIEM
```

## OpenAPI/Swagger API specification
http://localhost:8080/v3/api-docs

http://localhost:8080/swagger-ui/index.html