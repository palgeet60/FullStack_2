package com.example.exp211.schedule;

import com.example.exp211.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> findAll() {
        return scheduleRepository.findAll().stream().map(ScheduleResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public ScheduleResponse findById(Long id) {
        return ScheduleResponse.from(getSchedule(id));
    }

    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = new Schedule();
        apply(request, schedule);
        return ScheduleResponse.from(scheduleRepository.save(schedule));
    }

    public ScheduleResponse update(Long id, ScheduleRequest request) {
        Schedule schedule = getSchedule(id);
        apply(request, schedule);
        return ScheduleResponse.from(scheduleRepository.save(schedule));
    }

    public void delete(Long id) {
        scheduleRepository.delete(getSchedule(id));
    }

    private Schedule getSchedule(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found: " + id));
    }

    private void apply(ScheduleRequest request, Schedule schedule) {
        schedule.setTitle(request.title());
        schedule.setDescription(request.description());
        schedule.setScheduledAt(request.scheduledAt());
        schedule.setStatus(request.status());
    }
}
