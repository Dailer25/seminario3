package com.example.demo.Entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table ( name = "historical_record" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class HistoricalRecord {
    @Id
    private Long id;
    private String diagnosis;
    private String description;
    private String medical_exam;
    private String prescription;

    @ManyToOne @JoinColumn(name = "patient_cc")
    private Patient patient;

    @ManyToOne @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne @JoinColumn(name = "date_id")
    private Date date;
}
