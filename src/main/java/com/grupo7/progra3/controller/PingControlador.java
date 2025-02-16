package com.grupo7.progra3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingControlador {

    @GetMapping("/ping")
    public String pingPong() {
        return "pong";
    }
}
