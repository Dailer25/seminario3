package com.example.demo.Entites;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table ( name = "ability" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Abiality {
    @Id
    private Long id;
    private String start_hour;
    private String end_hour;
    private Abialty_State state;

    @ManyToOne @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
