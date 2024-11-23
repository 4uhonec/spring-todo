package com.vilenski.todo.mapper;

import com.vilenski.todo.dto.TaskListDTO;
import com.vilenski.todo.entity.Customer;
import com.vilenski.todo.entity.Task;
import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.service.CustomerService;
import com.vilenski.todo.service.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TaskListDTOMapper {

    private final CustomerService customerService;
    private final TaskServiceImpl taskService;

    public TaskList mapTaskListDTOToTaskList(TaskListDTO taskListDTO) {

        Customer customer = customerService.getCustomerById(taskListDTO.getCustomerId()).get();
        Set<Task> tasks = new HashSet<>(taskService.getTasksByTaskListId(taskListDTO.getId()));

        return TaskList.builder()
                .id(taskListDTO.getId())
                .title(taskListDTO.getTitle())
                .customer(customer)
                .tasks(tasks)
                .build();
    }

    public TaskListDTO mapTaskListToTaskListDTO(TaskList taskList) {
        return TaskListDTO.builder()
                .id(taskList.getId())
                .title(taskList.getTitle())
                .customerId(taskList.getCustomer().getId())
                .build();
    }

}
