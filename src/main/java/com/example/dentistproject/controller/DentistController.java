package com.example.dentistproject.controller;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @GetMapping("/dentists")
    public ResponseEntity<List<Dentist>> getAllDentist() {
        return ResponseEntity.ok().body(dentistService.getAllDentist());
    }

    @GetMapping("/dentists/{id}")
    public ResponseEntity<Dentist> getDentistById(@PathVariable long id) {
        return ResponseEntity.ok().body(dentistService.getDentistById(id));
    }

    @PostMapping("/dentist")
    public ResponseEntity<Dentist> addDentist(@RequestBody Dentist dentist) {
        return ResponseEntity.ok().body(this.dentistService.addDentist(dentist));
    }

    @PutMapping("/dentists/{id}")
    public ResponseEntity<Dentist> updateDentist(@PathVariable long id, @RequestBody Dentist dentist) {
        dentist.setId(id);
        return ResponseEntity.ok().body(this.dentistService.updateDentist(dentist));
    }

    @DeleteMapping("/dentists/{id}")
    public HttpStatus deleteDentist(@PathVariable long id) {
        this.dentistService.deleteDentist(id);
        return HttpStatus.OK;
    }


}
