package com.example.demo.DTO;

public record DateDTO(
        Long id,
        String date,
        String hour,
        Long ccPatient,
        Long idDoctor,
        Long idSecretariat
) {}
