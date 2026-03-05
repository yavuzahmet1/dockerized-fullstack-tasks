package com.devtry.tasks.services.Impl;

import com.devtry.tasks.domain.dto.TaskDto;
import com.devtry.tasks.domain.entities.Task;
import com.devtry.tasks.domain.entities.TaskList;
import com.devtry.tasks.domain.entities.TaskPriority;
import com.devtry.tasks.domain.entities.TaskStatus;
import com.devtry.tasks.mappers.TaskMapper;
import com.devtry.tasks.repositories.TaskListRepository;
import com.devtry.tasks.repositories.TaskRepository;
import com.devtry.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskDto> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public TaskDto createTask(UUID taskListId, TaskDto taskDto) {
        if (null != taskDto.id()) {
            throw new IllegalArgumentException("Task already exists!");
        }
        if (taskDto.title() == null || taskDto.title().isBlank()) {
            throw new IllegalArgumentException("Task title required!");
        }
        TaskPriority taskPriority=Optional.ofNullable(taskDto.priority())
                .orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus=TaskStatus.OPEN;

        TaskList taskList=taskListRepository.findById(taskListId).orElseThrow(()->new IllegalArgumentException("Invalid task listId!"));

        Task taskToSave=new Task(
                null,taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskStatus,taskPriority,taskList
        );
        taskRepository.save(taskToSave);
        return taskMapper.toDto(taskToSave);
    }


}
