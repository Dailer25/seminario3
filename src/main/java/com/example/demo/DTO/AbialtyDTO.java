package com.example.demo.DTO;

import com.example.demo.Entites.Abialty_State;

import java.time.LocalDateTime;

public record AbialtyDTO(
    Long id,
    String start_hour,
    String end_hour,
    Abialty_State state,
    Long idDoctor
) {}
