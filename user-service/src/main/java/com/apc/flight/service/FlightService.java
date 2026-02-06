package com.apc.flight.service;

import com.apc.flight.entity.Flight;
import java.util.List;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> getAllFlights();
}
