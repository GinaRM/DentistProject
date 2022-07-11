package com.example.dentistproject.service;

import com.example.dentistproject.model.Address;
import com.example.dentistproject.model.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import java.time.LocalDate;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Test
    void addPatient() {
        Address address = new Address("i hate", "unit", "tests", "a lot");
        PatientDTO patientDTO = new PatientDTO("John", "Doe", "2587", LocalDate.now(), address);
        patientService.addPatient(patientDTO);
        PatientDTO patientDTO1;
        try {
            patientDTO1 = patientService.readPatient(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(patientDTO1 != null);

    }

    @Test
    void getAllPatients() {
        Set<PatientDTO> patientDTOS = patientService.getAllPatients();
        Assert.assertTrue(!patientDTOS.isEmpty());
        Assert.assertTrue(patientDTOS.size() >= 1);
        System.out.println(patientDTOS);
    }
    @Test
    void deletePatient() {
        patientService.deletePatient(2L);
        try {
            Assert.assertTrue(patientService.readPatient(1L) == null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}