package com.example.demo.Repositories;

import com.example.demo.Entites.Doctor;
import com.example.demo.Entites.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
