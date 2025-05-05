package com.example.demo.Services;

import com.example.demo.DTO.SecretariatDTO;
import com.example.demo.Entites.Secretariat;
import com.example.demo.Repositories.DateRepository;
import com.example.demo.Repositories.SecretariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SercretariatService {

    @Autowired
    private SecretariantRepository secretariationRepository;

    @Autowired
    private DateRepository dateRepository;



}
