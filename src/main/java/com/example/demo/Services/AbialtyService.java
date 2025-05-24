package com.example.demo.Services;


import com.example.demo.DTO.AbialtyDTO;
import com.example.demo.Entites.Abiality;
import com.example.demo.Repositories.AbialityRepository;
import com.example.demo.Util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbialtyService {

    @Autowired
    private AbialityRepository abialityRepository;
    @Autowired
    private Converter converter;

    private AbialtyDTO createAbialty(AbialtyDTO abialtyDTO){
        Abiality abiality = new Abiality();
        abiality.setStart_hour(abialtyDTO.start_hour());
        abiality.setEnd_hour(abialtyDTO.end_hour());
        abiality.setState(abialtyDTO.state());

        return converter.convertToAbialityDTO(abialityRepository.save(abiality));
    }

}
