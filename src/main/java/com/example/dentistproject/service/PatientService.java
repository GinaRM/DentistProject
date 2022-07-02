package com.example.dentistproject.service;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.Patient;
import com.example.dentistproject.model.PatientDTO;
import org.springframework.stereotype.Service;


import java.util.Set;
@Service
public interface PatientService {
   void addPatient(PatientDTO patientDTO);
   PatientDTO readPatient(Long id) throws Exception;
   void updatePatient(PatientDTO patientDTO);
   void deletePatient(long id);
   Set<PatientDTO> getAllPatients();



}