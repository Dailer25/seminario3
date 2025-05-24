package com.example.demo.Repositories;

import com.example.demo.Entites.HistoricalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrRepository extends JpaRepository<HistoricalRecord, Long> {
}
