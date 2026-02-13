package com.example.viaggi.repositories;

import com.example.viaggi.entities.Booking;
import com.example.viaggi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    boolean existsByEmployeeAndDataRichiesta(Employee employee, LocalDate dataRichiesta);


}
