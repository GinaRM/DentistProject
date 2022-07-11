package com.example.dentistproject.service;


import com.example.dentistproject.model.AppUser;
import com.example.dentistproject.model.AppUserRole;
import com.example.dentistproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("pw");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("pw2");
        userRepository.save(new AppUser("Diego", "diana", "diana@digital.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Paul", "paul", "paul@digital.com", hashedPassword2, AppUserRole.USER));
    }
}
