package com.example.dentistproject.service;

import com.example.dentistproject.model.Dentist;

import java.util.List;

public interface DentistService {
   Dentist addDentist(Dentist dentist);
   Dentist updateDentist(Dentist dentist);
   List<Dentist> getAllDentist();
   Dentist getDentistById(long dentistId);
   void deleteDentist(long id);
}
