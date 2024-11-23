package com.vilenski.todo.service;

import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.repository.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public Optional<TaskList> getTaskListById(UUID id) {
        return taskListRepository.findTaskListById(id);
    }

    @Override
    public List<TaskList> getTaskListsByCustomerId(UUID customerId) {

        return taskListRepository.findTaskListByCustomerId(customerId);

    }

    @Override
    public TaskList saveTaskList(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public Boolean deleteTaskListById(UUID listId) {
        if (taskListRepository.existsById(listId)) {
            taskListRepository.delete(taskListRepository.findTaskListById(listId).get());
            return true;
        }else
            return false;
    }
}//todo: this is persistance, check
/*    public void addTaskToTaskList(UUID taskListId, String description) {
        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new RuntimeException("TaskList not found"));

        Task task = new Task();
        task.setDescription(description);
        task.setTaskList(taskList);

        taskRepository.save(task);
    }*/

