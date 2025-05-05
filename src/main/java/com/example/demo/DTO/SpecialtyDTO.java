package com.example.demo.DTO;

public record SpecialtyDTO(
        Long id,
        String name,
        java.util.Set<DoctorDTO> doctors
) {}
