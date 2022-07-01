package com.example.dentistproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String idCard;
}
