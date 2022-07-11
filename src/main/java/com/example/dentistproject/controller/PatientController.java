package com.example.dentistproject.controller;

import com.example.dentistproject.model.DentistDTO;
import com.example.dentistproject.model.PatientDTO;
import com.example.dentistproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping()
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO) {
        patientService.addPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable Long id) throws Exception {
        return patientService.readPatient(id);
    }

    @PutMapping()
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        patientService.deletePatient(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminated");
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<PatientDTO>> listPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());

    }


}
