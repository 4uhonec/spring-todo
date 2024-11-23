package com.vilenski.todo.repository;

import com.vilenski.todo.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskList, UUID> {

    Optional<TaskList> findTaskListById(UUID id);
    Boolean deleteTaskListById(UUID id);
    List<TaskList> findTaskListByCustomerId(UUID customerId);

}

