package com.dbshacktron.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping(value = "/")
    public String helloWorld() {
        return "Welcome to Hacktron";
    }
}
