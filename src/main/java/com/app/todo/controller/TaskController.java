package com.app.todo.controller;

import com.app.todo.models.Task;
import com.app.todo.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskServices ts;

    public TaskController(TaskServices ts) {
        this.ts = ts;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = ts.getallTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        ts.createTask(title);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/delete")    //here we can remove the delete
    public String deleteTask(@PathVariable Long id){
       ts.deleteTask(id);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/toggle")    //here we can remove the delete
    public String toggleTask(@PathVariable Long id) {
        ts.toggleTask(id);
        return "redirect:/tasks";
    }

}
