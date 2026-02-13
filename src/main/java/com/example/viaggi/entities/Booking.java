package com.example.viaggi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Data richiesta obbligatoria")
    private LocalDate dataRichiesta;

    private String note;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Travel travel;

    public Booking() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}