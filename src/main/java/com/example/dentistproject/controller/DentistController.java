package com.example.dentistproject.controller;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.DentistDTO;
import com.example.dentistproject.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @GetMapping("/dentists")
    public ResponseEntity<Collection<DentistDTO>> getAllDentist() {
        return ResponseEntity.ok().body(dentistService.getAllDentist());
    }

    @GetMapping("/dentists/{id}")
    public DentistDTO getDentistById(@PathVariable long id) throws  Exception{
        return dentistService.readSDentist(id);
    }

    @PostMapping("/dentist")
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO) {
        dentistService.addDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/dentist/{id}")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO) {
        dentistService.updateDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @DeleteMapping("/dentists/{id}")
    public HttpStatus deleteDentist(@PathVariable long id) {
        this.dentistService.deleteDentist(id);
        return HttpStatus.OK;
    }


}
