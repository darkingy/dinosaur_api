package com.example.dinosaurpark.dinosaur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity // 클래스 안에 있는 정보들을 데이터베이스에 저장하고 사용할 수 있다
@Getter
@Setter
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column // 해당 속성이 테이블의 'dinoSpecies' 열에 매핑됨. 정보를 저장, 검색 할 수 있다
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
