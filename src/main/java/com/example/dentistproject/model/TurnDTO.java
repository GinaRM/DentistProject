package com.example.dentistproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TurnDTO {
    private long id;
    private Dentist dentist;
    private Patient patient;
    private Date date;

}
