package com.devtry.tasks.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.services.TaskService;

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

  @PutMapping(path = "/{taskId}")
  public TaskDto updateTask(@PathVariable UUID taskListId, @PathVariable UUID taskId,
      @RequestBody TaskDto taskDto) {

    return taskService.updateTask(taskListId, taskId, taskDto);
  }

  @DeleteMapping(path = "/{taskId}")
  public void deleteTask(@PathVariable UUID taskListId, @PathVariable UUID taskId) {
    taskService.deleteTask(taskListId, taskId);

  }
}
