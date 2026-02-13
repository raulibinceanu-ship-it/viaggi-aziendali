package com.example.viaggi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username obbligatorio")
    private String username;

    @NotBlank(message = "Nome obbligatorio")
    private String nome;

    @NotBlank(message = "Cognome obbligatorio")
    private String cognome;

    @Email(message = "Email non valida")
    @NotBlank(message = "Email obbligatoria")
    private String email;

    private String immagineProfilo;

    public Employee() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImmagineProfilo() {
        return immagineProfilo;
    }

    public void setImmagineProfilo(String immagineProfilo) {
        this.immagineProfilo = immagineProfilo;
    }
}