package com.example.dentistproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "patients")

public class Patient {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String idCard;
    private LocalDate admissionDate;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address")
    private Address address;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Turn> turns;
    public Set<Turn> getTurns() {
        return turns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public Patient() {
    }

    public Patient(Long id, String name, String lastName, String idCard, LocalDate admissionDate, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idCard = idCard;
        this.admissionDate = admissionDate;
        this.address = address;
    }

    public Patient(String name, String lastName, String idCard, LocalDate admissionDate, Address address) {

        this.name = name;
        this.lastName = lastName;
        this.idCard = idCard;
        this.admissionDate = admissionDate;
        this.address = address;
    }




    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", admissionDate=" + admissionDate +
                ", address=" + address +
                '}';
    }
}
