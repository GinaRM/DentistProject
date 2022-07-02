package com.example.dentistproject.service;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.DentistDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service

public interface DentistService {
   void addDentist(DentistDTO dentist);
   Dentist updateDentist(Dentist dentist) throws  Exception;
   Collection<DentistDTO> getAllDentist();
   Dentist getDentistById(long dentistId);
   void deleteDentist(long id);
}
