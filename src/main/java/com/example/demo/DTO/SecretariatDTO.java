package com.example.demo.DTO;

import java.util.List;

public record SecretariatDTO(
        Long id,
        Long cc,
        String name,
        String lastName,
        String email,
        List<DateDTO> dates
) {}
