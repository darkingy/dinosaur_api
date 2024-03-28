package com.example.dinosaurpark.dinosaur;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Service
@RequiredArgsConstructor
public class DinosaurService {
    private final DinosaurRepository dinosaurRepository;

    //모든 공룡 리스트 가져오기
    public List<Dinosaur> getList() {
        return this.dinosaurRepository.findAll();
    }

    public Dinosaur getDinosaurById(Integer id) {
        return dinosaurRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Dinosaur not found with id: " + id));
    }

    //공룡 저장
    public Dinosaur saveDinosaur(@NonNull Dinosaur dinosaur) {
        return this.dinosaurRepository.save(dinosaur);
    }

    //공룡 삭제
    //해당되는 id 가 없을 때에 대한 오류 처리 추가하기
    public void deleteDinosaur(Integer id) {
        dinosaurRepository.deleteById(id);
    }

    //공룡 수정
    public Dinosaur updateDinosaur(Integer id, Dinosaur updatedDinosaur) {
        Dinosaur dinosaur = getDinosaurById(id);
        
        dinosaur.setDinoDangerLevel(updatedDinosaur.getDinoDangerLevel());
        dinosaur.setDinoEra(updatedDinosaur.getDinoEra());
        dinosaur.setDinoFeature(updatedDinosaur.getDinoFeature());
        dinosaur.setDinoHealthStatus(updatedDinosaur.getDinoHealthStatus());
        dinosaur.setDinoSize(updatedDinosaur.getDinoSize());
        dinosaur.setDinoSpecies(updatedDinosaur.getDinoSpecies());
        dinosaur.setDinoType(updatedDinosaur.getDinoType());
        dinosaur.setDinoWeight(updatedDinosaur.getDinoWeight());

        return dinosaurRepository.save(dinosaur);
    }
}
