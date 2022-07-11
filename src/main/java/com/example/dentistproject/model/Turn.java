package com.example.dentistproject.model;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "turns")

public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDate date;

    public Turn(Dentist dentist, Patient patient, LocalDate date) {
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }



    public Turn() {
    }


}
