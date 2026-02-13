package com.example.viaggi.controllers;

import com.example.viaggi.entities.Travel;
import com.example.viaggi.repositories.TravelRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/travels")
public class TravelController {

    private final TravelRepository travelRepository;

    public TravelController(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    // CREATE
    @PostMapping
    public Travel createTravel(@RequestBody @Valid Travel travel) {
        return travelRepository.save(travel);
    }

    // READ ALL
    @GetMapping
    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Travel getTravelById(@PathVariable UUID id) {
        return travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable UUID id) {
        travelRepository.deleteById(id);
    }
}
