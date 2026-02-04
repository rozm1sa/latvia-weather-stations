package com.weatherstations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stations")
@Tag(name = "Weather Stations", description = "API for managing weather station data in Latvia")
@SecurityRequirement(name = "bearerAuth")
public class WeatherStationController {
    
    private final WeatherStationService service;
    
    public WeatherStationController(WeatherStationService service) {
        this.service = service;
    }
    
    @Operation(
        summary = "Get all weather stations",
        description = "Retrieves a summary list of all weather stations with ID and name only"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Successfully retrieved list of stations",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = WeatherStationSummary.class)
            )
        ),
        @ApiResponse(
            responseCode = "401", 
            description = "Unauthorized - Invalid or missing bearer token",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "403", 
            description = "Forbidden - Access denied",
            content = @Content
        )
    })
    @GetMapping
    public List<WeatherStationSummary> getAllStations(){
        return service.getAllStationsSummary();
    }
    
    @Operation(
        summary = "Get weather station by ID",
        description = "Retrieves detailed information about a specific weather station"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Successfully retrieved station details",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = WeatherStation.class)
            )
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Station not found - returns null",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "401", 
            description = "Unauthorized - Invalid or missing bearer token",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "403", 
            description = "Forbidden - Access denied",
            content = @Content
        )
    })
    @GetMapping("/{stationId}")
    public WeatherStation getStationById(
        @Parameter(description = "Unique identifier of the weather station", example = "KALNCIEM")
        @PathVariable String stationId
    ) {
        return service.getStationById(stationId);
    }
}