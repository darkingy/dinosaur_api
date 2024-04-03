package com.example.dinosaurpark.inspection;

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

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Inspection>> getAllInspections() {
        List<Inspection> inspections = inspectionService.getAllInspections();
        return ResponseEntity.ok().body(inspections);
    }

    @GetMapping(value = "/{inspectionId}", produces = "application/json")
    public ResponseEntity<Inspection> getInspectionById(@PathVariable("inspectionId") Integer id) {
        Inspection inspection = inspectionService.getInspectionById(id);
        return ResponseEntity.ok().body(inspection);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Inspection> addInspection(@RequestBody Inspection inspection) {
        Inspection savedInspection = inspectionService.addInspection(inspection);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInspection);
    }

    @PutMapping("/{inspectionId}")
    public ResponseEntity<Inspection> updateInspection(@PathVariable("inspectionId") Integer id, @RequestBody Inspection updatedInspection) {
        Inspection inspection = inspectionService.updateInspection(id, updatedInspection);
        return ResponseEntity.ok().body(inspection);
    }

    @DeleteMapping("/{inspectionId}")
    public ResponseEntity<?> deleteInspection(@PathVariable("inspectionId") Integer id) {
        inspectionService.deleteInspection(id);
        return ResponseEntity.noContent().build();
    }
}
