package com.apc.booking.service;

import com.apc.booking.entity.Booking;
import com.apc.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking bookFlight(Long flightId, String username) {
        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setUsername(username);
        booking.setBookingStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(String username) {
        return bookingRepository.findByUsername(username);
    }
}
