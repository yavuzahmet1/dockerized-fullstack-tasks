package com.devtry.tasks.controller;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.domain.entities.Task;
import com.devtry.tasks.mappers.TaskMapper;
import com.devtry.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{taskListId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }
    @GetMapping
    public List<TaskDto> listTasks(@PathVariable UUID taskListId) {
        return taskService.listTasks(taskListId);
    }

    @PostMapping
    public TaskDto createTask(@PathVariable UUID taskListId, @RequestBody TaskDto taskDto) {
        return taskService.createTask(taskListId, taskDto);
    }
    @GetMapping(path = "/{taskId}")
    public Optional<TaskDto> getTaskById(@PathVariable UUID taskListId, @PathVariable UUID taskId) {
        return taskService.getTaskById(taskListId, taskId);
    }
}
