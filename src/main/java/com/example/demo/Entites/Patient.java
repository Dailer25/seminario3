package com.example.demo.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table ( name = "patient" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cc;
    private String name;
    private String lastName;
    private String gender;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Date> dates;

    @OneToMany(mappedBy = "patient")
    private List<HistoricalRecord> historicalRecords;

}
