package com.example.demo.Entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table ( name = "secretariat" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Secretariat {
    @Id
    private Long id;
    private Long cc;
    private String name;
    private String lastName;
    private String email;

    @OneToMany (mappedBy ="secretariat")
    private List<Date> dates;

}
