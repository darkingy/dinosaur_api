package com.example.dinosaurpark.workschedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {
    
}
