package com.example.viaggi.repositories;

import com.example.viaggi.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TravelRepository extends JpaRepository<Travel, UUID> {
}
