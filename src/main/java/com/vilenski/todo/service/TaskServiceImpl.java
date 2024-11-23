package com.vilenski.todo.service;

import com.vilenski.todo.entity.Task;
import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.repository.TaskListRepository;
import com.vilenski.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findTaskById(id);
    }

    @Override
    public List<Task> getTasksByTaskListId(UUID taskListId) {
        return taskRepository.findTasksByTaskListId(taskListId);
    }

    @Override
    public Boolean deleteTaskById(UUID id) {
        if(taskRepository.existsById(id)){
            Optional<Task> optionalTask = taskRepository.findTaskById(id);
            if(optionalTask.isEmpty()){
                return false;
            }
            Task task = taskRepository.findTaskById(id).get();
            taskRepository.delete(task);
            return true;
        }
        return false;
    }

    @Override
    public Task addTask(Task task, UUID taskListId) {
        return taskRepository.save(task);
    }

    @Override//todo: update, create, delete -> T, findBy.. -> Optional<T>
    public Task updateTask(UUID id, Task task) {
        Optional<Task> optionalTask = taskRepository.findTaskById(id);
        if(optionalTask.isEmpty()){
            throw new RuntimeException("Task not found");
        }
        optionalTask.get().setDescription(task.getDescription());

        return taskRepository.save(optionalTask.get());

    }

    @Override
    public Task setCompletedTask(UUID id) {
        Optional<Task> optionalTask = taskRepository.findTaskById(id);
        if(optionalTask.isEmpty()){
            throw new RuntimeException("Task not found");
        }

        Task task = optionalTask.get();
        task.setCompleted(true);
        return updateTask(id, task);
    }
}
