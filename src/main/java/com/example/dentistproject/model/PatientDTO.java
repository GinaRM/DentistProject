package com.example.dentistproject.model;

import java.time.LocalDate;


public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String idCard;

    private LocalDate  admissionDate;

    private Address address;

    public PatientDTO(String name, String lastName, String idCard, LocalDate admissionDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.idCard = idCard;
        this.admissionDate = admissionDate;
        this.address = address;
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
}
