package com.devtry.tasks.mappers;

import com.devtry.tasks.domain.dto.TaskListDto;
import com.devtry.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}