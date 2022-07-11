package com.example.dentistproject;


import com.example.dentistproject.model.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DentistProjectApplication {

	Address address = new Address(1,"abc", "kennedy", "kennedy","idk2");



	public static void main(String[] args) {
		SpringApplication.run(DentistProjectApplication.class, args);
	}

}
