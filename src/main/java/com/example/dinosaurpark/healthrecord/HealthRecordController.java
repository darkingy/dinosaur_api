package com.example.dinosaurpark.healthrecord;

import org.springframework.security.access.prepost.PreAuthorize;
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

    //건강정보는 아직 api를 사용하진 않지만, 사용 될 때를 위해 우선 모든 권한에 관리자만 넣음
    //건강정보 확인 - 관리자
    @GetMapping(produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<HealthRecord>> getAllRecords() {
        List<HealthRecord> healthRecords = healthRecordService.getAllRecords();
        return ResponseEntity.ok().body(healthRecords);
    }

    //건강 정보 확인(id) - 관리자
    @GetMapping(value = "/{recordId}", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HealthRecord> getRecordById(@PathVariable("recordId") Integer id) {
        HealthRecord healthRecord = healthRecordService.getRecordById(id);
        return ResponseEntity.ok().body(healthRecord);
    }

    //건강 정보 추가 - 관리자
    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HealthRecord> addRecord(@RequestBody HealthRecord healthRecord) {
        HealthRecord savedHealthRecord = healthRecordService.addRecord(healthRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHealthRecord);
    }

    //건강 정보 수정 - 관리자
    @PutMapping("/{recordId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HealthRecord> updateRecord(@PathVariable("recordId") Integer id, @RequestBody HealthRecord updatedHealthRecord) {
        HealthRecord healthRecord = healthRecordService.updateRecord(id, updatedHealthRecord);
        return ResponseEntity.ok().body(healthRecord);
    }

    //건강 정보 삭제 - 관리자
    @DeleteMapping("/{recordId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRecord(@PathVariable("recordId") Integer id) {
        healthRecordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
