package com.example.demo.Services;


import com.example.demo.DTO.PatientDTO;
import com.example.demo.Entites.Patient;
import com.example.demo.Repositories.DateRepository;
import com.example.demo.Repositories.HistoricalRecordRepository;
import com.example.demo.Repositories.PatientRepository;
import com.example.demo.Util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DateRepository dateRepository;
    @Autowired
    private HistoricalRecordRepository historicalRecordRepository;
    @Autowired
    private Converter converter;

    private PatientDTO getPatienById(Long cc){
        Patient patient = patientRepository.findById(cc).orElseThrow(()-> new RuntimeException("Paciente no encontrado"));
        return converter.convertToPatientDTO(patient);
    }

    private List<PatientDTO> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(converter::convertToPatientDTO).collect(Collectors.toList());
    }



}
