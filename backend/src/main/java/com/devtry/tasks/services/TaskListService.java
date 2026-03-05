package com.devtry.tasks.services;

import com.devtry.tasks.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> taskListLists();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList> getTaskListById(UUID taskListId);
    TaskList updateTaskList(UUID taskListId, TaskList taskList);
    void deleteTaskListById(UUID taskListId);

}
