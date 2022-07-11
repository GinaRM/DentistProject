package com.example.dentistproject.service;

import com.example.dentistproject.exception.ResourceNotFoundException;
import com.example.dentistproject.model.Patient;
import com.example.dentistproject.model.PatientDTO;
import com.example.dentistproject.model.Turn;
import com.example.dentistproject.model.TurnDTO;
import com.example.dentistproject.repository.TurnRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TurnServiceImpl implements TurnService {
    @Autowired
    private TurnRepository turnRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public void createTurn(TurnDTO turnDTO) {
        saveTurn(turnDTO);

    }

    @Override
    public TurnDTO readTurn(Long id) throws Exception {
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDTO turnDTO = null;
        if(turn.isPresent())
            return mapper.convertValue(turn, TurnDTO.class);
        else throw new ResourceNotFoundException("Turn does not exist");
    }

    @Override
    public void updateTurn(TurnDTO turnDTO) {
        saveTurn(turnDTO);
    }

    @Override
    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public Set<TurnDTO> getAllTurns() {
        List<Turn> turnList = turnRepository.findAll();
        Set<TurnDTO> allTurnsDTO = new HashSet<TurnDTO>();
        for (Turn turn : turnList) {
           allTurnsDTO.add(mapper.convertValue(turn, TurnDTO.class));
        }
        return allTurnsDTO;
    }

    private void saveTurn(TurnDTO turnDTO) {
        Turn newTurn = mapper.convertValue(turnDTO, Turn.class);
        turnRepository.save(newTurn);


    }


}
