package com.example.dinosaurpark.healthrecord;

import org.springframework.stereotype.Service;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HealthRecordService {
    private final HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getAllRecords() {
        return healthRecordRepository.findAll();
    }

    public HealthRecord getRecordById(Integer id) {
        return healthRecordRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Health Record not found with id: " + id));
    }

    public HealthRecord addRecord(HealthRecord healthRecord) {
        return healthRecordRepository.save(healthRecord);
    }

    public HealthRecord updateRecord(Integer id, HealthRecord updatedHealthRecord) {
        HealthRecord healthRecord = getRecordById(id);

        healthRecord.setHealthStatus(updatedHealthRecord.getHealthStatus());

        return healthRecordRepository.save(healthRecord);
    }

    public void deleteRecord(Integer id) {
        healthRecordRepository.deleteById(id);
    }
}
