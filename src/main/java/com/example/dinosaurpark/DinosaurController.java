package com.example.dinosaurpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DinosaurController {
    
    private final DinosaurService dinosaurService;

    @GetMapping("/dinolist")
    public List<Dinosaur> getAllDinosaurs() {
        return dinosaurService.getList();
    }
    
}
