package com.example.dentistproject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="dentists")
@Getter
@Setter
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "license")
    private String license;
    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> turns;

    public Set<Turn> getTurns() {
        return turns;
    }

}
