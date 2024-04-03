package com.example.dinosaurpark.inspection;

import org.springframework.stereotype.Service;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InspectionService {
    private final InspectionRepository inspectionRepository;

    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }

    public Inspection getInspectionById(Integer id) {
        return inspectionRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Inspection not found with id: " + id));
    }

    public Inspection addInspection(Inspection inspection) {
        return inspectionRepository.save(inspection);
    }

    public Inspection updateInspection(Integer id, Inspection updatedInspection) {
        Inspection inspection = getInspectionById(id);

        inspection.setDayOfWeek(updatedInspection.getDayOfWeek());
        inspection.setInspectionDetail(updatedInspection.getInspectionDetail());
        inspection.setInspectionTime(updatedInspection.getInspectionTime());

        return inspectionRepository.save(inspection);
    }

    public void deleteInspection(Integer id) {
        inspectionRepository.deleteById(id);
    }
}
