package com.example.viaggi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Destinazione obbligatoria")
    private String destinazione;

    @NotNull(message = "Data obbligatoria")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TravelStatus stato = TravelStatus.IN_PROGRAMMA;

    public Travel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TravelStatus getStato() {
        return stato;
    }

    public void setStato(TravelStatus stato) {
        this.stato = stato;
    }
}
