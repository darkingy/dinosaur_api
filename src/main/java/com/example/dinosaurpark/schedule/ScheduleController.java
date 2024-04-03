package com.example.dinosaurpark.schedule;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    
    private final ScheduleService scheduleService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok().body(schedules);
    }

    @GetMapping(value = "/{scheduleId}", produces = "application/json")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("scheduleId") Integer id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok().body(schedule);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.addSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("scheduleId") Integer id, @RequestBody Schedule updatedSchedule) {
        Schedule schedule = scheduleService.updateSchedule(id, updatedSchedule);
        return ResponseEntity.ok().body(schedule);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<?> deleteSchedlue(@PathVariable("scheduleId") Integer id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
