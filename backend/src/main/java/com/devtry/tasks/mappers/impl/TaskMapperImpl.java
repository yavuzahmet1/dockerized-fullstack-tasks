package com.devtry.tasks.mappers.impl;

import org.springframework.stereotype.Component;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.domain.entities.Task;
import com.devtry.tasks.mappers.TaskMapper;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        if (taskDto == null)
            return null;

        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null);
    }

    @Override
    public TaskDto toDto(Task task) {
        if (task == null)
            return null;

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus());
    }
}