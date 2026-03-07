package com.devtry.tasks.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.devtry.tasks.domain.dto.TaskDto;

public interface TaskService {
  List<TaskDto> listTasks(UUID taskListId);

  TaskDto createTask(UUID taskListId, TaskDto taskDto);

  Optional<TaskDto> getTaskById(UUID taskListId, UUID taskId);

  TaskDto updateTask(UUID taskListId, UUID taskId, TaskDto taskDto);
}
