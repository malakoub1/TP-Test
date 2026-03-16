package com.example.student_api.dto;

//ce dto represente les donnees renvoyees par API au client

public record StudentRespondDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String major,
        Integer age
) {
}