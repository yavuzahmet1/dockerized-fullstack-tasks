package com.devtry.tasks.services.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.repositories.TaskListRepository;
import com.devtry.tasks.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {

  private final TaskListRepository taskListRepository;

  public TaskListServiceImpl(TaskListRepository taskListRepository) {

    this.taskListRepository = taskListRepository;
  }

  @Override
  public List<TaskList> taskListLists() {

    return taskListRepository.findAll();
  }

  @Override
  public TaskList createTaskList(TaskList taskList) {
    if (null != taskList.getId()) {
      throw new IllegalArgumentException("Task list already exists!");
    }
    if (null == taskList.getTitle() || taskList.getTitle().isBlank()) {
      throw new IllegalArgumentException("Task list title must be present!");
    }
    LocalDateTime now = LocalDateTime.now();
    taskListRepository
        .save(new TaskList(null, taskList.getTitle(), taskList.getDescription(), null, now, now));
    return null;
  }

  @Override
  public Optional<TaskList> getTaskListById(UUID taskListId) {
    return taskListRepository.findById(taskListId);
  }

  @Override
  public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
    if (null == taskList.getId()) {
      throw new IllegalArgumentException("Task list id must be present!");
    }
    if (!Objects.equals(taskList.getId(), taskListId)) {
      throw new IllegalArgumentException("Task list id does not match!");
    }
    TaskList existingTaskList = taskListRepository.findById(taskListId)
        .orElseThrow(() -> new IllegalArgumentException("Task list does not exists!"));
    existingTaskList.setTitle(taskList.getTitle());
    existingTaskList.setDescription(taskList.getDescription());
    existingTaskList.setUpdatedAt(taskList.getUpdatedAt());
    return taskListRepository.save(existingTaskList);

  }

  @Override
  public void deleteTaskListById(UUID taskListId) {
    taskListRepository.deleteById(taskListId);
  }

}
