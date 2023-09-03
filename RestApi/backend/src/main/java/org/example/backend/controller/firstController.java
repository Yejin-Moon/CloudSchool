package org.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstController {
    @GetMapping("/first")
    public String first() {
        return "first";
    }
}
