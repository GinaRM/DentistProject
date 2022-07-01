package com.example.dentistproject.service;

import com.example.dentistproject.exception.ResourceNotFoundException;
import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DentistServiceImpl implements  DentistService{

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
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
    public List<Dentist> getAllDentist() {
        return this.dentistRepository.findAll();
    }

    @Override
    public Dentist getDentistById(long dentistId) {
        Optional<Dentist> dentistDb = this.dentistRepository.findById(dentistId);
        if(dentistDb.isPresent()) {
            return dentistDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + dentistId);
        }
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
}
