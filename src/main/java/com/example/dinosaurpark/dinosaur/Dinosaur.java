package com.example.dinosaurpark.dinosaur;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String dinoSpecies;

    @Column
    private String dinoEra;
    
    @Column
    private String dinoType;

    @Column
    private String dinoFeature;
    
    @Column
    private Integer dinoSize;

    @Column
    private Integer dinoWeight;

    @Column
    private Integer dinoDangerLevel;

    @Column
    private Integer dinoHealthStatus;

}
