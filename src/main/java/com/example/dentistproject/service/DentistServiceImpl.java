package com.example.dentistproject.service;

import com.example.dentistproject.exception.ResourceNotFoundException;
import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.DentistDTO;
import com.example.dentistproject.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;


@Transactional
@Service
public class DentistServiceImpl implements  DentistService{

    @Autowired
    private DentistRepository dentistRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public void addDentist(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public DentistDTO readSDentist(Long id) throws Exception {

            Optional<Dentist> found = dentistRepository.findById(id);
            DentistDTO dentistDTO = null;
            if(found.isPresent())
                return mapper.convertValue(found, DentistDTO.class);
            else
                throw new Exception("Dentist Does Not Exist");


    }


    @Override
    public Dentist updateDentist(Dentist dentist) {
        Optional<Dentist> dentistDb = this.dentistRepository.findById(dentist.getId());
        if(dentistDb.isPresent()) {
            Dentist dentistUpdate = dentistDb.get();
            dentistUpdate.setId(dentist.getId());
            dentistUpdate.setName(dentist.getName());
            dentistUpdate.setLastName(dentist.getLastName());
            dentistUpdate.setLicense(dentist.getLicense());
            dentistRepository.save(dentistUpdate);
            return  dentistUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + dentist.getId());
        }
    }

    @Override
    public Collection<DentistDTO> getAllDentist() {
        List<Dentist> allDentists = dentistRepository.findAll();
        Set<DentistDTO> allDentistDTO = new HashSet<DentistDTO>();
        for (Dentist dentist : allDentists) {
            allDentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return allDentistDTO;


    }

    @Override
    public void deleteDentist(long id) {
        Optional<Dentist> dentistDb = this.dentistRepository.findById(id);
        if(dentistDb.isPresent()) {
            this.dentistRepository.delete(dentistDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }

    }

    private void saveDentist(DentistDTO dentistDTO) {
        Dentist newDentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(newDentist);
    }
}
