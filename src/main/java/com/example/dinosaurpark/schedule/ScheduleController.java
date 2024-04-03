package com.example.dinosaurpark.schedule;

import org.springframework.security.access.prepost.PreAuthorize;
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

    //급식 스케줄 확인 - 직원, 관리자
    @GetMapping(produces = "application/json")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok().body(schedules);
    }

    //급식 스케줄 확인(id) -직원, 관리자
    @GetMapping(value = "/{scheduleId}", produces = "application/json")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("scheduleId") Integer id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok().body(schedule);
    }

    //급식 스케줄 추가 - 관리자
    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.addSchedule(schedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
    }

    //급식 스케줄 수정 - 관리자
    @PutMapping("/{scheduleId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("scheduleId") Integer id, @RequestBody Schedule updatedSchedule) {
        Schedule schedule = scheduleService.updateSchedule(id, updatedSchedule);
        return ResponseEntity.ok().body(schedule);
    }

    //급식 스케줄 삭제 - 직원, 관리자
    @DeleteMapping("/{scheduleId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> deleteSchedlue(@PathVariable("scheduleId") Integer id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
