package com.devtry.tasks.mappers;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
