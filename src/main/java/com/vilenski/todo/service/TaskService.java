package com.vilenski.todo.service;

import com.vilenski.todo.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTasks();
    Optional<Task> getTaskById(UUID id);
    List<Task> getTasksByTaskListId(UUID taskListId);
    Boolean deleteTaskById(UUID id);
    Task addTask(Task task, UUID taskListId);
    Task updateTask(UUID id, Task task);
    Task setCompletedTask(UUID id);

}

