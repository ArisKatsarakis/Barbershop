package com.example.demo.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class BarberShopUserController {

    private BarberShopUserService userService;


    public BarberShopUserController(BarberShopUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    @CrossOrigin
    public ResponseEntity<String>  authenticateUser(@RequestParam String username, @RequestParam String password) {
       return  userService.authenticate(username, password);
    }
}
