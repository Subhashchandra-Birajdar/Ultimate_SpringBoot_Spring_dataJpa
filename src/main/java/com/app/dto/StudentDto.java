package com.app.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "firstname should not be empty !!")
        String firstname,
        
        @NotEmpty(message = "lastname should not be empty !!")
        String lastname,
        String email,
        int age,
        Integer schoolid
) {
}

