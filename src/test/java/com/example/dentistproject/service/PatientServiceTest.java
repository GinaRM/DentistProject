package com.example.dentistproject.service;

import com.example.dentistproject.model.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Test
    void addPatient() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Johnny");
        patientDTO.setLastName("Doe");
        patientService.addPatient(patientDTO);
    }

    @Test
    void readPatient() {
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatient() {
    }

    @Test
    void getAllPatients() {
    }
}