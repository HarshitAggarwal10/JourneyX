package com.apc.flight.service;

import com.apc.flight.entity.Flight;
import com.apc.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @SuppressWarnings("null")
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
