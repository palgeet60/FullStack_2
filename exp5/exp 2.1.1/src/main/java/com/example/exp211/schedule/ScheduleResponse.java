package com.example.exp211.schedule;

import java.time.LocalDateTime;

public record ScheduleResponse(
        Long id,
        String title,
        String description,
        LocalDateTime scheduledAt,
        ScheduleStatus status
) {
    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getDescription(),
                schedule.getScheduledAt(),
                schedule.getStatus()
        );
    }
}
