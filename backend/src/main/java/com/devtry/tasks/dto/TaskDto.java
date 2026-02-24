package com.devtry.tasks.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devtry.tasks.entities.TaskPriority;
import com.devtry.tasks.entities.TaskStatus;

public record TaskDto(
        UUID id, String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status) {
}