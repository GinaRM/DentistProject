package com.example.dentistproject.service;
import com.example.dentistproject.model.Address;
import com.example.dentistproject.model.Patient;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import com.example.dentistproject.model.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Test
    void addPatient() {


        Address address = new Address("calle", "1234", "localidad", "provincia");
        PatientDTO patientDTO = new PatientDTO("John","Doe","1234",LocalDate.now(), address);
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