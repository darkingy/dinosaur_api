package com.example.dinosaurpark.healthrecord;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HealthRecordService {
    private final HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getRandomHealthRecord(int count) {
        List<HealthRecord> healthRecords = healthRecordRepository.findAll();

        if (healthRecords.isEmpty()) {
            return Collections.emptyList();
        }

        Collections.shuffle(healthRecords);
        return healthRecords.subList(0, Math.min(count, healthRecords.size()));
    }
}
