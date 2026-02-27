package com.devtry.tasks.services;

import com.devtry.tasks.domain.entities.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface TaskListService {
List<TaskList> taskListLists();
}
