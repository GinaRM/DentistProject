package com.example.dentistproject.service;

import com.example.dentistproject.exception.ResourceNotFoundException;

import com.example.dentistproject.model.Patient;
import com.example.dentistproject.model.PatientDTO;
import com.example.dentistproject.repository.PatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public PatientDTO readPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if(patient.isPresent())
            return mapper.convertValue(patient, PatientDTO.class);
        else throw new ResourceNotFoundException("Patient does not exist");

    }

    @Override
    public void updatePatient(PatientDTO patientDTO) {
        savePatient(patientDTO);

    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public Set<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        Set<PatientDTO> allPatientsDTO = new HashSet<PatientDTO>();
        for (Patient patient : patientList) {
            allPatientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return allPatientsDTO;
    }

    private void savePatient(PatientDTO patientDTO) {
        Patient newPatient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(newPatient);
    }
}
