package com.example.dinosaurpark.dinosaur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import lombok.RequiredArgsConstructor;

@CrossOrigin // CORS 설정을 허용하는 어노테이션
@RequiredArgsConstructor // 필수 인자를 가진 생성자를 자동으로 생성하는 어노테이션
@RestController // RESTful API를 처리하는 컨트롤러임을 표시하는 어노테이션
@RequestMapping("/api/dinosaur") // 경로에 대한 요청을 처리하는 컨트롤러임을 지정하는 어노테이션
public class DinosaurController {

    private final DinosaurService dinosaurService;

    // 모든 공룡 정보를 가져오는 엔드포인트
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Dinosaur>> getAllDinosaurs() {
        List<Dinosaur> dinosaurs = dinosaurService.getList();
        return new ResponseEntity<>(dinosaurs, HttpStatus.OK);
    }

    // 특정 공룡의 정보를 가져오는 엔드포인트
    @GetMapping("/{dinosaurId}")
    public ResponseEntity<Dinosaur> getDinosaurById(@PathVariable("dinosaurId") Integer id) {
        Dinosaur dinosaur = dinosaurService.getDinosaurById(id);
        return new ResponseEntity<>(dinosaur, HttpStatus.OK);
    }

    // 새로운 공룡 정보를 추가하는 엔드포인트
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Dinosaur> addDinosaur(@RequestBody Dinosaur dinosaur) {
        Dinosaur savedDinosaur = dinosaurService.saveDinosaur(dinosaur);
        return new ResponseEntity<>(savedDinosaur, HttpStatus.CREATED);
    }

    // 특정 공룡 정보를 삭제하는 엔드포인트
    @DeleteMapping("{dinosaurId}")
    public ResponseEntity<?> deleteDinosaur(@PathVariable("dinosaurId") Integer id) {
        dinosaurService.deleteDinosaur(id);
        return ResponseEntity.ok().build();
    }

    // 특정 공룡 정보를 수정하는 엔드포인트
    @PutMapping("{dinosaurId}")
    public ResponseEntity<Dinosaur> updateDinosaur(@PathVariable("dinosaurId") Integer id,
            @RequestBody Dinosaur updatedDinosaur) {
        Dinosaur dinosaur = dinosaurService.updateDinosaur(id, updatedDinosaur);
        return ResponseEntity.ok().body(dinosaur);
    }
}
