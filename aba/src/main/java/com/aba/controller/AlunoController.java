package com.aba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api
public class AlunoController {

    @GetMapping
    public String ok() {
        return "ok";
    }
    
}
