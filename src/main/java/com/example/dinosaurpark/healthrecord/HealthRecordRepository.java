package com.example.dinosaurpark.healthrecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
    
}
