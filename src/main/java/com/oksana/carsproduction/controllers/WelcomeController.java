package com.oksana.carsproduction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/api")
    public String welcome(){
        String w = "Welcome!";
        return w ;

    }
}
