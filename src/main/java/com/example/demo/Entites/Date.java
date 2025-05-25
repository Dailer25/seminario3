package com.example.demo.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table  ( name = "date" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Date {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String hour;

    @ManyToOne @JoinColumn(name = "patient_cc")
    private Patient patient;

    @ManyToOne @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @ManyToOne @JoinColumn(name = "secretariat_id")
    private Secretariat secretariat;
}
