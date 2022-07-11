package com.example.dentistproject.service;

import com.example.dentistproject.model.DentistDTO;

import java.util.Collection;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DentistServiceTest {
    @Autowired
    DentistService dentistService;

    @Test
    void addDentist() {
        DentistDTO dentistDTO = new DentistDTO("Gina", "Rodriguez", "7895");
        dentistService.addDentist(dentistDTO);
        DentistDTO dentistDTO1;
        try {
            dentistDTO1 = dentistService.readSDentist(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(dentistDTO1 != null);
    }


    @Test
    void getAllDentist() {
        Collection<DentistDTO> dentistDTOS = dentistService.getAllDentist();
        Assert.assertTrue(!dentistDTOS.isEmpty());
        Assert.assertTrue(dentistDTOS.size() >= 1);
        System.out.println(dentistDTOS);

    }


    @Test
    void deleteDentist() {
        dentistService.deleteDentist(1L);

    }
}