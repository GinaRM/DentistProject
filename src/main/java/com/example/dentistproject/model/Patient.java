package com.example.dentistproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "patients")
@Getter @Setter
public class Patient {

@Id
@GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String idCard;
    private Date admissionDate;
    @OneToOne
    private Address address;
    private Set<Turn> turns;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public Patient() {
    }

    public Patient(Long id, String name, String lastName, String idCard, Date admissionDate, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idCard = idCard;
        this.admissionDate = admissionDate;
        this.address = address;
    }

    public Patient(String name, String lastName, String idCard, Date admissionDate, Address address) {

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