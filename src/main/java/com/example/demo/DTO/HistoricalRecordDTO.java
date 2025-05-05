package com.example.demo.DTO;

public record HistoricalRecordDTO(
       Long id,
       String diagnosis,
       String description,
       String medical_exam,
       String prescription,
       Long ccPatient,
       Long idDoctor,
       DateDTO date
) {}
