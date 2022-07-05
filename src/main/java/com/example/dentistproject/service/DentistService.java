package com.example.dentistproject.service;

import com.example.dentistproject.model.Dentist;
import com.example.dentistproject.model.DentistDTO;


import java.util.Collection;


public interface DentistService {
   void addDentist(DentistDTO dentist);
   DentistDTO readSDentist(Long id) throws Exception;
   void updateDentist(DentistDTO dentistDTO);
   Collection<DentistDTO> getAllDentist();

   void deleteDentist(long id);
}
