package com.example.dentistproject.model;


import java.time.LocalDate;
import java.util.Date;


public class TurnDTO {
    private long id;
    private Dentist dentist;
    private Patient patient;
    private LocalDate date;

    public TurnDTO(Dentist dentist, Patient patient, LocalDate date) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
