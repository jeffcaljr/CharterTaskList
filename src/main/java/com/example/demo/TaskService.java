package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Component
public class TaskService {

    public TaskService(){}

    @Autowired
    private TaskRepository repository;

    public Iterable<Task> getAllTasks(){
         return repository.findAll();
    }

    public void deleteTask(long taskId){
        repository.deleteById(taskId);
    }

    public Task getTaskById(long id) throws TaskNotFoundException{

        Task foundTask = repository.findById(id).orElseThrow(TaskNotFoundException::new);

        return foundTask;
    }

    public void updateTaskWithId(long id, String taskString) throws TaskNotFoundException{

        Task foundTask = repository.findById(id).orElseThrow(TaskNotFoundException::new);

        foundTask.setTask(taskString);

        repository.save(foundTask);
    }

    public void saveNewTask(String taskString, Date date){
        Task newTask = new Task(taskString, date);
        repository.save(newTask);
    }
}
