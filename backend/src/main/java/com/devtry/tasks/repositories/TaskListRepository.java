package com.devtry.tasks.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devtry.tasks.domain.entities.Task;
import com.devtry.tasks.domain.entities.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
  Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);
}
