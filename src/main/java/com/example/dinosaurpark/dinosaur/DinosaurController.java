package com.example.dinosaurpark.dinosaur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DinosaurController {
    
    private final DinosaurService dinosaurService;

    @GetMapping(value = "/dinolist", produces = "application/json")
    public ResponseEntity<List<Dinosaur>> getAllDinosaurs() {
        List<Dinosaur> dinosaurs = dinosaurService.getList();
        return new ResponseEntity<>(dinosaurs, HttpStatus.OK);
    }
    
    @PostMapping(value = "/dinolist", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dinosaur> addDinosaur(@RequestBody Dinosaur dinosaur) {
        Dinosaur savedDinosaur = dinosaurService.saveDinosaur(dinosaur);
        return new ResponseEntity<>(savedDinosaur, HttpStatus.CREATED);
    }
}
