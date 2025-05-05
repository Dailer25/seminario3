package com.example.demo.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table ( name = "specialty" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Specialty {
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "specialty")
    private List<Doctor> doctors;
}
