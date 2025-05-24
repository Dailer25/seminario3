package com.example.demo.Services;

import com.example.demo.DTO.HistoricalRecordDTO;
import com.example.demo.Entites.HistoricalRecord;
import com.example.demo.Repositories.HrRepository;
import com.example.demo.Util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrService {
    @Autowired
    private HrRepository hrRepository;
    @Autowired
    private Converter converter;

    private HistoricalRecordDTO createHr(HistoricalRecordDTO hrDTO) {
        HistoricalRecord hr = new HistoricalRecord();
        hr.setDiagnosis(hrDTO.diagnosis());
        hr.setDescription(hrDTO.description());
        hr.setMedical_exam(hrDTO.medical_exam());
        hr.setPrescription(hrDTO.prescription());
        return converter.convertToHCDTO(hrRepository.save(hr));
    }

    

}
