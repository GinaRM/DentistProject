package com.example.dentistproject.service;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.DentistDTO;


import java.util.Collection;


public interface DentistService {
   void addDentist(DentistDTO dentist);
   DentistDTO readSDentist(Long id) throws Exception;
   Dentist updateDentist(Dentist dentist);
   Collection<DentistDTO> getAllDentist();

   void deleteDentist(Long id);
}
