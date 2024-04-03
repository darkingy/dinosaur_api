package com.example.dinosaurpark.inspection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Integer>{
    
}
