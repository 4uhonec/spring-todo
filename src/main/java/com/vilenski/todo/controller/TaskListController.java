package com.vilenski.todo.controller;

import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasklists")
public class TaskListController {

    private final TaskListService taskListService;

    @GetMapping
    public String viewTaskLists(Model model) {
        List<TaskList> taskLists = taskListService.getAllTaskLists();
        model.addAttribute("taskLists", taskLists);
        return "tasklists";
    }

    @GetMapping("/add")
    public String showAddTaskListForm(Model model) {
        model.addAttribute("taskList", new TaskList());
        return "add-tasklist";
    }

    @PostMapping
    public String addTaskList(@ModelAttribute TaskList taskList) {
        taskListService.saveTaskList(taskList);
        return "redirect:/tasklists";
    }

    @PostMapping("/{id}/delete")
    public String deleteTaskList(@PathVariable UUID id) {
        taskListService.deleteTaskListById(id);
        return "redirect:/tasklists";
    }
}
