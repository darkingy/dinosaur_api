package com.example.dinosaurpark;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DinosaurService {
    private final DinosaurRepository dinosaurRepository;

    public List<Dinosaur> getList() {
        return this.dinosaurRepository.findAll();
    }
}
