package com.example.demo.Repositories;

import com.example.demo.Entites.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {
}
