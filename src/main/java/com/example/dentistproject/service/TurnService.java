package com.example.dentistproject.service;



import com.example.dentistproject.model.TurnDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface TurnService {

    void createTurn(TurnDTO turnDTO);
    TurnDTO readTurn(Long id) throws Exception;
    void updateTurn(TurnDTO turnDTO);
    void deleteTurn(Long id);
    Set<TurnDTO> getAllTurns();
}
