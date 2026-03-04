package com.devtry.tasks.controller;

import com.devtry.tasks.domain.dto.TaskListDto;
import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.mappers.TaskListMapper;
import com.devtry.tasks.services.TaskListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(path = "/task-list")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListMapper taskListMapper, TaskListService taskListService) {
        this.taskListMapper = taskListMapper;
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskListDto> getTaskLists() {
        return taskListService.taskListLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{taskListId}")
    public Optional<TaskListDto> getTaskList(@PathVariable("taskListId")UUID taskListId) {
     return taskListService.getTaskListById(taskListId)
             .map(taskListMapper::toDto);
    }
    @PutMapping(path = "/{taskListId}")
    public TaskListDto updateTaskList(@PathVariable("taskListId") UUID taskListId ,@RequestBody TaskListDto taskListDto) {
        TaskList updatedTaskList=taskListService.updateTaskList(
                taskListId,
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(updatedTaskList);
    }
}
