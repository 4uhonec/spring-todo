package com.vilenski.todo.service;

import com.vilenski.todo.entity.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {

    List<TaskList> getAllTaskLists();
    Optional<TaskList> getTaskListById(UUID id);
    TaskList saveTaskList(TaskList taskList);
    Boolean deleteTaskListById(UUID id);
    List<TaskList> getTaskListsByCustomerId(UUID customerId);

}

