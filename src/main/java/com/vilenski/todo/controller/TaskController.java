package com.vilenski.todo.controller;

import com.vilenski.todo.entity.Task;
import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.service.TaskListService;
import com.vilenski.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;
    private final TaskListService taskListService;

    @PostMapping("/tasklists/{taskListId}/tasks")
    public String addTaskToTaskList(@PathVariable UUID taskListId,
                                    @RequestParam String description) {
        TaskList taskList = taskListService.getTaskListById(taskListId).get();
        Task task = Task.builder().description(description).completed(false).taskList(taskList).build();
        taskService.addTask(task, taskListId);
        return "redirect:/tasklists";
    }

    @GetMapping("/tasks/{id}/edit")
    public String showEditTaskForm(@PathVariable UUID id, Model model) {
        Task task = taskService.getTaskById(id).get();
        model.addAttribute("task", task);
        return "edit-task";
    }


    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable UUID id,
                             @ModelAttribute Task task) {
        taskService.updateTask(id, task);
        return "redirect:/tasklists";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable UUID id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasklists";
    }
}