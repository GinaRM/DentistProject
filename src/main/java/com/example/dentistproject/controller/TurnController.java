package com.example.dentistproject.controller;

import com.example.dentistproject.model.TurnDTO;
import com.example.dentistproject.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/turns")
public class TurnController {
    @Autowired
    TurnService turnService;



    @PostMapping()
    public ResponseEntity<?> createTurn(@RequestBody TurnDTO turnDTO) {
        turnService.createTurn(turnDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnDTO getTurn(@PathVariable Long id) throws Exception {
        return turnService.readTurn(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateTurn(@RequestBody TurnDTO turnDTO) {
        turnService.updateTurn(turnDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurn(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        turnService.deleteTurn(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminated");
        return response;
    }

    @GetMapping("/list")
    public Set<TurnDTO> getAllTurns() {
        return turnService.getAllTurns();
    }


}
