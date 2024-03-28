package com.example.dinosaurpark.dinosaur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import lombok.RequiredArgsConstructor;

@CrossOrigin
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

    @GetMapping("/dinolist/{dinosaurId}")
    public ResponseEntity<Dinosaur> getDinosaurById(@PathVariable("dinosaurId") Integer id) {
        Dinosaur dinosaur = dinosaurService.getDinosaurById(id);
        return new ResponseEntity<>(dinosaur, HttpStatus.OK);
    }
    
    @PostMapping(value = "/dinolist", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dinosaur> addDinosaur(@RequestBody Dinosaur dinosaur) {
        Dinosaur savedDinosaur = dinosaurService.saveDinosaur(dinosaur);
        return new ResponseEntity<>(savedDinosaur, HttpStatus.CREATED);
    }

    @DeleteMapping("/dinolist/{dinosaurId}")
    public ResponseEntity<?> deleteDinosaur(@PathVariable("dinosaurId") Integer id) {
        dinosaurService.deleteDinosaur(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/dinolist/{dinosaurId}")
    public ResponseEntity<Dinosaur> updateDinosaur(@PathVariable("dinosaurId") Integer id, @RequestBody Dinosaur updatedDinosaur) {
        Dinosaur dinosaur = dinosaurService.updateDinosaur(id, updatedDinosaur);
        return ResponseEntity.ok().body(dinosaur);
    }
}
