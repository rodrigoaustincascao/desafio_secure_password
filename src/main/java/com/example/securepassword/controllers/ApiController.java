package com.example.securepassword.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.securepassword.dtos.BodyRequestDTO;
import com.example.securepassword.dtos.FailureResponseDTO;
import com.example.securepassword.services.PasswordService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ApiController {
    
    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService){
        this.passwordService = passwordService;
    }


    @PostMapping(value = "/validate-password")
    public ResponseEntity<FailureResponseDTO> validatePassword(@RequestBody BodyRequestDTO request) {
        var failures = passwordService.validatePass(request.password());

        if(failures.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponseDTO(failures));
    }
    
}
