package com.apc.booking.service;

import com.apc.booking.entity.Booking;
import java.util.List;

public interface BookingService {
    Booking bookFlight(Long flightId, String username);
    List<Booking> getUserBookings(String username);
}
