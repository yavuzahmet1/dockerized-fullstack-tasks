package com.devtry.tasks.services.Impl;

import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.repositories.TaskListRepository;
import com.devtry.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
