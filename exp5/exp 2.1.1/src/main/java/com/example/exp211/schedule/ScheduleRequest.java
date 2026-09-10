package com.example.exp211.schedule;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ScheduleRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 120, message = "Title must be at most 120 characters")
        String title,

        @Size(max = 500, message = "Description must be at most 500 characters")
        String description,

        @NotNull(message = "Scheduled time is required")
        @FutureOrPresent(message = "Scheduled time must be in the present or future")
        LocalDateTime scheduledAt,

        @NotNull(message = "Status is required")
        ScheduleStatus status
) {
}
