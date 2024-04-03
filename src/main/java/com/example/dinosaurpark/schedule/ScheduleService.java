package com.example.dinosaurpark.schedule;

import org.springframework.stereotype.Service;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Integer id) {
        return scheduleRepository.findById(id)
                                .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
    }

    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Integer id, Schedule updatedSchedule) {
        Schedule schedule = getScheduleById(id);

        schedule.setFeedingDetail(updatedSchedule.getFeedingDetail());
        schedule.setFeedingTime(updatedSchedule.getFeedingTime());

        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
