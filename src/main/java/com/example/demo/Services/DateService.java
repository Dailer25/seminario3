package com.example.demo.Services;

import com.example.demo.DTO.DateDTO;
import com.example.demo.Entites.Date;
import com.example.demo.Repositories.DateRepository;
import com.example.demo.Util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    @Autowired
    private Converter converter;

    private DateDTO createDate(DateDTO dateDTO){
        Date date = new Date();
        date.setDate(dateDTO.date());
        date.setDate(dateDTO.date());
        return converter.convertToDateDTO(dateRepository.save(date));
    }

    private DateDTO getDateById(Long id){
        Date date = dateRepository.findById(id).orElseThrow(()-> new RuntimeException("Fecha no encontrada"));
        return converter.convertToDateDTO(date);
    }



}
