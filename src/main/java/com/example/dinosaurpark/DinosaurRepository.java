package com.example.dinosaurpark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurRepository extends JpaRepository<Dinosaur, Integer> {
    
}
