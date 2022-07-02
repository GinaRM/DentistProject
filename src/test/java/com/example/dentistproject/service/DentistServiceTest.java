package com.example.dentistproject.service;

import com.example.dentistproject.model.DentistDTO;
import com.example.dentistproject.model.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DentistServiceTest {
    @Autowired
    DentistService dentistService;




    @Test
    void addDentist() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Will");
        dentistDTO.setLastName("Smith");
        dentistDTO.setLicense("1234");
        dentistService.addDentist(dentistDTO);
    }

    @Test
    void updateDentist() {
    }

    @Test
    void getAllDentist() {
    }

    @Test
    void getDentistById() {
    }

    @Test
    void deleteDentist() {
    }
}