package com.example.dinosaurpark.inspection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inspection")
public class InspectionController {
    
    private final InspectionService inspectionService;

    //안전점검일정 확인 - 관리자, 직원
    @GetMapping(produces = "application/json")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<List<Inspection>> getAllInspections() {
        List<Inspection> inspections = inspectionService.getAllInspections();
        return ResponseEntity.ok().body(inspections);
    }

    //안전점검일정 확인(id) - 관리자, 직원
    @GetMapping(value = "/{inspectionId}", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<Inspection> getInspectionById(@PathVariable("inspectionId") Integer id) {
        Inspection inspection = inspectionService.getInspectionById(id);
        return ResponseEntity.ok().body(inspection);
    }

    //안전점검일정 추가- 관리자
    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Inspection> addInspection(@RequestBody Inspection inspection) {
        Inspection savedInspection = inspectionService.addInspection(inspection);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInspection);
    }

    //안전점검일정 수정 - 관리자
    @PutMapping("/{inspectionId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Inspection> updateInspection(@PathVariable("inspectionId") Integer id, @RequestBody Inspection updatedInspection) {
        Inspection inspection = inspectionService.updateInspection(id, updatedInspection);
        return ResponseEntity.ok().body(inspection);
    }

    //안전점검일정 삭제 - 관리자, 직원
    @DeleteMapping("/{inspectionId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> deleteInspection(@PathVariable("inspectionId") Integer id) {
        inspectionService.deleteInspection(id);
        return ResponseEntity.noContent().build();
    }
}
