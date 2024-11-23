package com.vilenski.todo.mapper;

import com.vilenski.todo.dto.TaskDTO;
import com.vilenski.todo.entity.Task;
import com.vilenski.todo.service.TaskListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskDTOMapper {

    private final TaskListServiceImpl taskListService;

    public Task mapToTask(TaskDTO taskDTO) {
        return Task.builder()
                .id(taskDTO.getId())
                .description(taskDTO.getDescription())
                .completed(taskDTO.getCompleted())
                .taskList(taskListService.getTaskListById(taskDTO.getTaskListId()).get())//todo: handle null
                .build();
    }

    public TaskDTO mapToTaskDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .taskListId(task.getTaskList().getId())
                .build();
    }

}
