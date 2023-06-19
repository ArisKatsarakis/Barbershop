package com.example.demo.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BarberShopUserService {

    private BarbershopUserRepository userRepository;

    public BarberShopUserService(BarbershopUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> authenticate(String username, String password) {
        List<BarbershopUser> userFound = userRepository.findByUsername(username);
        final BarbershopUser[] authenttincatedUser = {null};
        userFound.stream().forEach(
                user -> {
                    if(user.getUsername().equals(username)) {
                        if(user.getPassword().equals(password)) {
                            authenttincatedUser[0] = new BarbershopUser( user.getEmail(), user.getUsername(), user.getPassword());
                        }
                    }
                }
        );

        if (authenttincatedUser[0] ==  null) { return new ResponseEntity<>("Wrong Password", HttpStatus.OK);}
        else {return new ResponseEntity<>("Signed In", HttpStatus.OK);}
    }
}
