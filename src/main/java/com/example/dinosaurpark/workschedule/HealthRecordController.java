package com.example.dinosaurpark.workschedule;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/health")
public class HealthRecordController {
    
    private final HealthRecordService healthRecordService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<HealthRecord>> getRandomHealthRecord() {
        List<HealthRecord> randomRecords = healthRecordService.getRandomHealthRecord(3);
        return ResponseEntity.ok().body(randomRecords);
    }
}
