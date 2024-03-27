package com.example.dinosaurpark.dinosaur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurRepository extends JpaRepository<Dinosaur, Integer> {
    
}
