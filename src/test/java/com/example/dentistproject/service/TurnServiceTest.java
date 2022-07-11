package com.example.dentistproject.service;
import com.example.dentistproject.model.Address;
import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.Patient;
import com.example.dentistproject.model.TurnDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;
@SpringBootTest
public class TurnServiceTest {
    @Autowired
    private TurnService turnService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void testAddTurn() {

        Dentist dentist = new Dentist("Gin","Ro","1233");

        Address address = new Address("calle", "12388", "whatever","what");
        Patient patient = new Patient("Ugh", "idk", "8888", LocalDate.now(),address);
        TurnDTO turnDTO = new TurnDTO(dentist,patient,LocalDate.now());
        turnService.createTurn(turnDTO);

    }

    @Test
    public void getAllTurns() {
        Set<TurnDTO>  turnDTOS = turnService.getAllTurns();
        Assert.assertTrue(!turnDTOS.isEmpty());
        Assert.assertTrue(turnDTOS.size() >= 1);
        System.out.println(turnDTOS);
    }

    @Test
    public void deleteTurn() {
        turnService.deleteTurn(1L);


    }
}
