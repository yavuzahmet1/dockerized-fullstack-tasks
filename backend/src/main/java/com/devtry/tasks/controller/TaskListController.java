package com.devtry.tasks.controller;

import com.devtry.tasks.domain.dto.TaskListDto;
import com.devtry.tasks.mappers.TaskListMapper;
import com.devtry.tasks.services.TaskListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/task-list")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> getTaskLists() {
        return taskListService.taskListLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
