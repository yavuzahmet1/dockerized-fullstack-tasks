package com.devtry.tasks.controller;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.mappers.TaskMapper;
import com.devtry.tasks.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists/{taskListId}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
    @GetMapping
    public List<TaskDto> listTasks(@PathVariable UUID taskListId) {
        return taskService.listTasks(taskListId);
    }
}
