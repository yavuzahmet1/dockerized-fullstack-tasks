package com.devtry.tasks.services;

import com.devtry.tasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> taskListLists();
    TaskList createTaskList(TaskList taskList);

}
