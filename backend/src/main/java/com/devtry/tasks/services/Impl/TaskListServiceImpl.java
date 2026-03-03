package com.devtry.tasks.services.Impl;

import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.repositories.TaskListRepository;
import com.devtry.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now));
        return null;
    }

    @Override
    public Optional<TaskList> getTaskListById(UUID taskListId) {
        return taskListRepository.findById(taskListId);
    }

}
