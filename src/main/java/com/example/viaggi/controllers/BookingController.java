package com.example.viaggi.controllers;

import com.example.viaggi.entities.Booking;
import com.example.viaggi.services.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(
            @RequestParam UUID employeeId,
            @RequestParam UUID travelId,
            @RequestParam LocalDate dataRichiesta,
            @RequestParam(required = false) String note
    ) {
        return bookingService.createBooking(employeeId, travelId, dataRichiesta, note);
    }

}
