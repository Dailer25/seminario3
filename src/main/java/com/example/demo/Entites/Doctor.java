package com.example.demo.Entites;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table ( name = "doctor" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cc;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany (mappedBy = "doctor")
    private List<HistoricalRecord> historicalRecords;

    @OneToMany (mappedBy = "doctor")
    private List<Date> dates;

    @OneToMany (mappedBy = "doctor")
    private List<Abiality> abialities;

    @ManyToOne @JoinColumn(name = "specialty_id")
    private Specialty specialty;

}
