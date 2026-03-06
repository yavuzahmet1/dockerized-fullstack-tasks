package com.devtry.tasks.services;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.domain.entities.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<TaskDto> listTasks(UUID taskListId);
    TaskDto createTask(UUID taskListId, TaskDto taskDto);
    Optional<TaskDto> getTaskById(UUID taskListId, UUID taskId);
}
