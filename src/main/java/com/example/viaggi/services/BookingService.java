package com.example.viaggi.services;

import com.example.viaggi.entities.Booking;
import com.example.viaggi.entities.Employee;
import com.example.viaggi.entities.Travel;
import com.example.viaggi.repositories.BookingRepository;
import com.example.viaggi.repositories.EmployeeRepository;
import com.example.viaggi.repositories.TravelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EmployeeRepository employeeRepository;
    private final TravelRepository travelRepository;

    public BookingService(BookingRepository bookingRepository,
                          EmployeeRepository employeeRepository,
                          TravelRepository travelRepository) {
        this.bookingRepository = bookingRepository;
        this.employeeRepository = employeeRepository;
        this.travelRepository = travelRepository;
    }

    public Booking createBooking(UUID employeeId,
                                 UUID travelId,
                                 LocalDate dataRichiesta,
                                 String note) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));

        boolean esiste = bookingRepository
                .existsByEmployeeAndDataRichiesta(employee, dataRichiesta);

        if (esiste) {
            throw new RuntimeException("Dipendente già prenotato per questa data");
        }

        Booking booking = new Booking();
        booking.setEmployee(employee);
        booking.setTravel(travel);
        booking.setDataRichiesta(dataRichiesta);
        booking.setNote(note);

        return bookingRepository.save(booking);
    }
}
