package com.apc.booking.controller;

import com.apc.booking.entity.Booking;
import com.apc.booking.service.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{flightId}")
    public Booking bookFlight(@PathVariable Long flightId, Authentication auth) {
        return bookingService.bookFlight(flightId, auth.getName());
    }

    @GetMapping
    public List<Booking> myBookings(Authentication auth) {
        return bookingService.getUserBookings(auth.getName());
    }
}
