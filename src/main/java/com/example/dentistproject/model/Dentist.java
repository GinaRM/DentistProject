package com.example.dentistproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="dentists")

public class Dentist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String license;
    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> turns;

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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Set<Turn> getTurns() {
        return turns;
    }






}
