package com.example.dinosaurpark.healthrecord;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/health")
public class HealthRecordController {
    
    private final HealthRecordService healthRecordService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<HealthRecord>> getAllRecords() {
        List<HealthRecord> healthRecords = healthRecordService.getAllRecords();
        return ResponseEntity.ok().body(healthRecords);
    }

    @GetMapping(value = "/{recordId}", produces = "application/json")
    public ResponseEntity<HealthRecord> getRecordById(@PathVariable("recordId") Integer id) {
        HealthRecord healthRecord = healthRecordService.getRecordById(id);
        return ResponseEntity.ok().body(healthRecord);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HealthRecord> addRecord(@RequestBody HealthRecord healthRecord) {
        HealthRecord savedHealthRecord = healthRecordService.addRecord(healthRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHealthRecord);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<HealthRecord> updateRecord(@PathVariable("recordId") Integer id, @RequestBody HealthRecord updatedHealthRecord) {
        HealthRecord healthRecord = healthRecordService.updateRecord(id, updatedHealthRecord);
        return ResponseEntity.ok().body(healthRecord);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<?> deleteRecord(@PathVariable("recordId") Integer id) {
        healthRecordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
