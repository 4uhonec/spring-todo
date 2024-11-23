package com.vilenski.todo.controller;

import com.vilenski.todo.entity.TaskList;
import com.vilenski.todo.repository.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final TaskListRepository taskListRepository;

    @GetMapping("/")
    public String index(Model model){
        List<TaskList> taskLists = taskListRepository.findAll();
        model.addAttribute("taskLists", taskLists);

        return "tasklists";
    }

}

