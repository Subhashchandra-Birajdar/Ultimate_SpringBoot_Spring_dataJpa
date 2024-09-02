package com.app.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty
        String firstname,
        
        @NotEmpty
        String lastname,
        String email,
        int age,
        Integer schoolid
) {
}

