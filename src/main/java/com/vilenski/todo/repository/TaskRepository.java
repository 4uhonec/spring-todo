package com.vilenski.todo.repository;

import com.vilenski.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findTasksByTaskListId(UUID taskListId);
    Optional<Task> findTaskById(UUID taskId);
    Boolean deleteTaskById(UUID taskId);

}
