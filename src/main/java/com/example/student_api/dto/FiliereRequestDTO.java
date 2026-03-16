package com.example.student_api.dto;


import jakarta.validation.constraints.*;

public record FiliereRequestDTO(

        //@NotBlank verifie que la chaine n est pas vide
        @NotBlank(message = "Le nom de filiere est nécessaire")
        String name
) {
}