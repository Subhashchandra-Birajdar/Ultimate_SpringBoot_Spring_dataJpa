package com.app.dto;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        int age,
        Integer schoolid
) {
}

