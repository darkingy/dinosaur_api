package com.example.dinosaurpark.dinosaur;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Service
@RequiredArgsConstructor
public class DinosaurService {
    private final DinosaurRepository dinosaurRepository;

    public List<Dinosaur> getList() {
        return this.dinosaurRepository.findAll();
    }

    public Dinosaur saveDinosaur(@NonNull Dinosaur dinosaur) {
        return this.dinosaurRepository.save(dinosaur);
    }
}
