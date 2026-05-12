package com.app.todo.services;

import com.app.todo.models.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getallTasks() {
        return taskRepository.findAll();
    }


    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleated(false);
        taskRepository.save(task);


    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid task id "));
        task.setCompleated(!task.isCompleated());
        taskRepository.save(task);


    }
}
