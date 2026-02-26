package com.devtry.tasks.mappers.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devtry.tasks.domain.dto.TaskListDto;
import com.devtry.tasks.domain.entities.Task;
import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.domain.entities.TaskStatus;
import com.devtry.tasks.mappers.TaskListMapper;
import com.devtry.tasks.mappers.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList())
                        .orElse(null),
                null, null);

    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto)
                                .collect(Collectors.toList()))
                        .orElse(null));
    }

    private Double calculateProgress(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return 0.0;
        }
        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED.equals(task.getStatus()))
                .count();

        return (double) closedTaskCount / tasks.size() * 100;
    }

}
