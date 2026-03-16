package com.example.student_api.dto;


import jakarta.validation.constraints.*;

public record StudentRequestDTO(

        //@NotBlank verifie que la chaine n est pas vide
        @NotBlank(message = "Le prénom est nécessaire")
        String firstName,

        @NotBlank(message = "Le nom est nécessaire")
        String lastName,

        //@Email pour le format d'email
        @NotBlank(message = "L'email est nécessaire")
        @Email(message = "Format d'email invalide , entrer l'email")
        String email,

        @NotBlank(message = "La filière est nécessaire")
        String major,

        @NotNull(message = "L'âge est obligatoire")
        @Min(value = 18, message = "L'âge minimal est 18")
        @Max(value = 80, message = "L'âge maximal est 80")
        Integer age
) {
}