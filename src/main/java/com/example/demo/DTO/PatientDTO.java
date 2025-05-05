package com.example.demo.DTO;

import java.util.List;

public record PatientDTO(
       Long cc,
       String name,
       String lastName,
       String gender,
       String email,
       String phone,
       List<DateDTO> dates,
       List<HistoricalRecordDTO> historicalRecords
) {}
