package com.apc.flight.controller;

import com.apc.flight.entity.Flight;
import com.apc.flight.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // ADMIN only
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    // USER + ADMIN
    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }
}
