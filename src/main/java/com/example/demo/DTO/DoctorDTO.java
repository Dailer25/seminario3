package com.example.demo.DTO;

import java.util.List;

public record DoctorDTO(
        Long id,
        Long cc,
        String name,
        String lastName,
        String email,
        String phone,
        List<HistoricalRecordDTO> historicalRecords,
        List<DateDTO> dates,
        Long idSpecialty
) {}
